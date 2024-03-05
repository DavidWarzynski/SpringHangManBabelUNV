package es.neesis.annotations.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class WordProviderService implements IWordProviderService{

    private static final List<String> words =
            List.of("PROGRAMACION", "JAVA", "SPRING", "DESAFIO",
                    "INTELIGENCIA", "ARTIFICIAL", "DESARROLLO",
                    "WEB", "APLICACION", "COMPUTADORA");

    @Override
    public String getRandomWord() {
        return words.get(new Random().nextInt(words.size()));
    }
}
