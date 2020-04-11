package matchC;

public class PlayerBattingStats {
    private int runsScored=0;
    private int ballsPlayed=0;
    private int boundariesHit=0;
    private float strikeRate=0;

    public int getRunsScored() {
        return runsScored;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public int getBoundariesHit() {
        return boundariesHit;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public void setBallsPlayed(int ballsPlayed) {
        this.ballsPlayed = ballsPlayed;
    }

    public void setBoundariesHit(int boundariesHit) {
        this.boundariesHit = boundariesHit;
    }
}
