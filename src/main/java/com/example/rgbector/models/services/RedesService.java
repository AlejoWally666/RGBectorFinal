package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.IRedes;
import com.example.rgbector.models.entities.redes;

@Service
public class RedesService implements IRedesService{

	@Autowired //Inyeccion de dependencia
	private IRedes dao;

	@Override
	@Transactional
	public void save(redes a) {
		dao.save(a);	
	}

	@Override
	@Transactional
	public redes findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional
	public List<redes> findAll() {
		return (List<redes>)dao.findAll();
	}
	
}