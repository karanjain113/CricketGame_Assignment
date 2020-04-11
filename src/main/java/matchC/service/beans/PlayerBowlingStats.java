package matchC.service.beans;

public class PlayerBowlingStats {
    private int wicketsTaken=0;
    private int runsGiven=0;
    private int ballsBowled=0;
    private int maidens=0;
    private float economy=0;

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public int getBallsBowled() {
        return ballsBowled;
    }

    public int getMaidens() {
        return maidens;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public void setRunsGiven(int runsGiven) {
        this.runsGiven = runsGiven;
    }

    public void setBallsBowled(int ballsBowled) {
        this.ballsBowled = ballsBowled;
    }

    public void setMaidens(int maidens) {
        this.maidens = maidens;
    }
}
