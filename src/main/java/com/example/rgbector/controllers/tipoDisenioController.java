package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.tipoDisenio;
import com.example.rgbector.models.services.ITipoDisenioService;

@Controller
@RequestMapping(value = "/tipoDisenio")
public class tipoDisenioController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /tipoDisenio, Ejemplo: https://localhost:8080/tipoDisenio/create

	@Autowired
	private ITipoDisenioService srvTipoDisenio;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/tipoDisenio/create
	public String create(Model model) {
		tipoDisenio tipoDisenio = new tipoDisenio();
		model.addAttribute("title", "Registro de una nuevo Tipo de Diseño");
		model.addAttribute("tipoDisenio", tipoDisenio); // similar al ViewBag
		return "tipoDisenio/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		tipoDisenio tipoDisenio = srvTipoDisenio.findById(id);
		model.addAttribute("tipoDisenio", tipoDisenio);
		return "tipoDisenio/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		tipoDisenio tipoDisenio = srvTipoDisenio.findById(id);
		model.addAttribute("tipoDisenio", tipoDisenio);
		model.addAttribute("title", "Actualizando el registro " + tipoDisenio.getIdTipoDisenio());
		return "tipoDisenio/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvTipoDisenio.delete(id);
		return "redirect:/tipoDisenio/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<tipoDisenio> tipoDisenio = srvTipoDisenio.findAll();
		model.addAttribute("tipoDisenio", tipoDisenio);
		model.addAttribute("title", "Listado de Tipo de Diseño");
		return "tipoDisenio/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/tipoDisenio/save
	public String save(tipoDisenio tipoDisenio, Model model) {
		srvTipoDisenio.save(tipoDisenio);
		return "redirect:/tipoDisenio/list";
	}
}
