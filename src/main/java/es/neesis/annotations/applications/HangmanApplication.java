package es.neesis.annotations.applications;

import es.neesis.annotations.services.IHangmanService;
import es.neesis.annotations.services.IWordProviderService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class HangmanApplication {

    private IHangmanService hangmanService;
    private IWordProviderService wordProviderService;
    private Scanner scanner;

    public HangmanApplication(IHangmanService hangmanGameService,
                              IWordProviderService wordProviderService) {
        this.hangmanService = hangmanGameService;
        this.wordProviderService= wordProviderService;
        this.scanner = new Scanner(System.in);
    }
    public void startNewGame(){
        showWelcome();

        boolean continuePlaying = true;
        while (continuePlaying) {

            hangmanService.startNewGame(wordProviderService.getRandomWord().toUpperCase());

            while (!hangmanService.isGameOver()) {
                showGameStatus();
                playRound();
            }
            
            showEndGame();
            continuePlaying = showContinuePlaying();
        }
    }

    private  void showWelcome() {
        System.out.println("¡Bienvenido al Juego del Ahorcado!");
    }

    private void showEndGame() {
        if (hangmanService.isGameWon()) {
            System.out.println("¡Felicidades! ¡Has adivinado la palabra correctamente!");
        } else {
            System.out.println("Lo siento, has agotado todos los intentos." +
                    " La palabra correcta era: " + hangmanService.getTargetWord());
        }
    }

    private boolean showContinuePlaying(){
        System.out.print("¿Quieres jugar de nuevo? (S/N): ");
        String playAgain = scanner.next();
        return playAgain.equalsIgnoreCase("S");
    }

    private void playRound() {
        System.out.print("Ingrese una letra o palabra: ");
        String input = scanner.next();

        if (input.length() == 1) {
            char letter = input.toUpperCase().charAt(0);
            hangmanService.guessLetter(letter);
        } else {
            hangmanService.guessWord(input.toUpperCase());
        }
    }

    private void showGameStatus() {
        System.out.println("Palabra: " + hangmanService.getMaskedWord());
        System.out.println("Intentos restantes: " + hangmanService.getRemainingAttempts());
    }

}
