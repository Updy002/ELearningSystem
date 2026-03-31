// File: OfflineCourse.java
import java.util.ArrayList;
import java.util.List;

public class OfflineCourse extends Course implements Enroll, Certifiable, Schedulable {

    private String location;
    private double materialFee;
    private List<String> enrolledStudents;
    private String scheduledDate;
    private String scheduledTime;

    public OfflineCourse(String courseId, String title, int duration, double baseFee,
                         String location, double materialFee) {
        super(courseId, title, duration, baseFee);
        this.location = location;
        this.materialFee = materialFee;
        this.enrolledStudents = new ArrayList<>();
        this.scheduledDate = "Not Scheduled";
        this.scheduledTime = "Not Scheduled";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMaterialFee() {
        return materialFee;
    }

    public void setMaterialFee(double materialFee) {
        if (materialFee < 0) {
            throw new IllegalArgumentException("Material fee cannot be negative.");
        }
        this.materialFee = materialFee;
    }

    @Override
    public double calculateFee() {
        double instructorCost = getDuration() * 30;
        double classroomCost = getDuration() * 20;
        return getBaseFee() + instructorCost + classroomCost + materialFee;
    }

    @Override
    public void enrollStudent(String studentName) {
        enrolledStudents.add(studentName);
        System.out.println(studentName + " enrolled in Offline Course: " + getTitle());
    }

    @Override
    public void enrollStudent(String studentName, String email) {
        enrolledStudents.add(studentName);
        System.out.println(studentName + " (" + email + ") enrolled in Offline Course: " + getTitle());
    }

    @Override
    public void issueCertificate(String studentName) {
        if (!enrolledStudents.contains(studentName)) {
            throw new IllegalStateException(studentName + " is not enrolled, cannot issue certificate.");
        }

        System.out.println("Certificate issued to " + studentName + " for completing: " + getTitle());
    }

    @Override
    public void scheduleClass(String date, String time) {
        this.scheduledDate = date;
        this.scheduledTime = time;
        System.out.println("Offline course scheduled on " + date + " at " + time);
    }

    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Location: " + location);
        System.out.println("Material Fee: $" + materialFee);
        System.out.println("Scheduled Date: " + scheduledDate);
        System.out.println("Scheduled Time: " + scheduledTime);
        System.out.println("Enrolled Students: " + enrolledStudents);
    }
}