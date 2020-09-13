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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="etiquetas_tipos_disenios")
public class etiquetasTipoDisenio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_etiqueta_tipo_disenio")
	private Long idEtiquetaTD;
	
	@Column(name="nombre")
	private String nombre;

	public etiquetasTipoDisenio() {
		super();
	}
	
	public etiquetasTipoDisenio(Long id) {
		super();
		this.idEtiquetaTD=id;
	}

	public Long getIdEtiquetaTD() {
		return idEtiquetaTD;
	}

	public void setIdEtiquetaTD(Long idEtiquetaTD) {
		this.idEtiquetaTD = idEtiquetaTD;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="etiqueta", fetch=FetchType.LAZY)
	private List<tipoDisenio> tipoDisenio;

	public List<tipoDisenio> getTipoDisenio() {
		return tipoDisenio;
	}

	public void setTipoDisenio(List<tipoDisenio> tipoDisenio) {
		this.tipoDisenio = tipoDisenio;
	}
	
}
