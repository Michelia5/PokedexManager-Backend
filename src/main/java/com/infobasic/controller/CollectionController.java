package com.infobasic.controller;

import com.infobasic.model.CollectionItem;
import com.infobasic.service.CollectionService;
import io.javalin.Javalin;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CollectionController {

    private final CollectionService collectionService;

    public static class UpdateStatusRequest {
        public int pokemonId;
        public String newStatus;
    }

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
            Integer userId = ctx.attribute("user_id");

            if (userId == null) {
                ctx.status(401).result("Accesso non autorizzato.");
                return;
            }

            String body = ctx.body(); // Legge il corpo come stringa
            if (body == null || body.isBlank()) {
                ctx.status(400).result("Il corpo della richiesta è vuoto.");
                return;
            }

            CollectionItem item;
            try {
                item = ctx.bodyAsClass(CollectionItem.class);
            } catch (Exception e) {
                ctx.status(400).result("Formato JSON non valido.");
                return;
            }

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
            Integer userId = ctx.attribute("user_id");
            int pokemonId = Integer.parseInt(ctx.queryParam("pokemon_id"));

            try {
                boolean success = collectionService.removeFromCollection(userId, pokemonId);
                if (success) {
                    ctx.status(200).result("Rimosso dalla collezione.");
                } else {
                    ctx.status(400).result("Errore durante la rimozione.");
                }
            } catch (SQLException e) {
                ctx.status(500).result("Errore SQL.");
            }
        });

        app.put("/collections", ctx -> {
            // Recupero l'ID utente dal contesto
            Integer userId = ctx.attribute("user_id");
            if (userId == null) {
                ctx.status(401).result("Accesso non autorizzato.");
                return;
            }

            UpdateStatusRequest req = ctx.bodyAsClass(UpdateStatusRequest.class);

            try {
                boolean success = collectionService.updateStatus(userId, req.pokemonId, req.newStatus);
                if (success) {
                    ctx.status(200).result("Status aggiornato con successo");
                } else {
                    ctx.status(400).result("Impossibile aggiornare lo status (elemento non trovato o status non valido).");
                }
            } catch (Exception e) {
                ctx.status(500).result("Errore server: " + e.getMessage());
            }
        });


    }
}
