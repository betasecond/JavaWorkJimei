package edu.jimei.two;

public class math extends subject{
    public math(){};
    public math(double score){
        super(score,1.0);
    }
    public math(double score,double weights){
        super(score,weights);
    }
}
