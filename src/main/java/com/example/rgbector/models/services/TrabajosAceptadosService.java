package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.ITrabajosAceptados;
import com.example.rgbector.models.entities.trabajosAceptados;

@Service
public class TrabajosAceptadosService implements ITrabajosAceptadosService{

	@Autowired //Inyeccion de dependencia
	private ITrabajosAceptados dao;

	@Override
	@Transactional
	public void save(trabajosAceptados a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public trabajosAceptados findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional
	public List<trabajosAceptados> findAll() {
		return (List<trabajosAceptados>)dao.findAll();
	}
	
}