package com.infobasic.service;

import com.infobasic.dao.CollectionDAO;
import com.infobasic.dao.impl.CollectionDAOImpl;
import com.infobasic.model.CollectionItem;

import java.sql.SQLException;
import java.util.List;

public class CollectionService {
    private final CollectionDAO collectionDAO;

    public CollectionService() {
        this.collectionDAO = new CollectionDAOImpl();
    }

    public List<CollectionItem> getUserCollections(int userId, String status) throws SQLException {
        return collectionDAO.getUserCollections(userId, status);
    }

    public boolean addToCollection(int userId, int pokemonId, String status) throws SQLException {
        // Controlla se il Pokémon è già nella collezione
        if (collectionDAO.isInCollection(userId, pokemonId)) {
            return false; // Già presente nella collezione
        }

        // Se non è presente, aggiungilo
        return collectionDAO.addToCollection(userId, pokemonId, status);
    }


    public boolean removeFromCollection(int userId, int pokemonId) throws SQLException {
        return collectionDAO.removeFromCollection(userId, pokemonId);
    }
}
