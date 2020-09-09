package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.IEtiquetasTipoDisenio;
import com.example.rgbector.models.entities.etiquetasTipoDisenio;

@Service
public class EtiquetasTipoDisenioService implements IEtiquetasTipoDisenioService{

	@Autowired //Inyeccion de dependencia
	private IEtiquetasTipoDisenio dao;
	
	@Override
	@Transactional
	public void save(etiquetasTipoDisenio a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public etiquetasTipoDisenio findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional
	public List<etiquetasTipoDisenio> findAll() {
		return (List<etiquetasTipoDisenio>)dao.findAll();
	}
	
}