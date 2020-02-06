package matchC.utils;

import matchC.CricketMatch;
import matchC.Team;

public class Utilities {
    public static void doToss(CricketMatch match)
    {
        if(Math.random()<0.5)
        {
            match.setTossWonBy(match.getTeamA().getName());
        }
        else{
            match.setTossWonBy(match.getTeamB().getName());
        }
    }
    public static void makeDecision(CricketMatch match)
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
}
