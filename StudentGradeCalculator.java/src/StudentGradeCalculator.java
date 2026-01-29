import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            int marks = sc.nextInt();

            // validation
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Enter marks between 0 and 100.");
                i--; // repeat this subject
                continue;
            }

            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / subjects;
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 75) {
            grade = 'B';
        } else if (averagePercentage >= 60) {
            grade = 'C';
        } else if (averagePercentage >= 50) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\n========== RESULT ==========");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("============================");

        sc.close();
    }
}
