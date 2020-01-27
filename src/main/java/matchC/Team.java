package matchC;

import java.util.Random;

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
        Random rand=new Random();
        for(int i=0;i<4;i++)
        {
            teamList[i].setTypeOfPlayer(PlayerType.Batsman);
            teamList[i].setBattingRating((float)rand.nextInt(3)+8);
            teamList[i].setBowlingRating(0);
        }
        for(int i=4;i<6;i++)
        {
            teamList[i].setTypeOfPlayer(PlayerType.AllRounder);
            teamList[i].setBattingRating((float)rand.nextInt(2)+5);
            teamList[i].setBowlingRating((float)rand.nextInt(2)+5);
        }
        for(int i=6;i<=10;i++)
        {
            teamList[i].setTypeOfPlayer(PlayerType.Bowler);
            teamList[i].setBattingRating((float)rand.nextInt(3)+1);
            teamList[i].setBowlingRating((float)rand.nextInt(3)+8);
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
        Random rand=new Random();
        for(int i=0;i<4;i++)
        {
            teamList[i].setTypeOfPlayer(PlayerType.Batsman);
            teamList[i].setBattingRating((float)rand.nextInt(3)+8);
            teamList[i].setBowlingRating(0);
        }
        for(int i=4;i<6;i++)
        {
            teamList[i].setTypeOfPlayer(PlayerType.AllRounder);
            teamList[i].setBattingRating((float)rand.nextInt(2)+5);
            teamList[i].setBowlingRating((float)rand.nextInt(2)+5);
        }
        for(int i=6;i<=10;i++)
        {
            teamList[i].setTypeOfPlayer(PlayerType.Bowler);
            teamList[i].setBattingRating((float)rand.nextInt(3)+1);
            teamList[i].setBowlingRating((float)rand.nextInt(3)+8);
        }
        this.name=name;
        stats=new teamStats();
    }
    //Getter Functions
    public String getName() { return name; }
    public Player[] getTeamList() { return teamList; }
    public teamStats getStats() { return stats; }
}
