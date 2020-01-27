package matchC;



public class Match {
    private Innings firstInning =new Innings();
    private Innings secondInning =new Innings();
    private String tossWon;
    private String result="",toss="",decision="",score="",scoreCard="";
    private String res="";
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
    public String matchResult()
    {
        matchScore();
//        Result declaration.
        if(secondInning.getRunsScored()>firstInning.getRunsScored())
        {
//            result=result+ teamB.getName()+" Won the match by "+Integer.toString(10- secondInning.wickets)+" wickets";
            res=res+ teamB.getName()+" Won the match by "+Integer.toString(10- secondInning.getWicketsFallen())+" wickets";

        }
        else if(secondInning.getRunsScored().equals(firstInning.getRunsScored()))
        {
//            result=result+"Match was Draw";
            res=res+"Match was Draw";
        }
        else{
//            result=result+ teamA.getName()+" Won the match by "+Integer.toString(firstInning.runs- secondInning.runs)+" runs";
            res=res+ teamA.getName()+" Won the match by "+Integer.toString(firstInning.getRunsScored()- secondInning.getRunsScored())+" runs";
        }
//            Link for new match.
            result=result+"<br><br> <button onclick=\"window.location.href='result'\">Another Match</button><br><br>";
            return toss+decision+score+result+scoreCard;
    }
    public void matchScore()
    {
        //        Innings 1 score details.
        score=score+ teamA.getName()+"  "+Integer.toString(firstInning.getRunsScored())+"/"+Integer.toString(firstInning.getWicketsFallen())+" in ";

        if(firstInning.getBallsPlayed()%6==0)
        {
            score=score+Integer.toString(firstInning.getBallsPlayed()/6)+" overs.<br>";
        }
        else{
            score=score+Integer.toString(firstInning.getBallsPlayed()/6)+"."+Integer.toString(firstInning.getBallsPlayed()%6)+ " overs.<br>";
        }
//        Innings 2 score details.
        score=score+ teamB.getName()+"  "+Integer.toString(secondInning.getRunsScored())+"/"+Integer.toString(secondInning.getWicketsFallen())+" in ";
        if(secondInning.getBallsPlayed()%6==0)
        {
            score=score+Integer.toString(secondInning.getBallsPlayed()/6)+" overs.  <br> <br>";
        }
        else{
            score=score+Integer.toString(secondInning.getBallsPlayed()/6)+"."+Integer.toString(secondInning.getBallsPlayed()%6)+ " overs. <br ><br>";
        }
    }
//    public void scoreBoard()
//    {
//        scoreCard+="<table><tr><th>Batsman</th><th>Runs Scored</th><th>Balls Faced</th><th>Boundaries Hit</th></tr>";
//        for(int i=0;i<firstInning.wickets+1;i++)
//        {
//            scoreCard+= teamA.teamList[i].battingStats();
//        }
//        scoreCard+="</table>";
//        scoreCard+="<table><tr><th>Bowler</th><th>Overs Bowled</th><th>Runs Conceded</th><th>Wickets Taken</th><th>Maiden Overs</th></tr>";
//        for(int i=5;i<11;i++)
//        {
//            scoreCard+= teamB.teamList[i].bowlingStats();
//        }
//        scoreCard+="</table>";
//        scoreCard+="<table><tr><th>Batsman</th><th>Runs Scored</th><th>Balls Faced</th><th>Boundaries Hit</th></tr>";
//        for(int i=0;i<secondInning.wickets+1;i++)
//        {
//            scoreCard+= teamB.teamList[i].battingStats();
//        }
//        scoreCard+="</table>";
//        scoreCard+="<table><tr><th>Bowler</th><th>Overs Bowled</th><th>Runs Conceded</th><th>Wickets Taken</th><th>Maiden Overs</th></tr>";
//        for(int i=5;i<11;i++)
//        {
//            scoreCard+= teamA.teamList[i].bowlingStats();
//        }
//        scoreCard+="</table>";
//    }
//

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
    public String getRes() {
        return res;
    }
//
//    public String getResult() {
//        return result;
//    }
//
//    public String getScore() {
//        return score;
//    }
//
//    public String getScoreCard() {
//        return scoreCard;
//    }
//
//    public String getToss() {
//        return toss;
//    }
}
