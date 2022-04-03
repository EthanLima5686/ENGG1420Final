package com.example;

public class Jump extends Effect{

    int xTrans;
    int yTrans;
    
    public Jump(int start, int xTrans, int yTrans){
        super(start);
        this.xTrans = xTrans;
        this.yTrans = yTrans;
    }
}
