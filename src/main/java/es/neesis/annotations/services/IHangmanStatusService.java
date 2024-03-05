package es.neesis.annotations.services;

public interface IHangmanStatusService {
    boolean isGameOver(int remainingAttempts, String maskedWord);

    boolean isGameWon(String maskedWord);
}
