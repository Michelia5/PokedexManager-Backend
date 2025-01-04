package com.infobasic;

import com.infobasic.controller.UserController;
import com.infobasic.controller.PokemonController;
import com.infobasic.controller.CollectionController;
import com.infobasic.service.UserService;
import com.infobasic.util.JWTUtil;
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

        // Middleware per proteggere gli endpoint
        app.before(ctx -> {
            if (ctx.path().startsWith("/collections")) {
                String authHeader = ctx.header("Authorization");
                String status = ctx.queryParam("status");

                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    ctx.status(401).result("Token non presente o non valido");
                    return;
                }

                String token = authHeader.substring(7);
                try {
                    String username = JWTUtil.validateToken(token);
                    UserService userService = new UserService();
                    var user = userService.getUserByUsername(username);

                    if (user == null) {
                        ctx.status(401).result("Utente non trovato");
                        return;
                    }

                    ctx.attribute("user_id", user.getId());
                } catch (Exception e) {
                    ctx.status(401).result("Token non valido o scaduto");
                }
            }
        });



        // Registrazione delle rotte
        PokemonController pokemonController = new PokemonController();
        pokemonController.registerRoutes(app);

        UserController userController = new UserController();
        userController.registerRoutes(app);

        // Registra le rotte per CollectionController direttamente
        new CollectionController(app);

    }
}
