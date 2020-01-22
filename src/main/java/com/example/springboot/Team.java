package com.example.springboot;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    Player[] teamList=new Player[11];

    Team()
    {
        for(int i=0;i<11;i++)
        {
            teamList[i]=new Player("RandomP"+i);
        }
        this.name="RandomTeam";
    }
    Team(String name)
    {
        for(int i=0;i<11;i++)
        {
            teamList[i]=new Player("RandomP"+i);
        }
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public Player[] getTeamList() {
        return teamList;
    }
}
