import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1; // generate a random number between 1 and 100
        int attempts = 6;
        int score = 0;
        int rounds = 1;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Let's play a game of guessing the random number.");
            System.out.println("**Round " + rounds + "**");
            System.out.println("You have " + attempts + " attempts to guess the number.");
            System.out.print("Enter your first guess (between 1 and 100): ");

            int guess = scanner.nextInt();

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                score++;
                break;
            } else if (guess < secretNumber) {
                System.out.println("Your guess is too low. Try again!");
                attempts--;
            } else {
                System.out.println("Your guess is too high. Try again!");
                attempts--;
            }

            if (attempts == 0) {
                System.out.println("You ran out of attempts. The correct answer was " + secretNumber + ".");
                break;
            }

            System.out.print("Enter your next guess (between 1 and 100): ");
        }

        System.out.println("Your final score is " + score + " out of " + rounds + " rounds.");
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next();

        if (response.equalsIgnoreCase("yes")) {
            rounds++;
            attempts = 6;
            secretNumber = random.nextInt(100) + 1;
            score = 0;
        } else {
            System.out.println("Thanks for playing!");
        }
    }
}