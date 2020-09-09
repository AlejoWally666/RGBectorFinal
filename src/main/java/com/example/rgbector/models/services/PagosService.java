package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.IPagos;
import com.example.rgbector.models.entities.pagos;

@Service
public class PagosService implements IPagosService{

	@Autowired //Inyeccion de dependencia
	private IPagos dao;

	@Override
	@Transactional
	public void save(pagos a) {
		dao.save(a);	
	}

	@Override
	@Transactional
	public pagos findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional
	public List<pagos> findAll() {
		return (List<pagos>)dao.findAll();
	}
	
}