package com.example.springboot;

public class Match {
    Team A;
    Team B;
    firstInnings firstInning =new firstInnings();
    secondInnings secondInning =new secondInnings();
    String result="",toss="",decision="",score="";
    Team tossWon;
//    Default Constructor
    Match()
    {
        this.A=new Team("RandomTeam1");
        this.B=new Team("RandomTeam2");
        Innings.overs=50;
    }
//    Parametrized Constructor
    Match(Team A,Team B,int overs)
    {
        this.A=A;
        this.B=B;
        Innings.overs=overs;
    }
    public void startMatch()
    {
        toss();
        decision();
        firstInning.startInnings();
        secondInning.setTarget(firstInning.runs+1);
        secondInning.startInnings();
    }
    void toss()
    {
        if(Math.random()<0.5)
        {
            toss = toss + A.getName() +" won the toss and ";
            tossWon=A;
        }
        else{
            toss = toss + B.getName() +" won the toss and ";
            tossWon=B;
        }
    }
    void decision()
    {
        if(Math.random()<0.5)
        {
            decision = decision+"elected to bat first.<br><br> ";
            if(tossWon==B)
            {
                Team temp=B;
                B=A;
                A=temp;
            }
        }
        else{
            decision = decision+"elected to ball first. <br><br>";
            if(tossWon==A)
            {
                Team temp=B;
                B=A;
                A=temp;
            }
        }
    }
    public String matchResult()
    {
        matchScore();
//        Result declaration.
        if(secondInning.runs>firstInning.runs)
        {
            result=result+B.getName()+" Won the match by "+Integer.toString(10- secondInning.wickets)+" wickets";
        }
        else if(secondInning.runs== firstInning.runs)
        {
            result=result+"Match was Draw";
        }
        else{
            result=result+A.getName()+" Won the match by "+Integer.toString(firstInning.runs- secondInning.runs)+" runs";
        }
//            Link for new match.
            result=result+"<br><br> <button onclick=\"window.location.href='result'\">Another Match</button>";
            return toss+decision+score+result;
    }
    public void matchScore()
    {
        //        Innings 1 score details.
        score=score+A.getName()+"  "+Integer.toString(firstInning.runs)+"/"+Integer.toString(firstInning.wickets)+" in ";

        if(firstInning.balls%6==0)
        {
            score=score+Integer.toString(firstInning.balls/6)+" overs.<br>";
        }
        else{
            score=score+Integer.toString(firstInning.balls/6)+"."+Integer.toString(firstInning.balls%6)+ " overs.<br>";
        }
//        Innings 2 score details.
        score=score+B.getName()+"  "+Integer.toString(secondInning.runs)+"/"+Integer.toString(secondInning.wickets)+" in ";
        if(secondInning.balls%6==0)
        {
            score=score+Integer.toString(secondInning.balls/6)+" overs.  <br> <br>";
        }
        else{
            score=score+Integer.toString(secondInning.balls/6)+"."+Integer.toString(secondInning.balls%6)+ " overs. <br ><br>";
        }

    }
}
