package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.tipoDisenio;

public interface ITipoDisenioService {

	public void save(tipoDisenio a);
	public tipoDisenio findById(Long id);
	public void delete(Long id);
	public List<tipoDisenio> findAll();
}
