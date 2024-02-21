package com.backend.dao;

import java.util.List;

public interface IDao<T> {

    T registrar(T t);
    //List<T> buscarTodos();
    T buscarPorId(int id);

}
