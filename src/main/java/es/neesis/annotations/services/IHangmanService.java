package es.neesis.annotations.services;

public interface IHangmanService {
    void startNewGame();
    void guessLetter(char letter);
    void guessWord(String word);
    boolean isGameOver();
    boolean isGameWon();
    String getMaskedWord();
    String getTargetWord();
    int getRemainingAttempts();
}
