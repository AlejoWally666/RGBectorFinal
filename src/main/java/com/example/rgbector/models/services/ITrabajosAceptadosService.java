package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.trabajosAceptados;

public interface ITrabajosAceptadosService {

	public void save(trabajosAceptados a);
	public trabajosAceptados findById(Long id);
	public void delete(Long id);
	public List<trabajosAceptados> findAll();
}
