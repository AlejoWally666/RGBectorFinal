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
@Table(name="pagos")
public class pagos implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_pagos")
	private Long idPagos;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar fecha;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="imagen")
	private String imagen;
	
	@Column(name="valor")
	private Float valor;
	
	@Column(name="estado")
	private Boolean estado;

	public pagos() {
		super();
	}

	public pagos(Long id) {
		super();
		this.idPagos = id;
	}

	public Long getIdPagos() {
		return idPagos;
	}

	public void setIdPagos(Long idPagos) {
		this.idPagos = idPagos;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	/* pagos Varios a uno con trabajosAceptados */

	@JoinColumn(name="fk_trabajo_aceptado", referencedColumnName="pk_trabajo")
	@ManyToOne
	private trabajosAceptados trabajoAceptado;

	public trabajosAceptados getTrabajoAceptado() {
		return trabajoAceptado;
	}

	public void setTrabajoAceptado(trabajosAceptados trabajoAceptado) {
		this.trabajoAceptado = trabajoAceptado;
	}
	
	public String fecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fecha.getTime());
	}
	
}
