import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = 0;
        while (true) {
            try {
                numSubjects = scanner.nextInt();
                if (numSubjects <= 0) {
                    System.out.println("Invalid input! Please enter a positive integer.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next();
            }
        }
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                try {
                    System.out.print("Enter marks for subject " + (i + 1) + ": ");
                    int marks = scanner.nextInt();
                    if (marks < 0 || marks > 100) {
                        System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                    } else {
                        totalMarks += marks;
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    scanner.next();
                }
            }
        }
        double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}
