package es.neesis.annotations.services;

import org.springframework.stereotype.Service;

@Service
public class HangmanStatusService implements IHangmanStatusService {

    public boolean isGameOver(int remainingAttempts, String maskedWord) {
        return remainingAttempts <= 0 || !maskedWord.contains("_");
    }

    public boolean isGameWon(String maskedWord) {
        return !maskedWord.contains("_");
    }
}
