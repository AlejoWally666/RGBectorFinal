package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.propuestas;

public interface IPropuestasService {

	public void save (propuestas a);
	public propuestas findById(Long id);
	public void delete(Long id);
	public List<propuestas> findAll();
}
