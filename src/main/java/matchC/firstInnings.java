package matchC;

import java.util.Random;

class firstInnings extends Innings{


    @Override void startInnings(Team battingTeam, Team bowlingTeam)
    {
        this.battingTeam=battingTeam.getName();
        this.bowlingTeam=bowlingTeam.getName();
        int strikeBatsman=0,currentBowler=0,nonStrikeBatsman=1;
        for(int j = 0; j<totalOvers; j++){
            currentBowler%=11;
            if(currentBowler==0)
            {
                currentBowler+=5;
            }
            int runsThisOver=0;
            for(int i=0;i<6;i++)
            {
                balls++;
                Integer x=battingTeam.teamList[strikeBatsman].getBattingStats().getBallsPlayed()+1;
                battingTeam.teamList[strikeBatsman].getBattingStats().setBallsPlayed(x);
                x=bowlingTeam.teamList[currentBowler].getBowlingStats().getBallsBowled()+1;
                bowlingTeam.teamList[currentBowler].getBowlingStats().setBallsBowled(x);
                Random rand=new Random();
                int next=rand.nextInt(8);
                if(next==7)
                {
                    x= bowlingTeam.teamList[currentBowler].getBowlingStats().getWicketsTaken()+1;
                    bowlingTeam.teamList[currentBowler].getBowlingStats().setWicketsTaken(x);
                    wickets++;
                    strikeBatsman=wickets+1;
                }
                else{
                    runsThisOver+=next;
                    x=battingTeam.teamList[strikeBatsman].getBattingStats().getRunsScored();
                    battingTeam.teamList[strikeBatsman].getBattingStats().setRunsScored(x+next);
                    x= bowlingTeam.teamList[currentBowler].getBowlingStats().getRunsGiven()+next;
                    bowlingTeam.teamList[currentBowler].getBowlingStats().setRunsGiven(x);
                    if(next==4 || next==6)
                    {
                        x=battingTeam.teamList[strikeBatsman].getBattingStats().getBoundariesHit()+1;
                        battingTeam.teamList[strikeBatsman].getBattingStats().setBoundariesHit(x);
                    }
                    if(next%2==1)
                    {
                        int temp=strikeBatsman;
                        strikeBatsman=nonStrikeBatsman;
                        nonStrikeBatsman=temp;
                    }
                    runs+=next;
                }
                if(wickets==10)
                {
                    break;
                }
            }
            if(balls%6==0 && runsThisOver==0)
            {
                Integer temp= bowlingTeam.teamList[currentBowler].getBowlingStats().getMaidens()+1;
                bowlingTeam.teamList[currentBowler].getBowlingStats().setMaidens(temp);
            }
            if(wickets==10)
            {
                break;
            }
            int temp=strikeBatsman;
            strikeBatsman=nonStrikeBatsman;
            nonStrikeBatsman=temp;
            currentBowler++;
        }
        if(balls%6==0)
        {
            oversBowled+=Integer.toString(balls/6);
        }
        else{
            oversBowled+=Integer.toString(balls/6)+"."+Integer.toString(balls%6);
        }
        battingTeam.getStats().setRunsScored(runs);
        battingTeam.getStats().setWicketsFallen(wickets);
    }


}
