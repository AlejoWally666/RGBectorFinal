package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.IEntregas;
import com.example.rgbector.models.entities.entregas;

@Service
public class EntregasService implements IEntregasService{

	@Autowired //Inyeccion de dependencia
	private IEntregas dao;

	@Override
	@Transactional
	public void save(entregas a) {
		dao.save(a);		
	}

	@Override
	@Transactional
	public entregas findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);			
	}

	@Override
	@Transactional
	public List<entregas> findAll() {
		return (List<entregas>)dao.findAll();
	}

}