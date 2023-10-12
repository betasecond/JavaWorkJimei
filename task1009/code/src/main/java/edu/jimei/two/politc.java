package edu.jimei.two;

public class politc extends subject{
    public politc(){};
    public politc(double score){
        super(score,1.0);
    }
    public politc(double score, double weights){
        super(score,weights);
    }
}