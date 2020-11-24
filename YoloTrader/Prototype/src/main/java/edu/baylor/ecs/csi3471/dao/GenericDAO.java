package edu.baylor.ecs.csi3471.dao;

import java.util.List;

/**
 * This is a generic DAO that defines the methods of all the DAO's that we use
 *
 * @author owenmurphy
 * @param <T> data type t
 */
public interface GenericDAO<T> {

    /**
     * @return the list of all
     */
    List<T> getAll();

    /**
     * save to parameter to the list
     * @param t parameter to be saved
     */
    void save(T t);

    /**
     * updates item t at index
     * @param index index of item
     * @param t item to be updated
     */
    void update(int index, T t);

    /**
     * deletes the item t from the list
     * @param t item to be deleted
     */
    void delete (T t);

    /**
     * adds the item to to the list
     * @param t item to be added
     */
    void add(T t);

    /**
     * sets the list of items to the parameter passed in
     * @param t list of items
     */
    void setAll(List<T> t);

    /**
     * saves all the items
     */
    void saveAll();

    /**
     * lodes the items into the dao
     */
    void loadAll();
}
