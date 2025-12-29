public class Course {
    private String courseName;
    private int credits;
    private CourseType type;

    public Course(String courseName, int credits, CourseType type) {
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be greater than 0");
        }
        this.courseName = courseName;
        this.credits = credits;
        this.type = type;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return courseName + " | " + credits + " credits | " + type;
    }
}
