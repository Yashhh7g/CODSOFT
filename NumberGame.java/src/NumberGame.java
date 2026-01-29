import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        boolean playAgain = true;

        System.out.println("==================================");
        System.out.println("  WELCOME TO THE NUMBER GAME 🎯");
        System.out.println("==================================");

        while (playAgain) {

            int number = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 5;
            boolean isGuessed = false;

            System.out.println("\nI have chosen a number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts to guess it.");

            while (attempts > 0) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("🎉 Correct! You guessed the number.");
                    score++;
                    isGuessed = true;
                    break;
                } else if (guess > number) {
                    attempts--;
                    System.out.println("Too HIGH! Attempts left: " + attempts);
                } else {
                    attempts--;
                    System.out.println("Too LOW! Attempts left: " + attempts);
                }
            }

            if (!isGuessed) {
                System.out.println("❌ Out of attempts!");
                System.out.println("The correct number was: " + number);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            sc.nextLine(); // consume leftover newline
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n==================================");
        System.out.println(" GAME OVER");
        System.out.println(" Your Score: " + score);
        System.out.println("==================================");

        sc.close();
    }
}
