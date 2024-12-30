package com.infobasic.dao;

import com.infobasic.model.Pokemon;
import java.sql.SQLException;
import java.util.List;

public interface PokemonDAO {
    List<Pokemon> getAllPokemon() throws SQLException;
    Pokemon getPokemonByNationalNumber(int number) throws SQLException;

    List<Pokemon> searchAndFilterPokemon(String query, String primaryType, String secondaryType, String gen) throws SQLException;
}
