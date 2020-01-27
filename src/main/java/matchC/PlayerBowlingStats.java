package matchC;

public class PlayerBowlingStats {
    private Integer wicketsTaken=0;
    private Integer runsGiven=0;
    private Integer ballsBowled=0;
    private Integer maidens=0;
    private float economy=0;

    public Integer getWicketsTaken() {
        return wicketsTaken;
    }

    public Integer getRunsGiven() {
        return runsGiven;
    }

    public Integer getBallsBowled() {
        return ballsBowled;
    }

    public Integer getMaidens() {
        return maidens;
    }

    public void setWicketsTaken(Integer wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public void setRunsGiven(Integer runsGiven) {
        this.runsGiven = runsGiven;
    }

    public void setBallsBowled(Integer ballsBowled) {
        this.ballsBowled = ballsBowled;
    }

    public void setMaidens(Integer maidens) {
        this.maidens = maidens;
    }
}
