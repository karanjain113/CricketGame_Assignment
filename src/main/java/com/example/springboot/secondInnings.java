package com.example.springboot;

import java.util.Random;

public class secondInnings extends Innings {
    Integer target=0;
    public void setTarget(int target)
    {
        this.target=target;
    }
    @Override
    void startInnings() {
        for(int i=1;i<=(6*overs);i++)
        {
            balls++;
            Random rand=new Random();
            int next=rand.nextInt(8);
            if(next==7)
            {
                wickets++;
            }
            else{
                runs+=next;
            }
            if(wickets==10 || runs>=target)
            {
                break;
            }
        }
    }
}
