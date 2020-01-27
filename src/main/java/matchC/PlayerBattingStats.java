package matchC;

public class PlayerBattingStats {
    private Integer runsScored=0;
    private Integer ballsPlayed=0;
    private Integer boundariesHit=0;
    private float strikeRate=0;

    public Integer getRunsScored() {
        return runsScored;
    }

    public Integer getBallsPlayed() {
        return ballsPlayed;
    }

    public Integer getBoundariesHit() {
        return boundariesHit;
    }

    public void setRunsScored(Integer runsScored) {
        this.runsScored = runsScored;
    }

    public void setBallsPlayed(Integer ballsPlayed) {
        this.ballsPlayed = ballsPlayed;
    }

    public void setBoundariesHit(Integer boundariesHit) {
        this.boundariesHit = boundariesHit;
    }
}
