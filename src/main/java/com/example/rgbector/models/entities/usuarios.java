package com.example.rgbector.models.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class usuarios {
	
	@Column(name="nombres")
	@Size(min = 3, max = 60)
	private String nombres;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="telefono")
	@Pattern(regexp="(^$|[0-9]{10})",message="Telefono no valido")
	private String telefono;
	
	public usuarios() {
		super();
	}

	public usuarios(Long id) {
		super();
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombre) {
		this.nombres = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
