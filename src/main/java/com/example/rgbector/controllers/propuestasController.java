package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.propuestas;
import com.example.rgbector.models.services.IPropuestasService;

@Controller
@RequestMapping(value = "/propuestas")
public class propuestasController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /propuestas, Ejemplo: https://localhost:8080/propuestas/create

	@Autowired
	private IPropuestasService srvPropuestas;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/propuestas/create
	public String create(Model model) {
		propuestas propuestas = new propuestas();
		model.addAttribute("title", "Registro de una nueva Propuesta");
		model.addAttribute("propuestas", propuestas); // similar al ViewBag
		return "propuestas/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		propuestas propuestas = srvPropuestas.findById(id);
		model.addAttribute("propuestas", propuestas);
		return "propuestas/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		propuestas propuestas = srvPropuestas.findById(id);
		model.addAttribute("propuestas", propuestas);
		model.addAttribute("title", "Actualizando el registro de " + propuestas.toString());
		return "propuestas/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvPropuestas.delete(id);
		return "redirect:/propuestas/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<propuestas> propuestas = srvPropuestas.findAll();
		model.addAttribute("propuestas", propuestas);
		model.addAttribute("title", "Listado de propuestas");
		return "propuestas/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/propuestas/save
	public String save(propuestas propuestas, Model model) {
		srvPropuestas.save(propuestas);
		return "redirect:/propuestas/list";
	}
}
