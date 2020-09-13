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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tipos_disenio")
public class tipoDisenio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_tipo_disenio")
	private Long idTipoDisenio;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="imagen")
	private String imagen;
	
	
	@Column(name="encabezado")
	private String encabezado;
	
	@Column(name="precio_aconsejado")
	private String precioAconsejado;
	
	/**** TRANSIENT INICIO ***/
	
	@Transient
	private int usuarioid;
	
	@Transient
	private int etiquetasid;
	
	public int getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(int usuarioid) {
		this.usuarioid = usuarioid;
	}

	public int getEtiquetasid() {
		return etiquetasid;
	}

	public void setEtiquetasid(int etiquetasid) {
		this.etiquetasid = etiquetasid;
	}

	/**** TRANSIENT FIN***/
	
	@JoinColumn(name="fk_usuario", referencedColumnName="pk_usuario")
	@ManyToOne
	private Usuario usuario;
	
	@JoinColumn(name="fk_etiqueta", referencedColumnName="pk_etiqueta_tipo_disenio")
	@ManyToOne
	private etiquetasTipoDisenio etiqueta;
	
	public List<pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<pedidos> pedidos) {
		this.pedidos = pedidos;
	}

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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public etiquetasTipoDisenio getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(etiquetasTipoDisenio etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	
	/*tipoDisenio Uno a Varios con pedidos */
	
	@OneToMany(mappedBy="tipoDisenio", fetch=FetchType.LAZY)
	private List<pedidos> pedidos;
	
}
