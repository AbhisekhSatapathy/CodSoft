import java.util.Scanner; 
 
public class GradeCalculator
{ 
        public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
 
        System.out.print("Enter the number of subjects: "); 
        int numSubjects = scanner.nextInt(); 
 
        // Array to store marks of each subject 
        int[] marks = new int[numSubjects]; 
 
        // Input marks for each subject 
        for (int i = 0; i < numSubjects; i++)
        { 
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": "); 
            marks[i] = scanner.nextInt(); 
        } 
 
        // Calculate total marks 
        int totalMarks = 0; 
        for (int mark : marks)
        { 
            totalMarks += mark; 
        } 
 
        // Calculate average percentage 
        double averagePercentage = (double) totalMarks / numSubjects; 
 
        // Grade Calculation 
        String grade; 
        if (averagePercentage >= 90)
        { 
            grade = "Grade- O"; 
        }
        else if (averagePercentage >= 80)
        { 
            grade = "Grade- A"; 
        }
        else if (averagePercentage >= 70)
        { 
            grade = "Grade- B"; 
        }
        else if (averagePercentage >= 60)
        { 
            grade = "Grade- C"; 
        } 
        else if (averagePercentage >= 50)
        { 
            grade = "Grade- D"; 
        }
        else if (averagePercentage >= 40)
        { 
            grade = "Grade- E"; 
        }
        else
        { 
            grade = "Grade- FAIL"; 
        } 
 
        // Display Results 
        System.out.println("\nTotal Marks: " + totalMarks); 
        System.out.println("Average Percentage: " + averagePercentage); 
        System.out.println(grade); 
 
        scanner.close(); 
    } 
}
