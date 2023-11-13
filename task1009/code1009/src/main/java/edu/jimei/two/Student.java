package edu.jimei.two;

import edu.jimei.SomeException;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
class Student{
    private String name;
    /*
     *  Map:
     *   key : String 学科名
     *   value : subject
     * */
    private Map<String,subject> subjects = new HashMap<>();

    public Student(String name){
        setName(name);
    }

    //add subjcet
    public void addSubject(String subjectName,subject subjectSelf){
        getSubjects().put(subjectName,subjectSelf);
    }
    public double averageScore() throws SomeException {
        double totalScore = 0;
        int count = 0;
        if(getSubjects().isEmpty()){throw new SomeException("subjects have no value");}
        for (subject subjectself:getSubjects().values()) {
            totalScore += subjectself.getScore();
            count++;
        }
        if(count == 0){
            return 0;
        }

        return totalScore / count;
    }

    public double weightsAverageScore() throws SomeException{
        double totalWeightsScore = 0;
        int count = 0;
        if(getSubjects().isEmpty()){throw new SomeException("subjects have no value");}
        for (subject subjectself:getSubjects().values()) {
            totalWeightsScore += subjectself.WeightedValue();
            count++;
        }
        if(count == 0){
            return 0;
        }

        return totalWeightsScore / count;
    }

}