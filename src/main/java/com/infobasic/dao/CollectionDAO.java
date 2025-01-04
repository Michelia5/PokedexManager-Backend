package com.infobasic.dao;

import com.infobasic.model.CollectionItem;

import java.sql.SQLException;
import java.util.List;

public interface CollectionDAO {
    List<CollectionItem> getUserCollections(int userId, String status) throws SQLException;
    boolean addToCollection(int userId, int pokemonId, String status) throws SQLException;
    boolean removeFromCollection(int userId, int pokemonId) throws SQLException;
    boolean isInCollection(int userId, int pokemonId) throws SQLException;
    boolean updateStatus(int userId, int pokemonId, String newStatus)throws SQLException;
}
