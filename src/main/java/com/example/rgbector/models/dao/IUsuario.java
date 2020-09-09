package com.example.rgbector.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.rgbector.models.entities.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer> {
	
	public Usuario findByNombre(String nombre);	
	
	public Usuario findByidusuario(Integer id);	
	
	public Usuario deleteByidusuario(Integer id);	
		
}