package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.ITipoDisenio;
import com.example.rgbector.models.entities.tipoDisenio;

@Service
public class TipoDisenioService implements ITipoDisenioService{

	@Autowired //Inyeccion de dependencia
	private ITipoDisenio dao;

	@Override
	@Transactional
	public void save(tipoDisenio a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public tipoDisenio findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional
	public List<tipoDisenio> findAll() {
		return (List<tipoDisenio>)dao.findAll();
	}
	
}