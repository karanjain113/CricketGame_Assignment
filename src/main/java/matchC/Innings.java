package matchC;

import java.util.ArrayList;

abstract class Innings {
    String battingTeam="";
    String bowlingTeam="";
    Integer runs=0;
    Integer wickets=0;
    Integer balls=0;
    String oversBowled="";
    static Integer totalOvers;

    Innings(){}
    abstract void startInnings(Team battingTeam,Team bowlingTeam);

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }
    public Integer getBalls() {
        return balls;
    }

    public String getOversBowled() {
        return oversBowled;
    }

    public static Integer getTotalOvers() {
        return totalOvers;
    }
//    public ArrayList<Over> getOvers() {
//        return overs;
//    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }
//    public Integer getBalls() {
//        return balls;
//    }
//
//    public void setBalls(Integer balls) {
//        this.balls = balls;
//    }
//
//    public static Integer getOvers() {
//        return overs;
//    }
//
//    public static void setOvers(Integer overs) {
//        Innings.overs = overs;
//    }
}
