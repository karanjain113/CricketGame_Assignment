package matchC;

public class CricketMatch {
    public enum Decision{Bat, Ball};
    private Innings firstInning =new Innings();
    private Innings secondInning =new Innings();
    private String tossWonBy;
    private Decision decisionTaken;
    private int target;
    private String matchWonBy ="";
    private Team teamA;
    private Team teamB;

//    public void matchScore()
//    {
//        //        Innings 1 score details.
//        score=score+ teamA.getName()+"  "+Integer.toString(firstInning.getRunsScored())+"/"+Integer.toString(firstInning.getWicketsFallen())+" in ";
//
//        if(firstInning.getBallsPlayed()%6==0)
//        {
//            score=score+Integer.toString(firstInning.getBallsPlayed()/6)+" overs.";
//        }
//        else{
//            score=score+Integer.toString(firstInning.getBallsPlayed()/6)+"."+Integer.toString(firstInning.getBallsPlayed()%6)+ " overs.<br>";
//        }
////        Innings 2 score details.
//        score=score+ teamB.getName()+"  "+Integer.toString(secondInning.getRunsScored())+"/"+Integer.toString(secondInning.getWicketsFallen())+" in ";
//        if(secondInning.getBallsPlayed()%6==0)
//        {
//            score=score+Integer.toString(secondInning.getBallsPlayed()/6)+" overs.";
//        }
//        else{
//            score=score+Integer.toString(secondInning.getBallsPlayed()/6)+"."+Integer.toString(secondInning.getBallsPlayed()%6)+ " overs. <br ><br>";
//        }
//    }
    public Innings getFirstInning() {
        return firstInning;
    }

    public Innings getSecondInning() {
        return secondInning;
    }

    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public String getTossWonBy() {
        return tossWonBy;
    }

    public Decision getDecisionTaken() {
        return decisionTaken;
    }

    public String getMatchWonBy() {
        return matchWonBy;
    }

    public void setTossWonBy(String tossWonBy) {
        this.tossWonBy = tossWonBy;
    }

    public void setDecisionTaken(Decision decisionTaken) {
        this.decisionTaken = decisionTaken;
    }

    public void setFirstInning(Innings firstInning) {
        this.firstInning = firstInning;
    }

    public void setSecondInning(Innings secondInning) {
        this.secondInning = secondInning;
    }

    public void setMatchWonBy(String matchWonBy) {
        this.matchWonBy = matchWonBy;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void init(String teamA, String teamB, int overs) {
        this.teamA=new Team(teamA);
        this.teamB=new Team(teamB);
//        Innings.totalOvers=overs;
        firstInning.setTotalOvers(overs);
        secondInning.setTotalOvers(overs);
    }
}
