package com.example;

public class Hide extends Effect{

    int start;

    public Hide(int start){
        super(start);
    }

    public void EffectTrigger(MasterShape shape){
        shape.Hide();
    }
}
