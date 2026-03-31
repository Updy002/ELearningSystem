// File: OnlineCourse.java
import java.util.ArrayList;
import java.util.List;

public class OnlineCourse extends Course implements Enroll, Trackable {

    private String platform;
    private List<String> enrolledStudents;
    private DiscountStrategy discountStrategy;

    public OnlineCourse(String courseId, String title, int duration, double baseFee, String platform) {
        super(courseId, title, duration, baseFee);
        this.platform = platform;
        this.enrolledStudents = new ArrayList<>();
        this.discountStrategy = null;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    @Override
    public double calculateFee() {
        double costPerHour = getBaseFee() * 0.6;
        double fee = getDuration() * costPerHour;

        if (getDuration() >= 40) {
            fee *= 0.85;
        }

        if (discountStrategy != null) {
            fee = discountStrategy.applyDiscount(fee);
        }

        return fee;
    }

    @Override
    public void enrollStudent(String studentName) {
        enrolledStudents.add(studentName);
        System.out.println(studentName + " enrolled in Online Course: " + getTitle());
    }

    @Override
    public void enrollStudent(String studentName, String email) {
        enrolledStudents.add(studentName);
        System.out.println(studentName + " (" + email + ") enrolled in Online Course: " + getTitle());
    }

    @Override
    public void trackProgress(String studentName, int progressPercentage) {
        if (progressPercentage < 0 || progressPercentage > 100) {
            throw new IllegalArgumentException("Progress must be between 0 and 100.");
        }

        if (!enrolledStudents.contains(studentName)) {
            throw new IllegalStateException(studentName + " is not enrolled in this course.");
        }

        System.out.println("Progress of " + studentName + " in " + getTitle() + ": " + progressPercentage + "%");
    }

    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Enrolled Students: " + enrolledStudents);
    }
}