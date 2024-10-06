import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class JavaQuiz {
    private String[] questions = {
        "What is the default value of a local variable in Java?",
        "Which of the following is a valid way to declare a constant in Java?",
        "What is the purpose of the 'finally' block in a try-catch-finally statement?",
        "Which of the following is a valid way to create a new thread in Java?",
        "What is the difference between '==' and '.equals()' in Java?"
    };

    private String[][] options = {
        {"0", "null", "undefined", "not initialized"},
        {"final int x = 5;", "const int x = 5;", "int x = 5;", "static int x = 5;"},
        {"To handle exceptions", "To release resources", "To provide an alternate return path", "To repeat a block of code"},
        {"Thread t = new Thread();", "Thread t = new Thread(new Runnable() {...});", "Thread t = new Thread(new Thread() {...});", "Thread t = new Thread(new Runnable() {...}).start();"},
        {"'==' checks for reference equality, '.equals()' checks for value equality", "'==' checks for value equality, '.equals()' checks for reference equality", "'==' checks for reference equality, '.equals()' checks for value equality and reference equality", "'==' checks for value equality, '.equals()' checks for value equality and reference equality"}
    };

    private int[] correctAnswers = {3, 0, 1, 1, 0};

    private int score = 0;
    private int currentQuestion = 0;

    private Scanner scanner = new Scanner(System.in);

    public void startQuiz() {
        System.out.println("Welcome to the Java quiz!");
        displayQuestion();
    }

    private void displayQuestion() {
        if (currentQuestion < questions.length) {
            System.out.println("Question " + (currentQuestion + 1) + ": " + questions[currentQuestion]);
            for (int i = 0; i < options[currentQuestion].length; i++) {
                System.out.println((i + 1) + ". " + options[currentQuestion][i]);
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    displayResult();
                }
            }, 50000); // 50 seconds

            System.out.print("Enter your answer (1-" + options[currentQuestion].length + "): ");
            int answer = scanner.nextInt() - 1;

            if (answer == correctAnswers[currentQuestion]) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer was " + options[currentQuestion][correctAnswers[currentQuestion]]);
            }

            currentQuestion++;
            displayQuestion();
        } else {
            displayResult();
        }
    }

    private void displayResult() {
        System.out.println("Quiz over!");
        System.out.println("Your score: " + score + "/" + questions.length);
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            System.out.println("Correct answer: " + options[i][correctAnswers[i]]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        JavaQuiz quiz = new JavaQuiz();
        quiz.startQuiz();
    }
}
