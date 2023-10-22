import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int min = 1;
        int max = 100;
        int attempts = 6;
        int rounds = 0;
        int score = 0;

        while (true) {
            int Number = r.nextInt(max - min + 1) + min;
            int guess;
            int Count = 0;

            System.out.println("The given number is between " + min + " and " + max + ". Guess the number. ");
            System.out.println("You have " + attempts + " attempts.");

            while (true) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                Count++;

                if (guess == Number) {
                    System.out.println("Congratulations! You guessed the correct number: " + Number);
                    score += attempts - Count + 1;
                    break;
                } else if (guess < Number) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                if (Count == attempts) {
                    System.out.println("You've run out of attempts. The correct number was: " + Number);
                    break;
                }
            }

            rounds++;

            System.out.println("Do you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game Over!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Total Score: " + score);


    }
}