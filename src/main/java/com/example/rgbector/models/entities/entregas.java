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
@Table(name="entregas")
public class entregas implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_entrega")
	private Long idEntrega;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar fecha;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="url_imagen")
	private String urlImagen;
	
	@Column(name="url_archivo")
	private String urlArchivo;
	
	@Column(name="estado")
	private Boolean estado;

	public entregas() {
		super();
	}

	public entregas(Long id) {
		super();
		this.idEntrega = id;
	}

	public Long getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(Long idEntrega) {
		this.idEntrega = idEntrega;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
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

	public String getUrlArchivo() {
		return urlArchivo;
	}

	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	/* entregas Varios a uno con trabajosAceptados */

	@JoinColumn(name="fk_trabajo_aceptado", referencedColumnName="pk_trabajo")
	@ManyToOne
	private trabajosAceptados trabajoAceptado;
	
	public String fecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fecha.getTime());
	}
	
}
