package com.example;

public class Jump extends Effect{

    int x;
    int y;
    int endX;
    int endY;
    int xTrans = 10;
    int yTrans = 20;
    int endXTrans = 30;
    int endYTrans = 40;
    
    public Jump(int start, int x, int y, int xTrans, int yTrans){
        super(start);
        this.x = x;
        this.y = y;
        this.xTrans = xTrans;
        this.yTrans = yTrans;
    }

    public void EffectTrigger(MasterShape shape){
        
    }
}
