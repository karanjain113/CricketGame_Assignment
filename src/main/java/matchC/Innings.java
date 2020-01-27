package matchC;


import java.util.Random;

class Innings {
    private String battingTeam="";
    private String bowlingTeam="";
    private Integer runsScored =0;
    private Integer wicketsFallen =0;
    private Integer ballsPlayed =0;
    private String oversBowled="";
    static Integer totalOvers;
    private Integer target;

    void startInnings(Team battingTeam, Team bowlingTeam,int inningsNumber)
    {
        this.battingTeam=battingTeam.getName();
        this.bowlingTeam=bowlingTeam.getName();
        Player strikeBatsman=battingTeam.teamList[0];
        Player nonStrikeBatsman=battingTeam.teamList[1];
        int currentBowlerIndex=0;
        Player currentBowler;
        for(int j = 0; j<totalOvers; j++){
            currentBowlerIndex=chooseNextBowler(currentBowlerIndex);
            currentBowler=bowlingTeam.teamList[currentBowlerIndex];
            int runsThisOver=0;
            for(int i=0;i<6;i++)
            {
                ballsPlayed++;
                Integer x=strikeBatsman.getBattingStats().getBallsPlayed()+1;
                strikeBatsman.getBattingStats().setBallsPlayed(x);
                x=currentBowler.getBowlingStats().getBallsBowled()+1;
                currentBowler.getBowlingStats().setBallsBowled(x);
//                Random rand=new Random();
                int next=nextBall(strikeBatsman,currentBowler);
                if(next==7)
                {
                    x= currentBowler.getBowlingStats().getWicketsTaken()+1;
                    currentBowler.getBowlingStats().setWicketsTaken(x);
                    wicketsFallen++;
                    strikeBatsman=battingTeam.teamList[wicketsFallen];
                }
                else{
                    runsThisOver+=next;
                    x=strikeBatsman.getBattingStats().getRunsScored();
                    strikeBatsman.getBattingStats().setRunsScored(x+next);
                    x= currentBowler.getBowlingStats().getRunsGiven()+next;
                    currentBowler.getBowlingStats().setRunsGiven(x);
                    if(next==4 || next==6)
                    {
                        x=strikeBatsman.getBattingStats().getBoundariesHit()+1;
                        strikeBatsman.getBattingStats().setBoundariesHit(x);
                    }
                    if(next%2==1)
                    {
                        Player temp=strikeBatsman;
                        strikeBatsman=nonStrikeBatsman;
                        nonStrikeBatsman=temp;
                    }
                    runsScored +=next;
                }
                if(wicketsFallen==10)
                {
                    break;
                }
                if(inningsNumber==2 && runsScored>=target)
                {
                    break;
                }
            }
            if(ballsPlayed %6==0 && runsThisOver==0)
            {
                Integer temp= bowlingTeam.teamList[currentBowlerIndex].getBowlingStats().getMaidens()+1;
                bowlingTeam.teamList[currentBowlerIndex].getBowlingStats().setMaidens(temp);
            }
            if(wicketsFallen ==10)
            {
                break;
            }
            if(inningsNumber==2 && runsScored>=target)
            {
                break;
            }
            Player temp=strikeBatsman;
            strikeBatsman=nonStrikeBatsman;
            nonStrikeBatsman=temp;
            currentBowlerIndex++;
        }
        if(ballsPlayed %6==0)
        {
            oversBowled+=Integer.toString(ballsPlayed /6);
        }
        else{
            oversBowled+=Integer.toString(ballsPlayed /6)+"."+Integer.toString(ballsPlayed %6);
        }
        battingTeam.getStats().setRunsScored(runsScored);
        battingTeam.getStats().setWicketsFallen(wicketsFallen);
    }

    private int chooseNextBowler(int currentBowler) {
        currentBowler%=11;
        if(currentBowler==0)
        {
            currentBowler+=5;
        }
        return currentBowler;
    }


    public int nextBall(Player batsman,Player bowler)
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
            float threshold= (float) (((0.01)/9.0)*(1-(1/ratio))+0.05);
//            System.out.println(ratio);
            if(Math.random()<=threshold)
            {
                return 7;
            }
        }
        Random rand=new Random();
        return rand.nextInt(7);
    }

//Getter Functions
    public Integer getRunsScored() {
        return runsScored;
    }

    public Integer getBallsPlayed() {
        return ballsPlayed;
    }

    public String getOversBowled() {
        return oversBowled;
    }

    public static Integer getTotalOvers() {
        return totalOvers;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }

    public Integer getWicketsFallen() {
        return wicketsFallen;
    }


    public void setTarget(Integer target) {
        this.target = target;
    }
}
