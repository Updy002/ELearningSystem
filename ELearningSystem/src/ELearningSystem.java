// File: ELearningSystem.java
import java.util.ArrayList;
import java.util.List;

public class ELearningSystem {

    public static void main(String[] args) {
        try {
            List<Course> courses = new ArrayList<>();

            OnlineCourse online1 = new OnlineCourse("OC101", "Java Programming", 50, 15.0, "Zoom");
            OnlineCourse online2 = new OnlineCourse("OC102", "Web Development", 30, 12.0, "Moodle");

            OfflineCourse offline1 = new OfflineCourse("OF201", "Database Systems", 40, 200.0, "Campus Lab A", 75.0);

            DiscountStrategy specialDiscount = new DiscountStrategy() {
                @Override
                public double applyDiscount(double fee) {
                    return fee * 0.90;
                }
            };

            online1.setDiscountStrategy(specialDiscount);

            courses.add(online1);
            courses.add(online2);
            courses.add(offline1);

            Student s1 = new Student("S001", "Ali");
            Student s2 = new Student("S002", "Sara");

            online1.enrollStudent(s1.getName(), "ali@email.com");
            online2.enrollStudent(s2.getName());
            offline1.enrollStudent(s1.getName());
            offline1.enrollStudent(s2.getName(), "sara@email.com");

            s1.enroll(online1);
            s1.enroll(offline1);

            s2.enroll(online2);
            s2.enroll(offline1);

            online1.trackProgress("Ali", 60);
            online2.trackProgress("Sara", 25);

            offline1.scheduleClass("2026-04-10", "10:00 AM");

            offline1.issueCertificate("Ali");

            System.out.println("\n=== DISPLAY ALL COURSES DETAILS ===");
            for (Course c : courses) {
                System.out.println("\n------------------------");
                c.displayCourseDetails();
            }

            System.out.println("\n=== STUDENT COURSE LIST ===");
            s1.viewCourses();
            System.out.println();
            s2.viewCourses();

            System.out.println("\n=== POLYMORPHISM DEMO ===");
            for (Course c : courses) {
                Course ref = c;
                System.out.println(ref.getTitle() + " Fee: $" + ref.calculateFee());
            }

        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }
    }
}