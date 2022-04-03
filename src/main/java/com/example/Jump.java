package com.example;

public class Jump extends Effect{

    int xTrans = 10;
    int yTrans = 20;
    
    public Jump(int start, int xTrans, int yTrans){
        super(start);
        this.xTrans = xTrans;
        this.yTrans = yTrans;
    }

    public void EffectTrigger(MasterShape shape){
        shape.Jump(xTrans, yTrans);
    }
}
