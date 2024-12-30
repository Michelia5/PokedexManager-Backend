package com.infobasic.controller;

import com.infobasic.model.Pokemon;
import com.infobasic.service.PokemonService;
import io.javalin.Javalin;

import java.sql.SQLException;
import java.util.List;

public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController() {
        this.pokemonService = new PokemonService();
    }

    public void registerRoutes(Javalin app) {
        app.get("/pokemon", ctx -> {
            try {
                String query = ctx.queryParam("query");
                String gen = ctx.queryParam("gen");
                String primaryType = ctx.queryParam("primaryType");
                String secondaryType = ctx.queryParam("secondaryType");

                List<Pokemon> results = pokemonService.searchAndFilterPokemon(query, primaryType, secondaryType, gen);
                ctx.json(results);
            } catch (SQLException e) {
                System.err.println("Errore SQL: " + e.getMessage());
                e.printStackTrace();
                ctx.status(500).result("Errore SQL: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Errore Generico: " + e.getMessage());
                e.printStackTrace();
                ctx.status(500).result("Errore Generico: " + e.getMessage());
            }
        });


        app.get("/pokemon/{id}", ctx -> {
            try {
                int id = Integer.parseInt(ctx.pathParam("id"));
                Pokemon p = pokemonService.getPokemonByNumber(id);
                if (p == null) {
                    ctx.status(404).result("Pokémon non trovato!");
                } else {
                    if (p.getPercentMale() != null && p.getPercentMale() < 0.0) {
                        p.setPercentMale(null);
                        p.setPercentFemale(null);
                    }
                    ctx.json(p);
                }
            } catch (NumberFormatException e) {
                ctx.status(400).result("ID non valido");
            } catch (SQLException e) {
                ctx.status(500).result("Errore: " + e.getMessage());
            }
        });


    }
}
