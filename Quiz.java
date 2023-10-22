import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private static String[] questions = {
            "What is the capital of India?",
            "Who is Current Prime Minister of India?",
            "Which team has won 2019 ICC Mens World Cup?",
            "What is the chemical symbol for Copper?",
            "What is the largest country in World?"
    };

    private static String[][] options = {
            {"Paris", "London", "New Delhi", "Madrid"},
            {"Amit Shah", "Manmohan Singh", "Rahul Gandhi", "Narendra Modi"},
            {"Pakistan", "India", "England", "New Zealand"},
            {"Cu", "Ag", "Fe", "Pb"},
            {"United States of America", "Russia", "China", "Canada"}
    };

    private static int[] answers = {2, 3, 2, 0, 1};

    private static int score = 0;
    private static int questionIndex = 0;
    private static final int MAX_QUESTIONS = questions.length;
    private static final int TIME_LIMIT = 10;
    private static boolean[] answered = new boolean[MAX_QUESTIONS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("You have " + TIME_LIMIT + " seconds to answer each question.");

        while (questionIndex < MAX_QUESTIONS) {
            if (!answered[questionIndex]) {
                System.out.println("Question " + (questionIndex + 1) + ": " + questions[questionIndex]);
                for (int i = 0; i < options[questionIndex].length; i++) {
                    System.out.println((i + 1) + ". " + options[questionIndex][i]);
                }


                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Time's up! You didn't answer this question.");
                        answered[questionIndex] = true;
                        questionIndex++;
                    }
                };
                timer.schedule(task, TIME_LIMIT * 1000);

                System.out.print("Enter the number of your answer: ");
                int userAnswer = scanner.nextInt();

                // Stop the timer
                task.cancel();

                if (userAnswer == answers[questionIndex] + 1) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer is: " + options[questionIndex][answers[questionIndex]]);
                    System.out.println();
                }

                answered[questionIndex] = true;
                questionIndex++;
            }
        }

        scanner.close();

        System.out.println("Quiz ended. Your score is: " + score + "/" + MAX_QUESTIONS);
    }
}
