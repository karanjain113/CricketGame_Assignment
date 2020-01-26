package matchC;

class Team {
    private String name;
    private teamStats stats;
    Player[] teamList=new Player[11];
    Team()
    {
        for(int i=0;i<11;i++)
        {
            teamList[i]=new Player("RandomP"+i);
        }
        this.name="RandomTeam";
        stats=new teamStats();
    }
    //    Constructors
    Team(String name)
    {
        for(int i=0;i<11;i++)
        {
            teamList[i]=new Player("RandomP"+i);
        }
        this.name=name;
        stats=new teamStats();
    }
    //Getter Functions
    public String getName() { return name; }
    public Player[] getTeamList() { return teamList; }
    public teamStats getStats() { return stats; }
}
