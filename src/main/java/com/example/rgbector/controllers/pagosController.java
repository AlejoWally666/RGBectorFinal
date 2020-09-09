package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.pagos;
import com.example.rgbector.models.services.IPagosService;

@Controller
@RequestMapping(value = "/pagos")
public class pagosController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /pagos, Ejemplo: https://localhost:8080/pagos/create

	@Autowired
	private IPagosService srvPagos;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/pagos/create
	public String create(Model model) {
		pagos pagos = new pagos();
		model.addAttribute("title", "Registro de un pagos");
		model.addAttribute("pagos", pagos); // similar al ViewBag
		return "pagos/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		pagos pagos = srvPagos.findById(id);
		model.addAttribute("pagos", pagos);
		return "pagos/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		pagos pagos = srvPagos.findById(id);
		model.addAttribute("pagos", pagos);
		model.addAttribute("title", "Actualizando el registro de " + pagos.toString());
		return "pagos/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvPagos.delete(id);
		return "redirect:/pagos/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<pagos> pagos = srvPagos.findAll();
		model.addAttribute("pagos", pagos);
		model.addAttribute("title", "Listado de pagos");
		return "pagos/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/pagos/save
	public String save(pagos pagos, Model model) {
		srvPagos.save(pagos);
		return "redirect:/pagos/list";
	}
}
