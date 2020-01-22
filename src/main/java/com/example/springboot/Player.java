package com.example.springboot;

public class Player {

    private String name;
    private Integer runsScored=0;
    private Integer ballsPlayed=0;
    private Integer boundariesHit=0;
    private Integer wicketsTaken=0;
    private Integer runsGiven=0;
    private Integer ballsBowled=0;
    private Integer maidens=0;

    Player()
    {
        name="Random Player";
    }
    Player(String s)
    {
        this.name=s;
    }

    public String getName() {
        return name;
    }

    public Integer getMaidens() {
        return maidens;
    }

    public void setMaidens(Integer maidens) {
        this.maidens = maidens;
    }

    public Integer getRunsGiven() {
        return runsGiven;
    }

    public void setRunsGiven(Integer runsGiven) {
        this.runsGiven = runsGiven;
    }

    public Integer getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(Integer wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public Integer getRunsScored() {
        return runsScored;
    }

    public Integer getBallsBowled() {
        return ballsBowled;
    }

    public void setBallsBowled(Integer ballsBowled) {
        this.ballsBowled = ballsBowled;
    }

    public Integer getBoundariesHit() {
        return boundariesHit;
    }

    public Integer getBallsPlayed() {
        return ballsPlayed;
    }

    public void setBallsPlayed(int i) {
        ballsPlayed=i;
    }

    public void setRunsScored(int i) {
        runsScored=i;
    }

    public void setBoundariesHit(int i) {
        boundariesHit=i;
    }
    public String battingStats()
    {
        return "<tr>"+"<td>"+name+"</td>"+"<td>"+runsScored+"</td>"+"<td>"+ballsPlayed+"</td>"+"<td>"+boundariesHit+"</td>"+"</tr>";
    }
    public String bowlingStats()
    {
        return "<tr>"+"<td>"+name+"</td>"+"<td>"+oversBowled()+"</td>"+"<td>"+runsGiven+"</td>"+"<td>"+wicketsTaken+"</td>"+"<td>"+maidens+"</td>"+"</tr>";
    }
    public String oversBowled()
    {
        if(ballsBowled%6==0)
        {
            return Integer.toString(ballsBowled/6);
        }
        else{
            return Integer.toString(ballsBowled/6)+"."+Integer.toString(ballsBowled%6);
        }
    }
}
