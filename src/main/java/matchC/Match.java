package matchC;



public class Match {
    private Innings firstInning =new Innings();
    private Innings secondInning =new Innings();
    private String tossWon;
    private String toss="",decision="",result="";
    private Team teamA;
    private Team teamB;

//    Default Constructor
    public Match()
    {
        this.teamA=new Team("RandomTeam1");
        this.teamB=new Team("RandomTeam2");
        Innings.totalOvers =50;
    }
//    Parametrized Constructor
    public Match(String teamA, String teamB, int overs)
    {
        this.teamA=new Team(teamA);
        this.teamB=new Team(teamB);
        Innings.totalOvers =overs;
    }

    public Innings getFirstInning() {
        return firstInning;
    }

    public Innings getSecondInning() {
        return secondInning;
    }

    public void startMatch()
    {
        doToss();
        makeDecision();
        firstInning.startInnings(teamA, teamB,1);
        secondInning.setTarget(firstInning.getRunsScored()+1);
        secondInning.startInnings(teamB, teamA,2);
        matchResult();
    }
    void doToss()
    {
        if(Math.random()<0.5)
        {
            toss = toss + teamA.getName() +" won the toss and ";
            tossWon= teamA.getName();
        }
        else{
            toss = toss + teamB.getName() +" won the toss and ";
            tossWon= teamB.getName();
        }
    }
    void makeDecision()
    {
        if(Math.random()<0.5)
        {
            decision = decision+" elected to bat first.";
            if(tossWon.equals(teamB.getName()))
            {
                Team temp= teamB;
                teamB = teamA;
                teamA =temp;
            }
        }
        else{
            decision = decision+" elected to ball first.";
            if(tossWon.equals(teamA.getName()))
            {
                Team temp= teamB;
                teamB = teamA;
                teamA =temp;
            }
        }
    }
    public void matchResult()
    {
//        Result declaration.
        if(secondInning.getRunsScored()>firstInning.getRunsScored())
        {
            result = result + teamB.getName()+" Won the match by "+Integer.toString(10- secondInning.getWicketsFallen())+" wickets";

        }
        else if(secondInning.getRunsScored().equals(firstInning.getRunsScored()))
        {
            result = result +"Match was Draw";
        }
        else{
            result = result + teamA.getName()+" Won the match by "+Integer.toString(firstInning.getRunsScored()- secondInning.getRunsScored())+" runs";
        }
    }
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

    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public String getTossWon() {
        return tossWon;
    }

    public String getDecision() {
        return decision;
    }

    public String getResult() {
        return result;
    }

}
