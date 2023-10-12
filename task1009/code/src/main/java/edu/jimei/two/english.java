package edu.jimei.two;

public class english extends subject{
    public english(){};
    public english(double score){
        super(score,1.0);
    }
    public english(double score,double weights){
        super(score,weights);
    }
}

