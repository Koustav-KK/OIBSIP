public enum Difficulty
{
    EASY("Easy", 50, 10),
    MEDIUM("Medium", 100, 7),
    HIGH("Hard", 200, 5);


    private final String label;
    private final int maxNumber;
    private final int maxAttempts;

    Difficulty(String label, int maxNumber, int maxAttempts) {
        this.label = label;
        this.maxNumber = maxNumber;
        this.maxAttempts = maxAttempts;
    }

    public String getLabel() {
        return label;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

}
