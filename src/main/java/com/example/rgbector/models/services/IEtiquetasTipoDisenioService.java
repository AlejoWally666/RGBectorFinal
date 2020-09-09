package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.etiquetasTipoDisenio;

public interface IEtiquetasTipoDisenioService {

	public void save (etiquetasTipoDisenio a);
	public etiquetasTipoDisenio findById(Long id);
	public void delete(Long id);
	public List<etiquetasTipoDisenio> findAll();
}
