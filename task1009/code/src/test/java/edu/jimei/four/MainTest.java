package edu.jimei.four;

public class MainTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Smith");
        Course math = new Course("Math");
        Course science = new Course("Science");
        teacher.teachCourse(math);
        teacher.teachCourse(science);

        Student student = new Student("Alice");
        student.takeCourse(math);

        System.out.println("Courses taught by " + teacher.getName() + ":");
        for (Course course : teacher.getCoursesTaught()) {
            System.out.println(course.getCourseName());
        }

        System.out.println("Courses taken by " + student.getName() + ":");
        for (Course course : student.getCoursesTaken()) {
            System.out.println(course.getCourseName());
        }
    }
}
