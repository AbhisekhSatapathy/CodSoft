import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;
        System.out.println("Welcome to Guess the Number Game!!!");
        while (playAgain)
        {
            int attempts = 0;
            int randomNumber = random.nextInt(100) + 1; // Generates random number between 1 and 100 
            boolean guessedCorrectly = false;
            System.out.println("\nI have selected a number between 1 and 100. Try to guess it!!!");
            while (!guessedCorrectly && attempts < 10) 
            { // Limiting attempts to 10
                System.out.print("Enter your guess (between 1 and 100): ");
                int guess = scanner.nextInt();
                scanner.nextLine();
                attempts++;
                if (guess < randomNumber)
                {
                    System.out.println("Too low! Try to guess high.");
                }
                else if (guess > randomNumber)
                {
                    System.out.println("Too high! Try to guess low.");
                }
                else
                {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    score += 10 - attempts; // Score based on attempts taken
                    guessedCorrectly = true;
                }
            }
            if (!guessedCorrectly)
            {
                System.out.println("Sorry, you've run out of attempts. The number was " + randomNumber);
            }
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playChoice = scanner.nextLine().toLowerCase();
            playAgain = playChoice.equals("yes") || playChoice.equals("y");
        }
        System.out.println("\nGame Over! Your total score is: " + score);
        scanner.close();
    }
}
