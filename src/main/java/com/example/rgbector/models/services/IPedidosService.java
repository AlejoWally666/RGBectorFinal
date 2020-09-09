package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.pedidos;

public interface IPedidosService {

	public void save (pedidos a);
	public pedidos findById(Long id);
	public void delete(Long id);
	public List<pedidos> findAll();
}
