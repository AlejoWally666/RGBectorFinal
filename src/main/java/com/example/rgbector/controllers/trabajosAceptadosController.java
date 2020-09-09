package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.trabajosAceptados;
import com.example.rgbector.models.services.ITrabajosAceptadosService;

@Controller
@RequestMapping(value = "/trabajosAceptados")
public class trabajosAceptadosController {
	// Todas las peticiones que gestiona este controlador
	// empiezan por /trabajosAceptados, Ejemplo:
	// https://localhost:8080/trabajosAceptados/create

	@Autowired
	private ITrabajosAceptadosService srvTrabajosAceptados;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/trabajosAceptados/create
	public String create(Model model) {
		trabajosAceptados trabajosAceptados = new trabajosAceptados();
		model.addAttribute("title", "Registro de una nuevo Trabajo");
		model.addAttribute("trabajosAceptados", trabajosAceptados); // similar al ViewBag
		return "trabajosAceptados/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		trabajosAceptados trabajosAceptados = srvTrabajosAceptados.findById(id);
		model.addAttribute("trabajosAceptados", trabajosAceptados);
		return "trabajosAceptados/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		trabajosAceptados trabajosAceptados = srvTrabajosAceptados.findById(id);
		model.addAttribute("trabajosAceptados", trabajosAceptados);
		model.addAttribute("title", "Actualizando el registro " + trabajosAceptados.getIdTrabajo());
		return "trabajosAceptados/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvTrabajosAceptados.delete(id);
		return "redirect:/trabajosAceptados/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<trabajosAceptados> trabajosAceptados = srvTrabajosAceptados.findAll();
		model.addAttribute("trabajosAceptados", trabajosAceptados);
		model.addAttribute("title", "Listado de trabajosAceptados");
		return "trabajosAceptados/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/trabajosAceptados/save
	public String save(trabajosAceptados trabajosAceptados, Model model) {
		srvTrabajosAceptados.save(trabajosAceptados);
		return "redirect:/trabajosAceptados/list";
	}
}
