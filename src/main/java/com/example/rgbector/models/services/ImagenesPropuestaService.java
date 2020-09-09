package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.IImagenesPropuesta;
import com.example.rgbector.models.entities.imagenesPropuesta;

@Service
public class ImagenesPropuestaService implements IImagenesPropuestaService{

	@Autowired //Inyeccion de dependencia
	private IImagenesPropuesta dao;

	@Override
	@Transactional
	public void save(imagenesPropuesta a) {
		dao.save(a);	
	}

	@Override
	@Transactional
	public imagenesPropuesta findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional
	public List<imagenesPropuesta> findAll() {
		return (List<imagenesPropuesta>)dao.findAll();
	}
	
}