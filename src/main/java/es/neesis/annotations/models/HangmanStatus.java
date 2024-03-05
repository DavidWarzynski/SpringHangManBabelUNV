package es.neesis.annotations.models;

public class HangmanStatus {
    private String targetWord;
    private StringBuilder maskedWord;
    private int remainingAttempts;

    public HangmanStatus(){

    }
    public HangmanStatus(String targetWord, StringBuilder maskedWord, int remainingAttempts) {
        this.targetWord = targetWord;
        this.maskedWord = maskedWord;
        this.remainingAttempts = remainingAttempts;
    }

    public String getTargetWord() {
        return targetWord;
    }

    public StringBuilder getMaskedWord() {
        return maskedWord;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public void setTargetWord(String targetWord) {
        this.targetWord = targetWord;
    }

    public void setMaskedWord(StringBuilder maskedWord) {
        this.maskedWord = maskedWord;
    }

    public void setRemainingAttempts(int remainingAttempts) {
        this.remainingAttempts = remainingAttempts;
    }
}
