package com.infobasic;

import com.infobasic.controller.UserController;
import com.infobasic.controller.PokemonController;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.showJavalinBanner = false;

            // Configurazione CORS aggiornata
            config.plugins.enableCors(cors -> {
                cors.add(it -> {
                    it.allowHost("http://localhost:5173"); // Permetti richieste dal frontend
                });
            });
        }).start(7000);

        // Registrazione delle rotte
        PokemonController pokemonController = new PokemonController();
        pokemonController.registerRoutes(app);

        UserController userController = new UserController();
        userController.registerRoutes(app);
    }
}
