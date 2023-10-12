package edu.jimei.four;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter @Getter
public class Student {
    private String name;
    @Getter
    private List<Course> coursesTaken;

    public Student(String name) {
        this.name = name;
        this.coursesTaken = new ArrayList<>();
    }

    public void takeCourse(Course course) {
        coursesTaken.add(course);
    }

}
