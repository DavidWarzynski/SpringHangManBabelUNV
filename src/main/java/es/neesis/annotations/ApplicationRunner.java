package es.neesis.annotations;

import es.neesis.annotations.applications.HangmanApplication;
import es.neesis.annotations.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HangmanApplication hangmanApplication = context.getBean(HangmanApplication.class);
        hangmanApplication.startNewGame();
    }
}
