package com.example.rgbector.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="perfiles")
public class perfiles implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_perfil")
	private Long idperfil;
	
	@Column(name="url_foto_perfil")
	private String urlFotoPerfil;
	
	@Column(name="url_foto_portada")
	private String urlFotoPortada;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fecha_registro")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar fechaRegistro;

	public perfiles() {
		super();
	}
	
	public perfiles(Long id) {
		super();
		this.idperfil = id;
	}

	public Long getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(Long idperfil) {
		this.idperfil = idperfil;
	}

	public String getUrlFotoPerfil() {
		return urlFotoPerfil;
	}

	public void setUrlFotoPerfil(String urlFotoPerfil) {
		this.urlFotoPerfil = urlFotoPerfil;
	}

	public String getUrlFotoPortada() {
		return urlFotoPortada;
	}

	public void setUrlFotoPortada(String urlFotoPortada) {
		this.urlFotoPortada = urlFotoPortada;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Calendar getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Calendar fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	/* perfiles Varios a Uno con usuarios */

	@JoinColumn(name="fk_usuario", referencedColumnName="pk_usuario")
	@ManyToOne
	private Usuario usuario;
	
	public String fechaRegistro() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fechaRegistro.getTime());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
