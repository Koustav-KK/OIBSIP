import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    private static final List<RoundResult> results = new ArrayList<>();

    public static void main(String[] args)
    {
        System.out.println("===== NUMBER GUESSING GAME =====");
        int roundNumber = 1;

        while (true) {
            Difficulty difficulty = chooseDifficulty();
            RoundResult result = playRound(roundNumber, difficulty);
            results.add(result);
            System.out.println(result.summary());

            if (!askPlayagain()) {
                break;
            }
            roundNumber++;
        }
            printSummary();
            System.out.println("Thanks for playing!");
        }

        private static Difficulty chooseDifficulty()
        {
            Difficulty[] levels = Difficulty.values();
            System.out.println("\nSelect Difficulty");

            for (int i = 0; i < levels.length; i++)
            {
                Difficulty d = levels[i];
                System.out.println((i + 1) + ". " + d.getLabel() + " (1-" + d.getMaxNumber()
                        + ", " + d.getMaxAttempts() + " attempts)");
            }

            while (true)
            {
                int choice = readInt("Choice (1-" + levels.length + "): ");
                if (choice >= 1 && choice <= levels.length) {
                    return levels[choice - 1];
                }
                System.out.println("Invalid choice.");
            }
        }

        private static RoundResult playRound(int roundNumber, Difficulty difficulty) {
        GameRound round = new GameRound(difficulty);
        System.out.println("\nRound " + roundNumber + " (" + difficulty.getLabel()
                + "): I'm thinking of a number between 1 and " + difficulty.getMaxNumber() + ".");


        while (!round.isOver()) {
            int guess = readInt("Attempt " + (round.getAttemptsUsed() + 1) + " of "
                    + difficulty.getMaxAttempts() + " — your guess: ");

            if (!round.isInRange(guess)) {
                System.out.println("Out of range. Enter 1-" + difficulty.getMaxNumber() + ".");
                continue;
            }

            switch (round.guess(guess)) {
                case TOO_HIGH -> System.out.println("Too High!");
                case TOO_LOW -> System.out.println("Too Low!");
                case CORRECT -> System.out.println("Correct!");
            }
        }

        if (round.isWon()) {
            System.out.println("You guessed it in " + round.getAttemptsUsed() + " attempts!");
        } else {
            System.out.println("You Lost! The number was " + round.getSecretNumber() + ".");
        }

        return new RoundResult(roundNumber, difficulty, round.isWon(),
                round.getAttemptsUsed(), round.getSecretNumber());
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static boolean askPlayagain() {
        while (true) {
            System.out.print("\nPlay again? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("y")) return true;
            if (answer.equals("n")) return false;
            System.out.println("Please enter y or n.");
        }
    }

    private static void printSummary() {
        System.out.println("\n===== GAME SUMMARY =====");
        int wins = 0;
        int best = Integer.MAX_VALUE;

        for (RoundResult r : results) {
            System.out.println(r.summary());
            if (r.won()) {
                wins++;
                best = Math.min(best, r.attempts());
            }
        }

        System.out.println("\nRounds played: " + results.size());
        System.out.println("Rounds won: " + wins);
        if (wins > 0) System.out.println("Best score: " + best + " attempts");
    }
}


