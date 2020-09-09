package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.etiquetasTipoDisenio;
import com.example.rgbector.models.services.IEtiquetasTipoDisenioService;

@Controller
@RequestMapping(value = "/etiquetasTipoDisenio")
public class etiquetasTipoDisenioController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /etiquetasTipoDisenio, Ejemplo:
	// https://localhost:8080/etiquetasTipoDisenio/create

	@Autowired
	private IEtiquetasTipoDisenioService srvEtiquetasTipoDisenio;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/etiquetasTipoDisenio/create
	public String create(Model model) {
		etiquetasTipoDisenio etiquetasTipoDisenio = new etiquetasTipoDisenio();
		model.addAttribute("title", "Registro de una nuev entrega");
		model.addAttribute("etiquetasTipoDisenio", etiquetasTipoDisenio); // similar al ViewBag
		return "etiquetasTipoDisenio/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		etiquetasTipoDisenio etiquetasTipoDisenio = srvEtiquetasTipoDisenio.findById(id);
		model.addAttribute("etiquetasTipoDisenio", etiquetasTipoDisenio);
		return "etiquetasTipoDisenio/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		etiquetasTipoDisenio etiquetasTipoDisenio = srvEtiquetasTipoDisenio.findById(id);
		model.addAttribute("etiquetasTipoDisenio", etiquetasTipoDisenio);
		model.addAttribute("title", "Actualizando el registro de " + etiquetasTipoDisenio.toString());
		return "etiquetasTipoDisenio/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvEtiquetasTipoDisenio.delete(id);
		return "redirect:/etiquetasTipoDisenio/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<etiquetasTipoDisenio> etiquetasTipoDisenio = srvEtiquetasTipoDisenio.findAll();
		model.addAttribute("etiquetasTipoDisenio", etiquetasTipoDisenio);
		model.addAttribute("title", "Listado de etiquetasTipoDisenio");
		return "etiquetasTipoDisenio/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/etiquetasTipoDisenio/save
	public String save(etiquetasTipoDisenio etiquetasTipoDisenio, Model model) {
		srvEtiquetasTipoDisenio.save(etiquetasTipoDisenio);
		return "redirect:/etiquetasTipoDisenio/list";
	}
}
