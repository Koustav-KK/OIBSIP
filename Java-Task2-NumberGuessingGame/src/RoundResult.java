public record RoundResult(int roundNumber, Difficulty difficulty, boolean won,
                          int attempts, int secretNumber) {
    public String summary() {
        if (won) {
            return "Round " + roundNumber + " — guessed in " + attempts
                    + (attempts == 1 ? " attempt" : " attempts")
                    + " (" + difficulty.getLabel() + ")";
        }

        return "Round " + roundNumber + " — lost, number was " + secretNumber
                + " (" + difficulty.getLabel() + ")";
    }
}
