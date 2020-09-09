package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.entregas;
import com.example.rgbector.models.services.IEntregasService;

@Controller
@RequestMapping(value = "/entregas")
public class entregasController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /entregas, Ejemplo: https://localhost:8080/entregas/create

	@Autowired
	private IEntregasService srvEntregas;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/entregas/create
	public String create(Model model) {
		entregas entregas = new entregas();
		model.addAttribute("title", "Registro de una nueva Entrega");
		model.addAttribute("entregas", entregas); // similar al ViewBag
		return "entregas/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		entregas entregas = srvEntregas.findById(id);
		model.addAttribute("entregas", entregas);
		return "entregas/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		entregas entregas = srvEntregas.findById(id);
		model.addAttribute("entregas", entregas);
		model.addAttribute("title", "Actualizando el registro " + entregas.getIdEntrega());
		return "entregas/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvEntregas.delete(id);
		return "redirect:/entregas/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<entregas> entregas = srvEntregas.findAll();
		model.addAttribute("entregas", entregas);
		model.addAttribute("title", "Listado de entregas");
		return "entregas/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/entregas/save
	public String save(entregas entregas, Model model) {
		srvEntregas.save(entregas);
		return "redirect:/entregas/list";
	}
}
