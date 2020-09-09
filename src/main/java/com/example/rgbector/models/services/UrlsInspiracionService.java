package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.IUrlsInspiracion;
import com.example.rgbector.models.entities.urlsInspiracion;

@Service
public class UrlsInspiracionService implements IUrlsInspiracionService{

	@Autowired //Inyeccion de dependencia
	private IUrlsInspiracion dao;

	@Override
	@Transactional
	public void save(urlsInspiracion a) {
		dao.save(a);	
	}

	@Override
	@Transactional
	public urlsInspiracion findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional
	public List<urlsInspiracion> findAll() {
		return (List<urlsInspiracion>)dao.findAll();
	}
	
}