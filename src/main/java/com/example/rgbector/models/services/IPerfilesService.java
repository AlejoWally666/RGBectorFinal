package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.perfiles;

public interface IPerfilesService {

	public void save (perfiles a);
	public perfiles findById(Long id);
	public void delete(Long id);
	public List<perfiles> findAll();
}
