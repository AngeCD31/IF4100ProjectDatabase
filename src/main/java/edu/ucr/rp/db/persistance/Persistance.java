package edu.ucr.rp.db.persistance;

import java.util.List;

public interface Persistance<T, K> {

    void create(T object) throws PersistanceException;

    List<T> read(K key) throws PersistanceException;

    List<T> read() throws PersistanceException;

    void update(T object) throws PersistanceException;

    void delete(T object) throws PersistanceException;

    boolean isConnected();
}
