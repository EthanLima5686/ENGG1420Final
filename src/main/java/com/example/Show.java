package com.example;

public class Show extends Effect{

    int start;
    
    public Show(int start){
        super(start);
    }

    public void EffectTrigger(MasterShape shape){
        shape.Show();
    }
}
