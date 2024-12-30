package com.infobasic.dao.impl;

import com.infobasic.dao.CollectionDAO;
import com.infobasic.model.CollectionItem;
import com.infobasic.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectionDAOImpl implements CollectionDAO {

    @Override
    public List<CollectionItem> getUserCollections(int userId, String status) throws SQLException {
        String sql = "SELECT * FROM collections WHERE user_id = ? AND status = ?";
        List<CollectionItem> collections = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, status);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    collections.add(new CollectionItem(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getInt("pokemon_id"),
                            rs.getString("status")
                    ));
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
                    return rs.getInt(1) > 0; // Ritorna true se il conteggio è maggiore di 0
                }
            }
        }
        return false;
    }

}

