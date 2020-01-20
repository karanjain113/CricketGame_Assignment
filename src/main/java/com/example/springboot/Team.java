package com.example.springboot;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    List<Player> teamList=new ArrayList<Player>();
    Team()
    {
        this.name="Random";
    }
    Team(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
}
