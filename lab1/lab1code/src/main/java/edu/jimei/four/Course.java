package edu.jimei.four;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Course {
    private String courseName;

    public Course(String courseName) {
        setCourseName(courseName);
    }

}
