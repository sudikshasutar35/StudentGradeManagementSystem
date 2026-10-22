
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("====================================");
        System.out.println("   STUDENT GRADE MANAGEMENT SYSTEM");
        System.out.println("====================================");

        // Validate the number of students
        int count;

        while (true) {
            System.out.print("Enter number of students: ");

            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                scanner.nextLine();

                if (count > 0) {
                    break;
                }

                System.out.println(
                    "Invalid count! Enter a number greater than 0."
                );
            } else {
                System.out.println(
                    "Invalid input! Enter a whole number."
                );
                scanner.nextLine();
            }
        }

        // Accept student details
        for (int i = 1; i <= count; i++) {

            System.out.println("\nStudent " + i);

            String name;

            while (true) {
                System.out.print("Enter student name: ");
                name = scanner.nextLine().trim();

                if (!name.isEmpty()) {
                    break;
                }

                System.out.println(
                    "Invalid name! Name cannot be empty."
                );
            }

            double marks;

            while (true) {
                System.out.print("Enter marks (0-100): ");

                if (scanner.hasNextDouble()) {
                    marks = scanner.nextDouble();
                    scanner.nextLine();

                    if (Double.isFinite(marks)
                            && marks >= 0
                            && marks <= 100) {
                        break;
                    }

                    System.out.println(
                        "Invalid marks! Enter marks between 0 and 100."
                    );
                } else {
                    System.out.println(
                        "Invalid input! Please enter a number."
                    );
                    scanner.nextLine();
                }
            }

            students.add(new Student(name, marks));
        }

        // Calculate statistics
        double total = 0;
        double highest = students.get(0).getMarks();
        double lowest = students.get(0).getMarks();

        for (Student student : students) {
            double marks = student.getMarks();

            total += marks;

            if (marks > highest) {
                highest = marks;
            }

            if (marks < lowest) {
                lowest = marks;
            }
        }

        double average = total / students.size();

        // Display student records
        System.out.println("\n========== STUDENT RECORDS ==========");

        for (Student student : students) {
            System.out.printf(
                "Name: %-15s Marks: %6.2f Grade: %-5s Result: %s%n",
                student.getName(),
                student.getMarks(),
                student.getGrade(),
                student.getResult()
            );
        }

        // Display summary report
        System.out.println("\n================================================");
        System.out.println("             STUDENT SUMMARY REPORT");
        System.out.println("================================================");

        System.out.printf(
            "%-20s : %d%n",
            "Total Students", students.size()
        );
        System.out.printf(
            "%-20s : %.2f%n",
            "Average Marks", average
        );
        System.out.printf(
            "%-20s : %.2f%n",
            "Highest Marks", highest
        );
        System.out.printf(
            "%-20s : %.2f%n",
            "Lowest Marks", lowest
        );

        System.out.println("================================================");

        scanner.close();
    }
}
