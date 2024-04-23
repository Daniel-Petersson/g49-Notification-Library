package se.lexicon.dao;

import java.util.List;

public interface NotificationDao<T> {
    T save(T t);
    void update(T t);
    T find(String id);
    List<T> findAll();
}
