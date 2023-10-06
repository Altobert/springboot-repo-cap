package com.netec.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.netec.app.entities.Articulo;

public interface IArticuloDAO extends CrudRepository<Articulo, Integer> {

}
