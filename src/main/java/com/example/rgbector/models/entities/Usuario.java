package com.example.rgbector.models.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuario")
public class Usuario extends usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "pk_usuario")
	private Integer idusuario;

	@Column(name="nombre", unique=true)
	@NotEmpty
	@Size(min=4)
	private String nombre;

	@Column(name="password")
	@NotEmpty
	@Size(min=8)
	private String password;
	
	@Column(name="habilitado")
	private boolean habilitado;

	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL )
	@JoinColumn(name="fk_usuario")
	private List<Rol> roles;

	public List<Rol> getRoles() {
		if(roles == null)
			roles = new ArrayList<>();
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Usuario() {
		super();
	}

	public Usuario(int id) {
		super();
		this.setIdusuario(id);
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(boolean h) {
		this.habilitado = h;
	} 

    /* usuarios Uno a Varios con propuestas */
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<propuestas> propuestas;
	
	/* usuarios Uno a Uno con perfiles */
	
	@OneToOne(mappedBy="usuario", fetch=FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
	private perfiles perfiles;
	
	/* usuarios Uno a Varios con TipoDisenio */
	@JsonIgnore
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<tipoDisenio> tipoDisenio;
	
	/* usuarios Uno a Varios con pedidos */
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<pedidos> pedidos;
	
	/* usuarios Varios a Uno con tipoUsuario */

	@JoinColumn(name="fk_tipo_usuario", referencedColumnName="pk_tipo_usuario")
	@ManyToOne
	private tipoUsuario tipoUsuario;

	public List<propuestas> getPropuestas() {
		return propuestas;
	}

	public void setPropuestas(List<propuestas> propuestas) {
		this.propuestas = propuestas;
	}

	public perfiles getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(perfiles perfiles) {
		this.perfiles = perfiles;
	}

	public List<pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	public tipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(tipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<tipoDisenio> getTipoDisenio() {
		return tipoDisenio;
	}

	public void setTipoDisenio(List<tipoDisenio> tipoDisenio) {
		this.tipoDisenio = tipoDisenio;
	}






}