package matchC;

enum PlayerType {Batsman,Bowler,AllRounder};
class Player {
    private String name;
    private PlayerBattingStats battingStats;
    private PlayerBowlingStats bowlingStats;
    private float battingRating;
    private float bowlingRating;
    private PlayerType typeOfPlayer;

    Player()
    {
        name="Random Player";
        battingStats=new PlayerBattingStats();
        bowlingStats=new PlayerBowlingStats();
    }

    Player(String s)
    {
        this.name=s;
        battingStats=new PlayerBattingStats();
        bowlingStats=new PlayerBowlingStats();
    }

//    Getter Functions
    public String getName() {
        return name;
    }
    public PlayerBattingStats getBattingStats() { return battingStats; }
    public PlayerBowlingStats getBowlingStats() { return bowlingStats; }
    public float getBattingRating() { return battingRating; }
    public float getBowlingRating() { return bowlingRating; }
    public PlayerType getTypeOfPlayer() { return typeOfPlayer; }

//    Setter functions

    public void setBattingRating(float battingRating) { this.battingRating = battingRating; }

    public void setBowlingRating(float bowlingRating) { this.bowlingRating = bowlingRating; }

    public void setTypeOfPlayer(PlayerType typeOfPlayer) { this.typeOfPlayer = typeOfPlayer; }
}
