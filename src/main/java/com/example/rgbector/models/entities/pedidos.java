package com.example.rgbector.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pedidos")
public class pedidos implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_pedido")
	private Long idPedido;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="web_inspiracion")
	private String webInspiracion;

	@Column(name="nombre_proyecto")
	private String nombreProyecto;
	
	@Column(name="donde_usara")
	private String dondeUsara;
	
	@Column(name="plazo")
	private String plazo;
	
	@Column(name="presupuesto")
	private Float presupuesto;
	
	@Column(name="algo_mas")
	private String algoMas;
	
	@Column(name="estado")
	private Boolean estado;
	
	@Column(name="fecha_pedido")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar fechaPedido;

	public pedidos() {
		super();
	}
	
	public pedidos(Long id) {
		super();
		this.idPedido = id;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getWebInspiracion() {
		return webInspiracion;
	}

	public void setWebInspiracion(String webInspiracion) {
		this.webInspiracion = webInspiracion;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getDondeUsara() {
		return dondeUsara;
	}

	public void setDondeUsara(String dondeUsara) {
		this.dondeUsara = dondeUsara;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public Float getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Float presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getAlgoMas() {
		return algoMas;
	}

	public void setAlgoMas(String algoMas) {
		this.algoMas = algoMas;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Calendar getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Calendar fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	/* pedidos Uno a Varios con propuestas */
	
	@OneToMany(mappedBy="pedido", fetch=FetchType.LAZY)
	private List<propuestas> propuestas;
	
	/* pedidos Varios a Uno con usuarios */

	@JoinColumn(name="fk_usuario", referencedColumnName="pk_usuario")
	@ManyToOne
	private Usuario usuario;
	
	/* pedidos Varios a Uno con tipoDisenio */

	@JoinColumn(name="fk_tipo_disenio", referencedColumnName="pk_tipo_disenio")
	@ManyToOne
	private tipoDisenio tipoDisenio;
	
	/* pedidos Uno a Varios con redes */
	
	@OneToMany(mappedBy="pedido", fetch=FetchType.LAZY)
	private List<redes> redes;
	
	/* pedidos Uno a Varios con urlsinspiracino */
	
	@OneToMany(mappedBy="pedido", fetch=FetchType.LAZY)
	private List<urlsInspiracion> urlsInspiracion;
	
	
	public String fecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fechaPedido.getTime());
	}
}
