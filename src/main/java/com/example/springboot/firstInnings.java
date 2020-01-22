package com.example.springboot;

import java.util.Random;

public class firstInnings extends Innings{


    @Override void startInnings(Team battingTeam, Team bowlingTeam)
    {
        int strikeBatsman=0,currentBowler=0,nonStrikeBatsman=1;
        for(int j = 0; j<totalOvers; j++){
            currentBowler%=11;
            if(currentBowler==0)
            {
                currentBowler+=5;
            }
            int runsThisOver=0;
            for(int i=1;i<=6;i++)
            {
                balls++;
                Integer x=battingTeam.teamList[strikeBatsman].getBallsPlayed()+1;
                battingTeam.teamList[strikeBatsman].setBallsPlayed(x);
                x=bowlingTeam.teamList[currentBowler].getBallsBowled()+1;
                bowlingTeam.teamList[currentBowler].setBallsBowled(x);
                Random rand=new Random();
                int next=rand.nextInt(8);
                if(next==7)
                {
                    x= bowlingTeam.teamList[currentBowler].getWicketsTaken()+1;
                    bowlingTeam.teamList[currentBowler].setWicketsTaken(x);
                    wickets++;
                    strikeBatsman=wickets+1;
                }
                else{
                    x=battingTeam.teamList[strikeBatsman].getRunsScored();
                    battingTeam.teamList[strikeBatsman].setRunsScored(x+next);
                    x= bowlingTeam.teamList[currentBowler].getRunsGiven()+next;
                    bowlingTeam.teamList[currentBowler].setRunsGiven(x);
                    if(next==4 || next==6)
                    {
                        x=battingTeam.teamList[strikeBatsman].getBoundariesHit()+1;
                        battingTeam.teamList[strikeBatsman].setBoundariesHit(x);
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
                Integer temp= bowlingTeam.teamList[currentBowler].getMaidens()+1;
                bowlingTeam.teamList[currentBowler].setMaidens(temp);
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
    }

}
