package com.netec.app.service;

import java.util.List;

import com.netec.app.entities.Articulo;

public interface IArticuloService {
	
    Articulo findById(int id);
    List<Articulo> findAll();
    Articulo save(Articulo art);
    void delete(int id);

}

