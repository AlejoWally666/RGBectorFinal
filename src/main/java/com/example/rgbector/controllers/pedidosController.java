package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.pedidos;
import com.example.rgbector.models.services.IPedidosService;

@Controller
@RequestMapping(value = "/pedidos")
public class pedidosController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /pedidos, Ejemplo: https://localhost:8080/pedidos/create

	@Autowired
	private IPedidosService srvPedidos;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/pedidos/create
	public String create(Model model) {
		pedidos pedidos = new pedidos();
		model.addAttribute("title", "Registro de una nueva entrega");
		model.addAttribute("pedidos", pedidos); // similar al ViewBag
		return "pedidos/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		pedidos pedidos = srvPedidos.findById(id);
		model.addAttribute("pedidos", pedidos);
		return "pedidos/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		pedidos pedidos = srvPedidos.findById(id);
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("title", "Actualizando el registro de " + pedidos.toString());
		return "pedidos/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvPedidos.delete(id);
		return "redirect:/pedidos/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<pedidos> pedidos = srvPedidos.findAll();
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("title", "Listado de pedidos");
		return "pedidos/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/pedidos/save
	public String save(pedidos pedidos, Model model) {
		srvPedidos.save(pedidos);
		return "redirect:/pedidos/list";
	}
}
