package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.tipoUsuario;
import com.example.rgbector.models.services.ITipoUsuarioService;

@Controller
@RequestMapping(value = "/tipoUsuario")
public class tipoUsuarioController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /tipoUsuario, Ejemplo: https://localhost:8080/tipoUsuario/create

	@Autowired
	private ITipoUsuarioService srvTipoUsuario;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<tipoUsuario> tipoUsuario = srvTipoUsuario.findAll();
		model.addAttribute("tipoUsuario", tipoUsuario);
		model.addAttribute("title", "Listado de Tipos de Usuario");
		return "tipoUsuario/list";
	}
}
