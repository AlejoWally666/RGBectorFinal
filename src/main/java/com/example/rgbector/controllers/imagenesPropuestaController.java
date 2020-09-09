package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.imagenesPropuesta;
import com.example.rgbector.models.services.IImagenesPropuestaService;

@Controller
@RequestMapping(value = "/imagenesPropuesta")
public class imagenesPropuestaController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /imagenesPropuesta, Ejemplo:
	// https://localhost:8080/imagenesPropuesta/create

	@Autowired
	private IImagenesPropuestaService srvImagenesPropuesta;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/imagenesPropuesta/create
	public String create(Model model) {
		imagenesPropuesta imagenesPropuesta = new imagenesPropuesta();
		model.addAttribute("title", "Registro de una nueva Imagen");
		model.addAttribute("imagenesPropuesta", imagenesPropuesta); // similar al ViewBag
		return "imagenesPropuesta/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		imagenesPropuesta imagenesPropuesta = srvImagenesPropuesta.findById(id);
		model.addAttribute("imagenesPropuesta", imagenesPropuesta);
		return "imagenesPropuesta/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		imagenesPropuesta imagenesPropuesta = srvImagenesPropuesta.findById(id);
		model.addAttribute("imagenesPropuesta", imagenesPropuesta);
		model.addAttribute("title", "Actualizando el registro " + imagenesPropuesta.getIdImagen());
		return "imagenesPropuesta/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvImagenesPropuesta.delete(id);
		return "redirect:/imagenesPropuesta/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<imagenesPropuesta> imagenesPropuesta = srvImagenesPropuesta.findAll();
		model.addAttribute("imagenesPropuesta", imagenesPropuesta);
		model.addAttribute("title", "Listado de imagenesPropuesta");
		return "imagenesPropuesta/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/imagenesPropuesta/save
	public String save(imagenesPropuesta imagenesPropuesta, Model model) {
		srvImagenesPropuesta.save(imagenesPropuesta);
		return "redirect:/imagenesPropuesta/list";
	}
}
