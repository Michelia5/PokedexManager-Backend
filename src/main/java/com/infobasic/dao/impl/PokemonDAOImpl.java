package com.infobasic.dao.impl;

import com.infobasic.dao.PokemonDAO;
import com.infobasic.model.Pokemon;
import com.infobasic.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAOImpl implements PokemonDAO {

    @Override
    public List<Pokemon> getAllPokemon() throws SQLException {
        List<Pokemon> pokemonList = new ArrayList<>();
        String sql = "SELECT * FROM pokemon_data";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pokemon p = mapResultSetToPokemon(rs);
                pokemonList.add(p);
            }
        }
        return pokemonList;
    }

    @Override
    public Pokemon getPokemonByNationalNumber(int number) throws SQLException {
        String sql = "SELECT * FROM pokemon_data WHERE national_number = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, number);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToPokemon(rs);
                }
            }
        }
        return null;
    }

    private Pokemon mapResultSetToPokemon(ResultSet rs) throws SQLException {
        Pokemon p = new Pokemon();
        p.setNationalNumber(rs.getObject("national_number") == null ? null : rs.getInt("national_number"));
        p.setGen(rs.getString("gen"));
        p.setEnglishName(rs.getString("english_name"));
        p.setPrimaryType(rs.getString("primary_type"));
        p.setSecondaryType(rs.getString("secondary_type"));
        p.setClassification(rs.getString("classification"));
        p.setPercentMale(rs.getObject("percent_male") == null ? -1.0 : rs.getDouble("percent_male"));
        p.setPercentFemale(rs.getObject("percent_female") == null ? -1.0 : rs.getDouble("percent_female"));
        p.setHeightM(rs.getObject("height_m") == null ? null : rs.getDouble("height_m"));
        p.setWeightKg(rs.getObject("weight_kg") == null ? null : rs.getDouble("weight_kg"));
        p.setCaptureRate(rs.getObject("capture_rate") == null ? null : rs.getInt("capture_rate"));
        p.setHp(rs.getObject("hp") == null ? null : rs.getInt("hp"));
        p.setAttack(rs.getObject("attack") == null ? null : rs.getInt("attack"));
        p.setDefense(rs.getObject("defense") == null ? null : rs.getInt("defense"));
        p.setSpeed(rs.getObject("speed") == null ? null : rs.getInt("speed"));
        p.setAbilities0(rs.getString("abilities_0"));
        p.setAbilities1(rs.getString("abilities_1"));
        p.setAbilitiesSpecial(rs.getString("abilities_special"));
        p.setIsLegendary(rs.getObject("is_legendary") == null ? null : rs.getBoolean("is_legendary"));
        p.setIsMythical(rs.getObject("is_mythical") == null ? null : rs.getBoolean("is_mythical"));
        p.setEvochain0(rs.getString("evochain_0"));
        p.setEvochain2(rs.getString("evochain_2"));
        p.setEvochain4(rs.getString("evochain_4"));
        p.setDescription(rs.getString("description"));
        p.setEvo1Id(rs.getObject("evo1_id") == null ? null : rs.getInt("evo1_id"));
        p.setEvo2Id(rs.getObject("evo2_id") == null ? null : rs.getInt("evo2_id"));
        p.setEvo3Id(rs.getObject("evo3_id") == null ? null : rs.getInt("evo3_id"));
        p.setEvochain6(rs.getString("evochain_6"));
        p.setEvochain8(rs.getString("evochain_8"));
        p.setEvochain10(rs.getString("evochain_10"));
        p.setEvo4Id(rs.getObject("evo4_id") == null ? null : rs.getInt("evo4_id"));
        p.setEvo5Id(rs.getObject("evo5_id") == null ? null : rs.getInt("evo5_id"));
        p.setEvo6Id(rs.getObject("evo6_id") == null ? null : rs.getInt("evo6_id"));

        return p;
    }

    @Override
    public List<Pokemon> searchAndFilterPokemon(String query, String primaryType, String secondaryType, String gen) throws SQLException {
        List<Pokemon> pokemonList = new ArrayList<>();
        String sql = buildSearchQuery(query, primaryType, secondaryType, gen);

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            int paramIndex = setSearchQueryParameters(stmt, query, primaryType, secondaryType, gen);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pokemonList.add(mapResultSetToPokemon(rs));
                }
            }
        }
        return pokemonList;
    }

    /**
     * Costruisce dinamicamente la query di ricerca.
     */
    private String buildSearchQuery(String query, String primaryType, String secondaryType, String gen) {
        StringBuilder sql = new StringBuilder("SELECT * FROM pokemon_data WHERE 1=1");

        if (query != null && !query.isEmpty()) {
            sql.append(" AND (english_name LIKE ?");
            try {
                Integer.parseInt(query); // Se è un numero
                sql.append(" OR national_number = ?");
            } catch (NumberFormatException ignored) {
            }
            sql.append(")");
        }
        if (primaryType != null && !primaryType.isEmpty()) {
            sql.append(" AND primary_type = ?");
        }
        if (secondaryType != null && !secondaryType.isEmpty()) {
            sql.append(" AND secondary_type = ?");
        }
        if (gen != null && !gen.isEmpty()) {
            sql.append(" AND gen = ?");
        }

        return sql.toString();
    }

    /**
     * Imposta i parametri della query.
     */
    private int setSearchQueryParameters(PreparedStatement stmt, String query, String primaryType, String secondaryType, String gen) throws SQLException {
        int paramIndex = 1;

        if (query != null && !query.isEmpty()) {
            stmt.setString(paramIndex++, "%" + query + "%");
            try {
                int numberQuery = Integer.parseInt(query);
                stmt.setInt(paramIndex++, numberQuery);
            } catch (NumberFormatException ignored) {
                // Query non è un numero
            }
        }
        if (primaryType != null && !primaryType.isEmpty()) {
            stmt.setString(paramIndex++, primaryType);
        }
        if (secondaryType != null && !secondaryType.isEmpty()) {
            stmt.setString(paramIndex++, secondaryType);
        }
        if (gen != null && !gen.isEmpty()) {
            stmt.setString(paramIndex++, gen);
        }

        return paramIndex;
    }
}
