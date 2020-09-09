package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.entregas;

public interface IEntregasService {

	public void save (entregas a);
	public entregas findById(Long id);
	public void delete(Long id);
	public List<entregas> findAll();
}
