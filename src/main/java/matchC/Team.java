package matchC;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team {
    private String name;
    private TeamStats stats;
    private List<Player> teamList= new ArrayList<>(11);

    public Team()
    {
        for(int i=0;i<11;i++)
        {
            teamList.add(new Player("RandomP"+i));
        }
        Random rand=new Random();
        for(int i=0;i<4;i++)
        {
            teamList.get(i).setTypeOfPlayer(PlayerType.Batsman);
            teamList.get(i).setBattingRating((float)rand.nextInt(3)+8);
            teamList.get(i).setBowlingRating(0);
        }
        for(int i=4;i<6;i++)
        {
            teamList.get(i).setTypeOfPlayer(PlayerType.AllRounder);
            teamList.get(i).setBattingRating((float)rand.nextInt(2)+5);
            teamList.get(i).setBowlingRating((float)rand.nextInt(2)+5);
        }
        for(int i=6;i<=10;i++)
        {
            teamList.get(i).setTypeOfPlayer(PlayerType.Bowler);
            teamList.get(i).setBattingRating((float)rand.nextInt(3)+1);
            teamList.get(i).setBowlingRating((float)rand.nextInt(3)+8);
        }
        this.name="RandomTeam";
        stats=new TeamStats();
    }
    //    Constructors
    public Team(String name)
    {

        for(int i=0;i<11;i++)
        {
            teamList.add(new Player("RandomP"+i));
        }
        Random rand=new Random();
        for(int i=0;i<4;i++)
        {
            teamList.get(i).setTypeOfPlayer(PlayerType.Batsman);
            teamList.get(i).setBattingRating((float)rand.nextInt(3)+8);
            teamList.get(i).setBowlingRating(0);
        }
        for(int i=4;i<6;i++)
        {
            teamList.get(i).setTypeOfPlayer(PlayerType.AllRounder);
            teamList.get(i).setBattingRating((float)rand.nextInt(2)+5);
            teamList.get(i).setBowlingRating((float)rand.nextInt(2)+5);
        }
        for(int i=6;i<=10;i++)
        {
            teamList.get(i).setTypeOfPlayer(PlayerType.Bowler);
            teamList.get(i).setBattingRating((float)rand.nextInt(3)+1);
            teamList.get(i).setBowlingRating((float)rand.nextInt(3)+8);
        }
        this.name=name;
        stats=new TeamStats();
    }
    //Getter Functions
    public String getName() { return name; }

    public List<Player> getTeamList() {
        return teamList;
    }
    public TeamStats getStats() { return stats; }
}
