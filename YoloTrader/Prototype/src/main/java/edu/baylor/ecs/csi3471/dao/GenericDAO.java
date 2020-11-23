package edu.baylor.ecs.csi3471.dao;

import java.util.List;

public interface GenericDAO<T> {

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete (T t);

    boolean add(T t);

    void setAll(List<T> t);

    void saveAll();

    void loadAll();
}
