package matchC.service;

import matchC.CricketMatch;

import matchC.Innings;
import matchC.Player;
import matchC.Team;
import matchC.utils.Utilities;
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
        Utilities.doToss(match);
        Utilities.makeDecision(match);
        startInnings(match.getTeamA(),match.getTeamB(),1,match.getFirstInning(),match);
        int newTarget=match.getFirstInning().getRunsScored()+1;
        match.setTarget(newTarget);
        startInnings(match.getTeamB(),match.getTeamA(),2,match.getSecondInning(), match);
        matchResult(match);
    }

    public void startInnings(Team battingTeam, Team bowlingTeam, int inningsNumber, Innings innings, CricketMatch match)
    {
        innings.setBattingTeam(battingTeam.getName());
        innings.setBowlingTeam(bowlingTeam.getName());
        innings.setStrikeBatsman(battingTeam.getTeamList().get(0));
        innings.setNonStrikeBatsman(battingTeam.getTeamList().get(1));
        int currentBowlerIndex=0;
        for(int j = 0; j<innings.getTotalOvers(); j++){
            currentBowlerIndex=chooseNextBowler(currentBowlerIndex);
            innings.setCurrentBowler(bowlingTeam.getTeamList().get(currentBowlerIndex));
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
        int next = generateNextRandomBall(innings.getStrikeBatsman(),innings.getCurrentBowler());
//        Condition for wicket
        if(next==7)
        {
            int temp=innings.getCurrentBowler().getBowlingStats().getWicketsTaken()+1;
            innings.getCurrentBowler().getBowlingStats().setWicketsTaken(temp);
            innings.setWicketsFallen(innings.getWicketsFallen()+1);
            innings.setStrikeBatsman(battingTeam.getTeamList().get(innings.getWicketsFallen()));
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
        int temp=innings.getBallsPlayed();
        innings.setBallsPlayed(temp+1);
        temp=innings.getStrikeBatsman().getBattingStats().getBallsPlayed();
        innings.getStrikeBatsman().getBattingStats().setBallsPlayed(temp+1);
        temp=innings.getCurrentBowler().getBowlingStats().getBallsBowled();
        innings.getCurrentBowler().getBowlingStats().setBallsBowled(temp+1);
    }

    public void swapStrike(Innings innings)
    {
        Player temp2=innings.getStrikeBatsman();
        innings.setStrikeBatsman(innings.getNonStrikeBatsman());
        innings.setNonStrikeBatsman(temp2);
    }

    public int generateNextRandomBall(Player batsman, Player bowler)
    {
        float batsmanRating=batsman.getBattingRating();
        float bowlerRating=bowler.getBowlingRating();
//        Probability of Wicket falling
        float ratio=bowlerRating/batsmanRating;
        if(ratio>=1)
        {
            float threshold= (float) (((0.05)/9.0)*(ratio-1.0)+0.05);
            if(Math.random()<=threshold)
            {
                return 7;
            }
        }
        else{
            float threshold= (float) (((0.045)/9.0)*(1-(1/ratio))+0.05);
//            System.out.println(ratio);
            if(Math.random()<=threshold)
            {
                return 7;
            }
        }
        Random rand=new Random();
        return rand.nextInt(7);
    }
    public int chooseNextBowler(int currentBowler) {
        currentBowler%=11;
        if(currentBowler==0)
        {
            currentBowler+=5;
        }
        return currentBowler;
    }

    public void matchResult(CricketMatch match)
    {
        StringBuilder str=new StringBuilder();
//        Result declaration.
        if(match.getSecondInning().getRunsScored()>match.getFirstInning().getRunsScored())
        {
            str.append(match.getTeamB().getName()).append(" Won the match by ").append(10- match.getSecondInning().getWicketsFallen()).append(" wickets");
//            matchWonBy = matchWonBy + ;

        }
        else if(match.getSecondInning().getRunsScored()==match.getFirstInning().getRunsScored())
        {
            str.append("Match was Draw");
//            matchWonBy = matchWonBy +;
        }
        else{
            str.append(match.getTeamA().getName()).append(" Won the match by ").append(10- match.getFirstInning().getWicketsFallen()).append(" wickets");
//            matchWonBy = matchWonBy + teamA.getName()+" Won the match by "+Integer.toString(firstInning.getRunsScored()- secondInning.getRunsScored())+" runs";
        }
        match.setMatchResult(str.toString());
    }
}
