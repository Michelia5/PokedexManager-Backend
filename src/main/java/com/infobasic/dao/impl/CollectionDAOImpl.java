package com.infobasic.dao.impl;

import com.infobasic.dao.CollectionDAO;
import com.infobasic.model.CollectionItem;
import com.infobasic.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CollectionDAOImpl implements CollectionDAO {

    @Override
    public List<CollectionItem> getUserCollections(int userId, String status) throws SQLException {
        String sql =
                "SELECT c.id, c.user_id AS userId, c.pokemon_id AS pokemonId, c.status, " +
                        "       p.english_name AS englishName, p.primary_type AS primaryType, p.secondary_type AS secondaryType " +
                        "FROM collections c " +
                        "JOIN pokemon_data p ON c.pokemon_id = p.national_number " +
                        "WHERE c.user_id = ? AND c.status = ?";

        List<CollectionItem> collections = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, status);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    CollectionItem item = new CollectionItem();
                    // compila i campi di CollectionItem
                    item.setId(rs.getInt("id"));
                    item.setUserId(rs.getInt("userId"));
                    item.setPokemonId(rs.getInt("pokemonId"));
                    item.setStatus(rs.getString("status"));

                    // campi uniti
                    item.setEnglishName(rs.getString("englishName"));
                    item.setPrimaryType(rs.getString("primaryType"));
                    item.setSecondaryType(rs.getString("secondaryType"));

                    collections.add(item);
                }
            }
        }
        return collections;
    }


    @Override
    public boolean addToCollection(int userId, int pokemonId, String status) throws SQLException {
        String sql = "INSERT INTO collections (user_id, pokemon_id, status) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, pokemonId);
            stmt.setString(3, status);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean removeFromCollection(int userId, int pokemonId) throws SQLException {
        String sql = "DELETE FROM collections WHERE user_id = ? AND pokemon_id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, pokemonId);
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean isInCollection(int userId, int pokemonId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM collections WHERE user_id = ? AND pokemon_id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, pokemonId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    @Override
    public boolean updateStatus(int userId, int pokemonId, String newStatus) throws SQLException {
        String sql = "UPDATE collections SET status = ? WHERE user_id = ? AND pokemon_id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newStatus);
            stmt.setInt(2, userId);
            stmt.setInt(3, pokemonId);

            int rows = stmt.executeUpdate();
            return rows > 0; // true se almeno una riga è stata aggiornata
        }
    }
}
