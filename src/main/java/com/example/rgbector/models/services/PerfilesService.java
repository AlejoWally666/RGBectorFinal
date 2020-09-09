package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.IPerfiles;
import com.example.rgbector.models.entities.perfiles;

@Service
public class PerfilesService implements IPerfilesService{

	@Autowired //Inyeccion de dependencia
	private IPerfiles dao;

	@Override
	@Transactional
	public void save(perfiles a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public perfiles findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional
	public List<perfiles> findAll() {
		return (List<perfiles>)dao.findAll();
	}
	
}