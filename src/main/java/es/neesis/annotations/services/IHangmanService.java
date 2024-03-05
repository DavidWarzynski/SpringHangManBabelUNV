package es.neesis.annotations.services;

public interface IHangmanService {
    void startNewGame(String targetWord);
    void guessLetter(char letter);
    void guessWord(String word);
    String getMaskedWord();
    String getTargetWord();
    int getRemainingAttempts();
}
