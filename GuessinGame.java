import java.util.*;
public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerLimit = 1;
        int upperLimit = 100;
        int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
        int attempts = 0;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;
        System.out.println("Welcome to the Guessing Game!");
        while (true) {
            System.out.printf("Guess the number between %d and %d: ", lowerLimit, upperLimit);
            int userGuess;
            try {
                userGuess = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
                continue;
            }
            attempts++;
            if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.printf("Congratulations! You guessed the correct number %d in %d attempts.%n", secretNumber, attempts);
                score++;
                rounds++;
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();
                if (!playAgain.equals("yes")) {
                    System.out.printf("Game over. Your score: %d rounds won.%n", score);
                    break;
                }     
                secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                attempts = 0;
            }
            if (attempts >= maxAttempts) {
                System.out.printf("Sorry, you've reached the maximum number of attempts (%d). The secret number was %d.%n", maxAttempts, secretNumber);
                rounds++;
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();
                if (!playAgain.equals("yes")) {
                    System.out.printf("Game over. Your score: %d rounds won.%n", score);
                    break;
                }              
                secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                attempts = 0;
            }
        }
        scanner.close();
    }
}
