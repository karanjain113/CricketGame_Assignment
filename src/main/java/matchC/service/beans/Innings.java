package matchC.service.beans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"strikeBatsman","nonStrikeBatsman","currentBowler"})

public class Innings {
    private String battingTeam="";
    private String bowlingTeam="";
    private int runsScored;
    private int wicketsFallen;
    private int ballsPlayed;
    private String oversBowled="";
    private static int totalOvers;
    private Player strikeBatsman,nonStrikeBatsman,currentBowler;


    public Player getStrikeBatsman() {
        return strikeBatsman;
    }

    public Player getNonStrikeBatsman() {
        return nonStrikeBatsman;
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public String getOversBowled() {
        return oversBowled;
    }

    public  int getTotalOvers() {
        return totalOvers;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }

    public int getWicketsFallen() {
        return wicketsFallen;
    }


    public void setBattingTeam(String battingTeam) {
        this.battingTeam = battingTeam;
    }

    public void setBowlingTeam(String bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public void setWicketsFallen(int wicketsFallen) {
        this.wicketsFallen = wicketsFallen;
    }

    public void setBallsPlayed(int ballsPlayed) {
        this.ballsPlayed = ballsPlayed;
    }

    public void setOversBowled(String oversBowled) {
        this.oversBowled = oversBowled;
    }

    public void setTotalOvers(int totalOvers) {
        Innings.totalOvers = totalOvers;
    }

    public void setStrikeBatsman(Player strikeBatsman) {
        this.strikeBatsman = strikeBatsman;
    }

    public void setNonStrikeBatsman(Player nonStrikeBatsman) {
        this.nonStrikeBatsman = nonStrikeBatsman;
    }

    public void setCurrentBowler(Player currentBowler) {
        this.currentBowler = currentBowler;
    }
}
