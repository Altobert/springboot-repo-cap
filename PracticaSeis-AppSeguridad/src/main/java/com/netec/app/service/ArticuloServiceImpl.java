package com.netec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.netec.app.dao.IArticuloDAO;
import com.netec.app.entities.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService {
	
	
	@Autowired
	private IArticuloDAO dao;
	
	
	@Override
	public Articulo findById(int id) {
		return dao.findById(id).orElse(null);
	}

	
	@Override
	public List<Articulo> findAll() {
		
		return (List<Articulo>) dao.findAll();
	}

	
	@Override
	public Articulo save(Articulo art) {
		
		return dao.save(art);
	}

	
	@Override
	public void delete(int id) {
		
		try {
			dao.deleteById(id);
			
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no se encuentra el articulo");
		}
		
	}


}
