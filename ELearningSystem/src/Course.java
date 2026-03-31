// File: Course.java
public abstract class Course {
    private String courseId;
    private String title;
    private int duration;
    private double baseFee;

    public Course(String courseId, String title, int duration, double baseFee) {
        this.courseId = courseId;
        this.title = title;
        this.duration = duration;
        this.baseFee = baseFee;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive.");
        }
        this.duration = duration;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(double baseFee) {
        if (baseFee < 0) {
            throw new IllegalArgumentException("Base fee cannot be negative.");
        }
        this.baseFee = baseFee;
    }

    public abstract double calculateFee();

    public void displayCourseDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Title: " + title);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Base Fee: $" + baseFee);
        System.out.println("Final Fee: $" + calculateFee());
    }
}