import java.util.ArrayList;

public class Student {
    private ArrayList<Course> courses;

    public Student() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public int calculateTotalCredits() {
        int total = 0;
        for (Course c : courses) {
            total += c.getCredits();
        }
        return total;
    }

    public void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses added yet.");
            return;
        }

        System.out.println("\n--- Enrolled Courses ---");
        for (Course c : courses) {
            System.out.println(c);
        }
    }
}
