package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.urlsInspiracion;
import com.example.rgbector.models.services.IUrlsInspiracionService;

@Controller
@RequestMapping(value = "/urlsInspiracion")
public class urlsInspiracionController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /urlsInspiracion, Ejemplo:
	// https://localhost:8080/urlsInspiracion/create

	@Autowired
	private IUrlsInspiracionService srvUrlsInspiracion;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/urlsInspiracion/create
	public String create(Model model) {
		urlsInspiracion urlsInspiracion = new urlsInspiracion();
		model.addAttribute("title", "Registro de una nueva URL Inspiracion");
		model.addAttribute("urlsInspiracion", urlsInspiracion); // similar al ViewBag
		return "urlsInspiracion/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		urlsInspiracion urlsInspiracion = srvUrlsInspiracion.findById(id);
		model.addAttribute("urlsInspiracion", urlsInspiracion);
		return "urlsInspiracion/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		urlsInspiracion urlsInspiracion = srvUrlsInspiracion.findById(id);
		model.addAttribute("urlsInspiracion", urlsInspiracion);
		model.addAttribute("title", "Actualizando el registro " + urlsInspiracion.getIdUrlInspiracion());
		return "urlsInspiracion/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvUrlsInspiracion.delete(id);
		return "redirect:/urlsInspiracion/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<urlsInspiracion> urlsInspiracion = srvUrlsInspiracion.findAll();
		model.addAttribute("urlsInspiracion", urlsInspiracion);
		model.addAttribute("title", "Listado de urlsInspiracion");
		return "urlsInspiracion/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/urlsInspiracion/save
	public String save(urlsInspiracion urlsInspiracion, Model model) {
		srvUrlsInspiracion.save(urlsInspiracion);
		return "redirect:/urlsInspiracion/list";
	}
}
