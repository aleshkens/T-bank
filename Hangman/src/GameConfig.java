public interface GameConfig {
    void startGame();
    void endGame();
    void usedLetter(char letter);
    void currentWord();
    boolean isGameWon();
    boolean isGameOver();
}
