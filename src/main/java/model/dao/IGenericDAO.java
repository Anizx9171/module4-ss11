package model.dao;

import model.entity.Product;

import java.util.List;

public interface IGenericDAO<T,ID> {
    List<T> findAll();
    boolean  create();
    void remove(ID id);

    boolean update(ID id);

    T findById(ID id);

}
