package com.example.springboot;

import java.util.Random;

public class firstInnings extends Innings{
    @Override void startInnings()
    {
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
            if(wickets==10)
            {
                break;
            }
        }
    }
}
