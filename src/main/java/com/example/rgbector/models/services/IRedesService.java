package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.redes;

public interface IRedesService {

	public void save (redes a);
	public redes findById(Long id);
	public void delete(Long id);
	public List<redes> findAll();
}
