package com.infobasic.service;

import com.infobasic.dao.PokemonDAO;
import com.infobasic.dao.impl.PokemonDAOImpl;
import com.infobasic.model.Pokemon;

import java.sql.SQLException;
import java.util.List;

public class PokemonService {
    private final PokemonDAO pokemonDAO;

    public PokemonService() {
        this.pokemonDAO = new PokemonDAOImpl();
    }

    public List<Pokemon> getAllPokemon() throws SQLException {
        return pokemonDAO.getAllPokemon();
    }

    public Pokemon getPokemonByNumber(int number) throws SQLException {
        return pokemonDAO.getPokemonByNationalNumber(number);
    }

    public List<Pokemon> searchAndFilterPokemon(String query, String primaryType, String secondaryType, String gen) throws SQLException {
        return pokemonDAO.searchAndFilterPokemon(query, primaryType, secondaryType, gen);
    }
}
