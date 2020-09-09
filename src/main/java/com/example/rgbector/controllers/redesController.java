package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.redes;
import com.example.rgbector.models.services.IRedesService;

@Controller
@RequestMapping(value = "/redes")
public class redesController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /redes, Ejemplo: https://localhost:8080/redes/create

	@Autowired
	private IRedesService srvRedes;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/redes/create
	public String create(Model model) {
		redes redes = new redes();
		model.addAttribute("title", "Registro de una nueva Red");
		model.addAttribute("redes", redes); // similar al ViewBag
		return "redes/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		redes redes = srvRedes.findById(id);
		model.addAttribute("redes", redes);
		return "redes/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		redes redes = srvRedes.findById(id);
		model.addAttribute("redes", redes);
		model.addAttribute("title", "Actualizando el registro " + redes.getIdred());
		return "redes/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvRedes.delete(id);
		return "redirect:/redes/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<redes> redes = srvRedes.findAll();
		model.addAttribute("redes", redes);
		model.addAttribute("title", "Listado de redes");
		return "redes/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/redes/save
	public String save(redes redes, Model model) {
		srvRedes.save(redes);
		return "redirect:/redes/list";
	}
}
