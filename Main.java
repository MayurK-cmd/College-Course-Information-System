import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();

        while (true) {
            System.out.println("\n===== College Course Information System =====");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Calculate Total Credits");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Course Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Credits: ");
                        int credits = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Course Type (THEORY/LAB): ");
                        String typeInput = sc.nextLine().toUpperCase();

                        CourseType type = CourseType.valueOf(typeInput);

                        Course course = new Course(name, credits, type);
                        student.addCourse(course);

                        System.out.println("✅ Course added successfully!");
                        break;

                    case 2:
                        student.displayCourses();
                        break;

                    case 3:
                        System.out.println("Total Credits: " + student.calculateTotalCredits());
                        break;

                    case 4:
                        System.out.println("Exiting program...");
                        sc.close();
                        return;

                    default:
                        System.out.println("❌ Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("⚠ Error: " + e.getMessage());
            }
        }
    }
}
