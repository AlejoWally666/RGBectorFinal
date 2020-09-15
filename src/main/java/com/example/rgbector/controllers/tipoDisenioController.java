package com.example.rgbector.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.rgbector.models.entities.Usuario;
import com.example.rgbector.models.entities.etiquetasTipoDisenio;
import com.example.rgbector.models.entities.tipoDisenio;
import com.example.rgbector.models.services.IEtiquetasTipoDisenioService;
import com.example.rgbector.models.services.ITipoDisenioService;
import com.example.rgbector.models.services.UsuarioService;

@Controller
@RequestMapping(value = "/tipoDisenio")
public class tipoDisenioController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /tipoDisenio, Ejemplo: https://localhost:8080/tipoDisenio/create

	@Autowired
	private ITipoDisenioService srvTipoDisenio;
	
	@Autowired
	private UsuarioService srvUsuario;
	
	@Autowired
	private IEtiquetasTipoDisenioService srvEtiquetas;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/tipoDisenio/create
	public String create(Model model) {
		tipoDisenio tipoDisenio = new tipoDisenio();
		model.addAttribute("title", "Registro de un nuevo Tipo de Diseño");
		model.addAttribute("tipoDisenio", tipoDisenio); // similar al ViewBag
		return "tipoDisenio/Form"; // la ubicacion de la vista
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
		return "redirect:/tipoDisenio/add";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<tipoDisenio> tipoDisenio = srvTipoDisenio.findAll();
		model.addAttribute("tipoDisenio", tipoDisenio);
		model.addAttribute("title", "Listado de Tipos de Diseño");
		return "tipoDisenio/List";
	}
	
	@GetMapping(value="/add")//https://localhost:8080/integrante/add
	public String add(Model model) {
		tipoDisenio tipoDisenio = new tipoDisenio();
		model.addAttribute("tipoDisenio", tipoDisenio);	
		List<tipoDisenio> tipoDisenios = BuscarUsuario().getTipoDisenio();
		model.addAttribute("tipoDisenios",tipoDisenios);
		List<etiquetasTipoDisenio> etiquetas = srvEtiquetas.findAll();
		model.addAttribute("etiquetas", etiquetas);
		return "tipoDisenio/tipoDisenioAdd";
	}

	@PostMapping(value = "/save") // https://localhost:8080/tipoDisenio/save
	public String save(tipoDisenio tipoDisenio, Model model,  @RequestParam("photo") MultipartFile image) {
		tipoDisenio.setUsuario(BuscarUsuario());
		List<tipoDisenio> tipoDisenios = BuscarUsuario().getTipoDisenio();
		model.addAttribute("tipoDisenios",tipoDisenios);
		List<etiquetasTipoDisenio> etiquetas = srvEtiquetas.findAll();
		model.addAttribute("etiquetas", etiquetas);
		if (!image.isEmpty()) {				
			Path dir = Paths.get("src//main//resources//static//img//TipoDisenio");
			String rootPath = dir.toFile().getAbsolutePath();
			try {
				byte[] bytes = image.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + image.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				tipoDisenio.setImagen(image.getOriginalFilename());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		srvTipoDisenio.save(tipoDisenio);
		
		return "redirect:/tipoDisenio/add";
	}
	
	
	public Usuario BuscarUsuario() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String Name = userDetails.getUsername();
		Usuario usuario = this.srvUsuario.findByNombre(Name);
		return usuario;
	}
}
