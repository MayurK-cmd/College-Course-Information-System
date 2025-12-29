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

            String choiceInput = sc.nextLine();

            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid choice! Enter a number between 1 and 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        // Course Name
                        System.out.print("Enter Course Name: ");
                        String name = sc.nextLine();

                        // Credits (validated)
                        System.out.print("Enter Credits: ");
                        String creditInput = sc.nextLine();
                        int credits;

                        try {
                            credits = Integer.parseInt(creditInput);
                            if (credits <= 0) {
                                throw new IllegalArgumentException("Credits must be greater than 0.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("❌ Credits must be a valid positive number.");
                            break;
                        }

                        // Course Type (validated)
                        System.out.print("Enter Course Type (THEORY/LAB): ");
                        String typeInput = sc.nextLine().toUpperCase();

                        CourseType type;
                        if (typeInput.equals("THEORY")) {
                            type = CourseType.THEORY;
                        } else if (typeInput.equals("LAB")) {
                            type = CourseType.LAB;
                        } else {
                            System.out.println("❌ Invalid course type! Only THEORY or LAB is allowed.");
                            break;
                        }

                        Course course = new Course(name, credits, type);
                        student.addCourse(course);
                        System.out.println("✅ Course added successfully!");

                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
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
                    System.out.println("❌ Invalid choice! Enter 1–4.");
            }
        }
    }
}
