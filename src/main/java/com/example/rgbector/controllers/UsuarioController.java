package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.rgbector.models.entities.tipoUsuario;
import com.example.rgbector.models.dao.ITipoUsuario;
import com.example.rgbector.models.entities.Rol;
import com.example.rgbector.models.entities.Usuario;
import com.example.rgbector.models.services.UsuarioService;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private ITipoUsuario srvtipoUsuario;
	
	@GetMapping(value="/create")
	public String registro(Model model) {	
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", "Registro de nuevo usuario");	
		List<tipoUsuario> tipoUsuario = (List<com.example.rgbector.models.entities.tipoUsuario>) srvtipoUsuario.findAll();
		model.addAttribute("tipoUsuario",tipoUsuario);
		return "usuario/form";
	}
	
	@PostMapping(value="/save")
	public String save(@Validated Usuario usuario, BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{	
				model.addAttribute("title", "Registro de nuevo usuario");
				model.addAttribute("Usuario", usuario);
				List<tipoUsuario> tipoUsuario = (List<com.example.rgbector.models.entities.tipoUsuario>) srvtipoUsuario.findAll();
				model.addAttribute("tipoUsuario",tipoUsuario);
				return "usuario/form";
			}			
			String pass = usuario.getPassword();
			usuario.setPassword(encoder.encode(pass));			
			usuario.getRoles().add(new Rol("ROLE_USER"));
			usuario.setHabilitado(true);
			service.save(usuario);
			flash.addFlashAttribute("success", "El usuario fue agregado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El usuario no pudo ser agregado.");
		}
		return "redirect:/login";		
	} 
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Usuario usuario = service.findByidusuario(id);
		model.addAttribute("title", usuario.toString());
		model.addAttribute("usuario", usuario);	
		return "usuario/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Usuario usuario = service.findByidusuario(id);
		model.addAttribute("usuario", usuario);
		model.addAttribute("title", "Actualizando el registro de " + usuario);
		List<tipoUsuario> tipoUsuario = (List<com.example.rgbector.models.entities.tipoUsuario>) srvtipoUsuario.findAll();
		model.addAttribute("tipoUsuario",tipoUsuario);
		return "usuario/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		service.delete(id);
		return "redirect:/usuario/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Usuario> usuarios = service.findAll();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("title", "Listado de usuarios");
		return "usuario/list";
	}
	
	@GetMapping(value="/reporte")
	public String report(Model model) {
		List<Usuario> usuarios = service.findAll();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("title", "Reporte de usuarios");
		return "usuario/report";
	}

}