package com.infobasic.controller;

import com.infobasic.model.User;
import com.infobasic.service.UserService;
import io.javalin.Javalin;

import java.sql.SQLException;

public class UserController {
    private final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public void registerRoutes(Javalin app) {
        // Endpoint per la registrazione
        app.post("/register", ctx -> {
            try {
                User user = ctx.bodyAsClass(User.class);
                boolean success = userService.createUser(user);

                if (success) {
                    ctx.status(201).result("Utente registrato con successo");
                } else {
                    ctx.status(400).result("Errore durante la registrazione");
                }
            } catch (SQLException e) {
                ctx.status(500).result("Errore SQL: " + e.getMessage());
            } catch (Exception e) {
                ctx.status(400).result("Errore: " + e.getMessage());
            }
        });

        // Endpoint per l'autenticazione
        app.post("/login", ctx -> {
            try {
                User user = ctx.bodyAsClass(User.class);
                boolean isAuthenticated = userService.authenticateUser(user.getUsername(), user.getPassword());

                if (isAuthenticated) {
                    ctx.status(200).result("Login effettuato con successo");
                } else {
                    ctx.status(401).result("Credenziali non valide");
                }
            } catch (SQLException e) {
                ctx.status(500).result("Errore SQL: " + e.getMessage());
            } catch (Exception e) {
                ctx.status(400).result("Errore: " + e.getMessage());
            }
        });
    }
}
