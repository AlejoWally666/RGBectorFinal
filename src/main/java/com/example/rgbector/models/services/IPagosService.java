package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.pagos;

public interface IPagosService {

	public void save (pagos a);
	public pagos findById(Long id);
	public void delete(Long id);
	public List<pagos> findAll();
}
