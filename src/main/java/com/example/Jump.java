package com.example;

/**
 * Jump Effect: Moves an object elsewhere.
 */
public class Jump extends Effect{

    int xTrans = 10;
    int yTrans = 20;
    /**
     * Creates a Jump Effect
     * @param start The frame to trigger the effect on
     * @param xTrans The x position to move the shape to
     * @param yTrans The y position to move the shape to
     */
    public Jump(int start, int xTrans, int yTrans){
        super(start);
        this.xTrans = xTrans;
        this.yTrans = yTrans;
    }
    /**
     * Moves the shape
     * @param shape The shape to move
     */
    public void EffectTrigger(MasterShape shape){
        shape.Jump(xTrans, yTrans);
    }
}
