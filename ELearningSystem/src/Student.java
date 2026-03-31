// File: Student.java
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String name;
    private List<Course> enrolledCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void enroll(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }
        enrolledCourses.add(course);
        System.out.println(name + " added course: " + course.getTitle());
    }

    public void viewCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
            return;
        }

        for (Course course : enrolledCourses) {
            System.out.println("- " + course.getTitle() + " (Fee: $" + course.calculateFee() + ")");
        }
    }
}