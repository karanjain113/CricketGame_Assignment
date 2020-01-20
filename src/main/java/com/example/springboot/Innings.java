package com.example.springboot;

public abstract class Innings {
    Integer runs=0;
    Integer wickets=0;
    Integer balls=0;
    static Integer overs=0;
    Innings(){}
    abstract void startInnings();
}
