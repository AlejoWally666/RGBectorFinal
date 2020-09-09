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
@Table(name="propuestas")
public class propuestas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_propuesta")
	private Long idPropuesta;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="costo")
	private Float costo;
	
	@Column(name="fecha_propuesta")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar fechaPropuesta;
	
	@Column(name="estado")
	private Boolean estado;

	public propuestas() {
		super();
	}
	
	public propuestas(Long id) {
		super();
		this.idPropuesta = id;
	}

	public Long getIdPropuesta() {
		return idPropuesta;
	}

	public void setIdPropuesta(Long idPropuesta) {
		this.idPropuesta = idPropuesta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Calendar getFechaPropuesta() {
		return fechaPropuesta;
	}

	public void setFechaPropuesta(Calendar fechaPropuesta) {
		this.fechaPropuesta = fechaPropuesta;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	/* propuestas Uno a Varios con trabajosAceptados */
	
	@OneToMany(mappedBy="propuesta", fetch=FetchType.LAZY)
	private List<trabajosAceptados> trabajosAceptados;

	/* propuestas Uno a Varios con imagenesPropuestas */
	
	@OneToMany(mappedBy="propuesta", fetch=FetchType.LAZY)
	private List<imagenesPropuesta> imagenesPropuesta;
	
	/* propuestas Varios a Uno con pedidos */

	@JoinColumn(name="fk_pedido", referencedColumnName="pk_pedido")
	@ManyToOne
	private pedidos pedido;
	
	/* propuestas Varios a Uno con usuarios */

	@JoinColumn(name="fk_diseniador", referencedColumnName="pk_usuario")
	@ManyToOne
	private Usuario usuario;
	
	public String fecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fechaPropuesta.getTime());
	}
}
