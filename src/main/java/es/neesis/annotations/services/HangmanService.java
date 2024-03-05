package es.neesis.annotations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HangmanService implements IHangmanService{


    private HangmanStatus hangmanStatus;

    public HangmanService(){
        this.hangmanStatus = new HangmanStatus();
    }


    @Override
    public void startNewGame(String targetWord) {
       StringBuilder maskedWord = new StringBuilder("_".repeat(targetWord.length()));
        int remainingAttempts = 8;

        hangmanStatus.setTargetWord(targetWord);
        hangmanStatus.setMaskedWord(maskedWord);
        hangmanStatus.setRemainingAttempts(remainingAttempts);

    }

    @Override
    public void guessLetter(char letter) {
        boolean letterFound = false;
        for (int i = 0; i < hangmanStatus.getTargetWord().length(); i++) {
            if (hangmanStatus.getTargetWord().charAt(i) == letter) {
                hangmanStatus.getMaskedWord().setCharAt(i, letter);
                letterFound = true;
            }
        }
        if (!letterFound) {
            hangmanStatus.setRemainingAttempts(hangmanStatus.getRemainingAttempts()-1);
        }
    }

    @Override
    public void guessWord(String word) {
        if (word.equalsIgnoreCase(hangmanStatus.getTargetWord())) {
            hangmanStatus.setMaskedWord(new StringBuilder(hangmanStatus.getTargetWord()));
        } else {
            hangmanStatus.setRemainingAttempts(hangmanStatus.getRemainingAttempts()-1);
        }
    }


    @Override
    public String getMaskedWord() {
        return hangmanStatus.getMaskedWord().toString();
    }

    @Override
    public String getTargetWord() {
        return hangmanStatus.getTargetWord();
    }

    @Override
    public int getRemainingAttempts() {
        return hangmanStatus.getRemainingAttempts();
    }

    @Override
    public boolean isGameOver() {
        return hangmanStatus.getRemainingAttempts() <= 0 || hangmanStatus.getMaskedWord().indexOf("_") == -1;
    }

    @Override
    public boolean isGameWon() {
        return hangmanStatus.getMaskedWord().indexOf("_") == -1;
    }
}
