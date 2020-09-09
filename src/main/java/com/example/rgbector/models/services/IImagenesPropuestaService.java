package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.imagenesPropuesta;

public interface IImagenesPropuestaService {

	public void save (imagenesPropuesta a);
	public imagenesPropuesta findById(Long id);
	public void delete(Long id);
	public List<imagenesPropuesta> findAll();
}
