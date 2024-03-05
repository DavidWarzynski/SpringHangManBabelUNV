package es.neesis.annotations.services;

import org.springframework.stereotype.Service;

@Service
public class HangmanService implements IHangmanService{


    private IWordProviderService wordProviderService;

    private String targetWord;
    private StringBuilder maskedWord;
    private int remainingAttempts;

    public HangmanService(IWordProviderService wordProviderService){
        this.wordProviderService = wordProviderService;
    }

    @Override
    public void startNewGame() {
        targetWord = wordProviderService.getRandomWord().toUpperCase();
        maskedWord = new StringBuilder("_".repeat(targetWord.length()));
        remainingAttempts = 8;
    }

    @Override
    public void guessLetter(char letter) {
        boolean letterFound = false;
        for (int i = 0; i < targetWord.length(); i++) {
            if (targetWord.charAt(i) == letter) {
                maskedWord.setCharAt(i, letter);
                letterFound = true;
            }
        }
        if (!letterFound) {
            remainingAttempts--;
        }
    }

    @Override
    public void guessWord(String word) {
        if (word.equalsIgnoreCase(targetWord)) {
            maskedWord = new StringBuilder(targetWord);
        } else {
            remainingAttempts--;
        }
    }


    @Override
    public String getMaskedWord() {
        return maskedWord.toString();
    }

    @Override
    public String getTargetWord() {
        return targetWord;
    }

    @Override
    public int getRemainingAttempts() {
        return remainingAttempts;
    }
}
