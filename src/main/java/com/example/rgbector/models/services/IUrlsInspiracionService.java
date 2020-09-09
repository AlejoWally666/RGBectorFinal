package com.example.rgbector.models.services;

import java.util.List;

import com.example.rgbector.models.entities.urlsInspiracion;

public interface IUrlsInspiracionService {

	public void save(urlsInspiracion a);
	public urlsInspiracion findById(Long id);
	public void delete(Long id);
	public List<urlsInspiracion> findAll();
}
