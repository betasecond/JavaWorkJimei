package edu.jimei.four;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Teacher {
    private String name;
    @Getter
    private List<Course> coursesTaught;

    public Teacher(String name) {
        this.name = name;
        this.coursesTaught = new ArrayList<>();
    }

    public void teachCourse(Course course) {
        coursesTaught.add(course);
    }

}