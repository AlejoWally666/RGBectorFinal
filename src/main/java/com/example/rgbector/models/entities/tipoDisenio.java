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

@Entity
@Table(name="tipos_disenio")
public class tipoDisenio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_tipo_disenio")
	private Long idTipoDisenio;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="img_paso_1")
	private String imgPaso1;
	
	@Column(name="img_paso_2")
	private String imgPaso2;
	
	@Column(name="img_paso_3")
	private String imgPaso3;
	
	@Column(name="encabezado")
	private String encabezado;
	
	@Column(name="precio_aconsejado")
	private String precioAconsejado;

	public tipoDisenio() {
		super();
	}

	public tipoDisenio(Long id) {
		super();
		this.idTipoDisenio = id;
	}

	public Long getIdTipoDisenio() {
		return idTipoDisenio;
	}

	public void setIdTipoDisenio(Long idTipoDisenio) {
		this.idTipoDisenio = idTipoDisenio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImgPaso1() {
		return imgPaso1;
	}

	public void setImgPaso1(String imgPaso1) {
		this.imgPaso1 = imgPaso1;
	}

	public String getImgPaso2() {
		return imgPaso2;
	}

	public void setImgPaso2(String imgPaso2) {
		this.imgPaso2 = imgPaso2;
	}

	public String getImgPaso3() {
		return imgPaso3;
	}

	public void setImgPaso3(String imgPaso3) {
		this.imgPaso3 = imgPaso3;
	}

	public String getEncabezado() {
		return encabezado;
	}

	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}

	public String getPrecioAconsejado() {
		return precioAconsejado;
	}

	public void setPrecioAconsejado(String precioAconsejado) {
		this.precioAconsejado = precioAconsejado;
	}
	
	/*tipoDisenio Uno a Varios con pedidos */
	
	@OneToMany(mappedBy="tipoDisenio", fetch=FetchType.LAZY)
	private List<pedidos> pedidos;
	
	/*tipoDisenio Uno a Varios con pedidos */
	
	@OneToMany(mappedBy="tipoDisenio", fetch=FetchType.LAZY)
	private List<etiquetasTipoDisenio> etiquetasTipoDisenio;
}
