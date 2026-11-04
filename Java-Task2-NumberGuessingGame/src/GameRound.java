import java.util.Random;

public class GameRound
{
    public enum GuessResult {
        TOO_HIGH,
        TOO_LOW,
        CORRECT
    }

    private static final Random RANDOM = new Random();
    private final Difficulty difficulty;
    private final int secretNumber;
    private int attemptsUsed = 0;
    private boolean won = false;

    public GameRound(Difficulty difficulty)
    {
        this.difficulty = difficulty;
        this.secretNumber = RANDOM.nextInt(difficulty.getMaxNumber()) + 1;
    }

    public GuessResult guess(int value)
    {
        if(isOver())
        {
            throw new IllegalStateException("Round is already over.");
        }
        attemptsUsed++;
        if(value == secretNumber)
        {
            won = true;
            return GuessResult.CORRECT;
        }
        return value > secretNumber ? GuessResult.TOO_HIGH : GuessResult.TOO_LOW;
    }

    public boolean isInRange(int value)
    {
        return value >= 1 && value <= difficulty.getMaxNumber();
    }

    public boolean hasAttemptsLeft()
    {
       return attemptsUsed < difficulty.getMaxAttempts();
    }

    public boolean isOver()
    {
        return won || !hasAttemptsLeft();
    }

    public Difficulty getDifficulty() { return difficulty; }
    public int getSecretNumber() { return secretNumber; }
    public int getAttemptsUsed() { return attemptsUsed; }
    public boolean isWon() { return won; }
}