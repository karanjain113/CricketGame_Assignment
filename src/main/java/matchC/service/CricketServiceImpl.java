package matchC.service;

import matchC.CricketMatch;

import matchC.Innings;
import matchC.Player;
import matchC.Team;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CricketServiceImpl implements GameService {

    @Override
    public CricketMatch play(String teamA, String teamB, String overs) {
        CricketMatch match = new CricketMatch();
        match.init(teamA, teamB, Integer.parseInt(overs));
        startMatch(match);
        return match;
    }
    public void startMatch(CricketMatch match)
    {
        doToss(match);
        makeDecision(match);
        startInnings(match.getTeamA(),match.getTeamB(),1,match.getFirstInning(),match);
        int newTarget=match.getFirstInning().getRunsScored()+1;
        match.setTarget(newTarget);
        startInnings(match.getTeamB(),match.getTeamA(),2,match.getSecondInning(), match);
//        matchResult();
    }
    void doToss(CricketMatch match)
    {
        if(Math.random()<0.5)
        {
            match.setTossWonBy(match.getTeamA().getName());
        }
        else{
            match.setTossWonBy(match.getTeamB().getName());
        }
    }
    void makeDecision(CricketMatch match)
    {
        if(Math.random()<0.5)
        {
            match.setDecisionTaken(CricketMatch.Decision.Bat);
            if(match.getTossWonBy().equals(match.getTeamB().getName()))
            {
                Team temp= match.getTeamB();
                match.setTeamB(match.getTeamA());
                match.setTeamA(temp);
            }
        }
        else{
            match.setDecisionTaken(CricketMatch.Decision.Ball);
            if(match.getTossWonBy().equals(match.getTeamA().getName()))
            {
                Team temp= match.getTeamB();
                match.setTeamB(match.getTeamA());
                match.setTeamA(temp);
            }
        }
    }

    public void startInnings(Team battingTeam, Team bowlingTeam, int inningsNumber, Innings innings, CricketMatch match)
    {
        innings.setBattingTeam(battingTeam.getName());
        innings.setBowlingTeam(bowlingTeam.getName());
        innings.setStrikeBatsman(battingTeam.getTeamList()[0]);
        innings.setNonStrikeBatsman(battingTeam.getTeamList()[1]);
        int currentBowlerIndex=0;
        for(int j = 0; j<innings.getTotalOvers(); j++){
            currentBowlerIndex=chooseNextBowler(currentBowlerIndex);
            innings.setCurrentBowler(bowlingTeam.getTeamList()[currentBowlerIndex]);
            int runsThisOver=0;
            for(int i=0;i<6;i++)
            {
                runsThisOver+=playNextBall(battingTeam,bowlingTeam,innings);
                if(innings.getWicketsFallen()==10)
                {
                    break;
                }
                if(inningsNumber==2 && innings.getRunsScored()>=match.getTarget())
                {
                    break;
                }
            }
            if(innings.getBallsPlayed() %6==0 && runsThisOver==0)
            {
                int temp=innings.getCurrentBowler().getBowlingStats().getMaidens();
                innings.getCurrentBowler().getBowlingStats().setMaidens(temp+1);
            }
            if(innings.getWicketsFallen() ==10)
            {
                break;
            }
            if(inningsNumber==2 && innings.getRunsScored()>=match.getTarget())
            {
                break;
            }
            swapStrike(innings);
            currentBowlerIndex++;
        }
//        if(innings.getBallsPlayed() %6==0)
//        {
//            oversBowled+=Integer.toString(innings.getBallsPlayed() /6);
//        }
//        else{
//            oversBowled+=Integer.toString(innings.getBallsPlayed() /6)+"."+Integer.toString(innings.getBallsPlayed() %6);
//        }
        battingTeam.getStats().setRunsScored(innings.getRunsScored());
        battingTeam.getStats().setWicketsFallen(innings.getWicketsFallen());
    }

    private int playNextBall(Team battingTeam, Team bowlingTeam,Innings innings) {
        updateBallsStats(innings);
        Random rand=new Random();
        int next = rand.nextInt(8);
//        Condition for wicket
        if(next==7)
        {
            int temp=innings.getCurrentBowler().getBowlingStats().getWicketsTaken()+1;
            innings.getCurrentBowler().getBowlingStats().setWicketsTaken(temp);
            innings.setWicketsFallen(innings.getWicketsFallen()+1);
            innings.setStrikeBatsman(battingTeam.getTeamList()[innings.getWicketsFallen()]);
        }
        else{
            int temp=innings.getStrikeBatsman().getBattingStats().getRunsScored();
            innings.getStrikeBatsman().getBattingStats().setRunsScored(temp+next);
            temp=innings.getCurrentBowler().getBowlingStats().getRunsGiven()+next;
            innings.getCurrentBowler().getBowlingStats().setRunsGiven(temp+next);
            if(next==4 || next==6)
            {
                temp=innings.getStrikeBatsman().getBattingStats().getBoundariesHit()+1;
                innings.getStrikeBatsman().getBattingStats().setBoundariesHit(temp+1);
            }
            if(next%2==1)
            {
                swapStrike(innings);
            }
            temp=innings.getRunsScored();
            innings.setRunsScored(temp+next);
        }
        return next;
    }

    private void updateBallsStats(Innings innings) {
        innings.setBallsPlayed(innings.getBallsPlayed()+1);
        innings.getStrikeBatsman().getBattingStats().setBallsPlayed(innings.getStrikeBatsman().getBattingStats().getBallsPlayed()+1);
        innings.getCurrentBowler().getBowlingStats().setBallsBowled(innings.getCurrentBowler().getBowlingStats().getBallsBowled()+1);
    }

    public void swapStrike(Innings innings)
    {
        Player temp2=innings.getStrikeBatsman();
        innings.setStrikeBatsman(innings.getNonStrikeBatsman());
        innings.setNonStrikeBatsman(temp2);
    }

    public int chooseNextBowler(int currentBowler) {
        currentBowler%=11;
        if(currentBowler==0)
        {
            currentBowler+=5;
        }
        return currentBowler;
    }
//    public void matchResult()
//    {
////        Result declaration.
//        if(secondInning.getRunsScored()>firstInning.getRunsScored())
//        {
//            matchWonBy = matchWonBy + teamB.getName()+" Won the match by "+Integer.toString(10- secondInning.getWicketsFallen())+" wickets";
//
//        }
//        else if(secondInning.getRunsScored().equals(firstInning.getRunsScored()))
//        {
//            matchWonBy = matchWonBy +"Match was Draw";
//        }
//        else{
//            matchWonBy = matchWonBy + teamA.getName()+" Won the match by "+Integer.toString(firstInning.getRunsScored()- secondInning.getRunsScored())+" runs";
//        }
//    }
}
