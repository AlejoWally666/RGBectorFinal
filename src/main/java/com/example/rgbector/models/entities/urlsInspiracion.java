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
@Table(name="url_inspiracion")
public class urlsInspiracion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_url_inspiracion")
	private Long idUrlInspiracion;
	
	@Column(name="url_imagen")
	private String urlImagen;

	public urlsInspiracion() {
		super();
	}
	
	public urlsInspiracion(Long idUrlInspiracion) {
		super();
		this.idUrlInspiracion = idUrlInspiracion;
	}

	public Long getIdUrlInspiracion() {
		return idUrlInspiracion;
	}

	public void setIdUrlInspiracion(Long idUrlInspiracion) {
		this.idUrlInspiracion = idUrlInspiracion;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	
	/* urlsInspiracion Varios a Uno con pedidos */

	@JoinColumn(name="fk_pedido", referencedColumnName="pk_pedido")
	@ManyToOne
	private pedidos pedido;
}
