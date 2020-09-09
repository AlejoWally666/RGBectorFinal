package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.IPropuestas;
import com.example.rgbector.models.entities.propuestas;

@Service
public class PropuestasService implements IPropuestasService{
	
	@Autowired //Inyeccion de dependencia
	private IPropuestas dao;

	@Override
	@Transactional
	public void save(propuestas a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public propuestas findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional
	public List<propuestas> findAll() {
		return (List<propuestas>)dao.findAll();
	}

}