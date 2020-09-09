package com.example.rgbector.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="imagenes_propuesta")
public class imagenesPropuesta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_imagen")
	private Long idImagen;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="url_imgen")
	private String urlImagen;
	
	public imagenesPropuesta() {
		super();
	}

	public imagenesPropuesta(Long idImagen) {
		super();
		this.idImagen = idImagen;
	}

	public Long getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Long idImagen) {
		this.idImagen = idImagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	
	/* imagenesPropuesta Varios a Uno con propuestas */

	@JoinColumn(name="fk_propuesta", referencedColumnName="pk_propuesta")
	@ManyToOne
	private propuestas propuesta;
	
	
}
