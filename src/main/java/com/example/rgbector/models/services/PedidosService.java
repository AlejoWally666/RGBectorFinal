package com.example.rgbector.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rgbector.models.dao.IPedidos;
import com.example.rgbector.models.entities.pedidos;

@Service
public class PedidosService implements IPedidosService{

	@Autowired //Inyeccion de dependencia
	private IPedidos dao;

	@Override
	@Transactional
	public void save(pedidos a) {
		dao.save(a);
	}

	@Override
	@Transactional
	public pedidos findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional
	public List<pedidos> findAll() {
		return (List<pedidos>)dao.findAll();
	}

}