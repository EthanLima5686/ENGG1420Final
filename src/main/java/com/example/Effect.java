package com.example;

public class Effect {
    int start;
    public Effect(int start){
        this.start = start;
    }

    public void TestEffect(int frame, MasterShape shape){
        if (frame > start){
            EffectTrigger(shape);
        }
    }

    public void EffectTrigger(MasterShape shape){
        return;
    }
}
