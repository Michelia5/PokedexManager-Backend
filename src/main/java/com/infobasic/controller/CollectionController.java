package com.infobasic.controller;

import com.infobasic.model.CollectionItem;
import com.infobasic.service.CollectionService;
import io.javalin.Javalin;

import java.sql.SQLException;
import java.util.List;

public class CollectionController {

    private final CollectionService collectionService;

    public CollectionController(Javalin app) {
        this.collectionService = new CollectionService();

        app.get("/collections", ctx -> {
            Integer userId = ctx.attribute("user_id");

            if (userId == null) {
                ctx.status(401).result("Accesso non autorizzato.");
                return;
            }

            String status = ctx.queryParam("status");
            try {
                List<CollectionItem> collections = collectionService.getUserCollections(userId, status);
                ctx.json(collections);
            } catch (SQLException e) {
                ctx.status(500).result("Errore durante il recupero delle collezioni.");
            }
        });


        app.post("/collections", ctx -> {
            int userId = ctx.attribute("user_id");
            CollectionItem item = ctx.bodyAsClass(CollectionItem.class);
            try {
                boolean success = collectionService.addToCollection(userId, item.getPokemonId(), item.getStatus());
                if (success) {
                    ctx.status(201).result("Aggiunto alla collezione.");
                } else {
                    ctx.status(400).result("Il Pokémon è già presente nella collezione.");
                }
            } catch (SQLException e) {
                ctx.status(500).result("Errore SQL.");
            }
        });


        app.delete("/collections", ctx -> {
            int userId = ctx.attribute("user_id"); // Recupera l'ID utente dal token JWT
            int pokemonId = Integer.parseInt(ctx.queryParam("pokemon_id"));
            try {
                boolean success = collectionService.removeFromCollection(userId, pokemonId);
                if (success) {
                    ctx.status(200).result("Rimosso dalla collezione.");
                } else {
                    ctx.status(400).result("Errore durante la rimozione dalla collezione.");
                }
            } catch (SQLException e) {
                ctx.status(500).result("Errore SQL.");
            }
        });
    }
}
