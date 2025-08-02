import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            names[i] = sc.next();

            System.out.print("Enter marks of " + names[i] + ": ");
            marks[i] = sc.nextInt();
        }

        int sum = 0, highest = marks[0], lowest = marks[0];
        String highestName = names[0], lowestName = names[0];

        for (int i = 0; i < n; i++) {
            sum += marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
                highestName = names[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
                lowestName = names[i];
            }
        }

        double average = (double) sum / n;

        System.out.println("\n--- Summary Report ---");
        System.out.println("Average Marks: " + average);
        System.out.println("Highest Marks: " + highest + " (by " + highestName + ")");
        System.out.println("Lowest Marks: " + lowest + " (by " + lowestName + ")");
    }
}
