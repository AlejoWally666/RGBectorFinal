package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.perfiles;
import com.example.rgbector.models.services.IPerfilesService;

@Controller
@RequestMapping(value = "/perfiles")
public class perfilesController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /perfiles, Ejemplo: https://localhost:8080/perfiles/create

	@Autowired
	private IPerfilesService srvPerfiles;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/perfiles/create
	public String create(Model model) {
		perfiles perfiles = new perfiles();
		model.addAttribute("title", "Registro de un nuevo Perfil");
		model.addAttribute("perfiles", perfiles); // similar al ViewBag
		return "perfiles/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		perfiles perfiles = srvPerfiles.findById(id);
		model.addAttribute("perfiles", perfiles);
		return "perfiles/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		perfiles perfiles = srvPerfiles.findById(id);
		model.addAttribute("perfiles", perfiles);
		model.addAttribute("title", "Actualizando el registro " + perfiles.getIdperfil());
		return "perfiles/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvPerfiles.delete(id);
		return "redirect:/perfiles/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<perfiles> perfiles = srvPerfiles.findAll();
		model.addAttribute("perfiles", perfiles);
		model.addAttribute("title", "Listado de perfiles");
		return "perfiles/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/perfiles/save
	public String save(perfiles perfiles, Model model) {
		srvPerfiles.save(perfiles);
		return "redirect:/perfiles/list";
	}
}
