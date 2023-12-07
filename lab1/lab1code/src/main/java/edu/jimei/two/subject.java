package edu.jimei.two;

import edu.jimei.SomeException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class subject{
    private Double Score;
    private Double Weights;

    public subject(){}
    public subject(double score){
        this.setScore(score);
    }
    public subject(double score,double Weights){
        this.setScore(score);
        this.setWeights(Weights);
    }
    public double WeightedValue() throws SomeException {
        if(this.getScore()==0){throw new SomeException("score have no value");}
        if(this.getWeights()==0){throw new SomeException("weights have no value");}
        return this.getScore()*this.getWeights();
    }

}