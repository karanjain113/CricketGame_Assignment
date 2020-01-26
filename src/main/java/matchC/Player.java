package matchC;

class Player {
    private String name;
    private playerBattingStats battingStats;
    private playerBowlingStats bowlingStats;


    Player()
    {
        name="Random Player";
    }

    Player(String s)
    {
        this.name=s;
        battingStats=new playerBattingStats();
        bowlingStats=new playerBowlingStats();
    }

//    Getter Functions
    public String getName() {
        return name;
    }
    public playerBattingStats getBattingStats() { return battingStats; }
    public playerBowlingStats getBowlingStats() { return bowlingStats; }
}
