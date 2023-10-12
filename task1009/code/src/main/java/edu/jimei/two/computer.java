package edu.jimei.two;

public class computer extends subject{
    public computer(){};
    public computer(double score){
        super(score,1.0);
    }
    public computer(double score, double weights){
        super(score,weights);
    }
}
