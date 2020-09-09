package com.example.rgbector.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tipos_usuarios")
public class tipoUsuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_tipo_usuario")
	private Long idTipoUsuario;
	
	@Column(name="nombre")
	@NotEmpty
	private String nombre;

	public tipoUsuario() {
		super();
	}
	
	public tipoUsuario(Long id) {
		super();
		this.idTipoUsuario=id;
	}
	
	public Long getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(Long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/* tipoUsuario Uno a Varios con usuario */
	
	@OneToMany(mappedBy="tipoUsuario", fetch=FetchType.LAZY)
	private List<Usuario> usuarios;
	
	public String toString() {
		return this.getNombre();
	}
	
}
