package com.example.rgbector.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rgbector.models.dao.ITipoUsuario;
import com.example.rgbector.models.entities.tipoUsuario;

@Service
public class TipoUsuarioService implements ITipoUsuarioService{
	
	@Autowired //Inyeccion de dependencia
	private ITipoUsuario dao;

	@Override
	@Transactional
	public List<tipoUsuario> findAll() {
		return (List<tipoUsuario>)dao.findAll();
	}

}