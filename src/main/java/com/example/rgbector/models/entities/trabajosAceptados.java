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
@Table(name="trabajos_aceptados")
public class trabajosAceptados implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_trabajo")
	private Long idTrabajo;
	
	@Column(name="estado")
	private Boolean estado;
	
	@Column(name="fecha_aceptado")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar fechaAceptado;

	public trabajosAceptados() {
		super();
	}
	
	public trabajosAceptados(Long id) {
		super();
		this.idTrabajo=id;
	}

	public Long getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(Long idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Calendar getFechaAceptado() {
		return fechaAceptado;
	}

	public void setFechaAceptado(Calendar fechaAceptado) {
		this.fechaAceptado = fechaAceptado;
	}
	
	/* trabajosAceptados Uno a varios con entregas */
	
	@OneToMany(mappedBy="trabajoAceptado", fetch=FetchType.LAZY)
	private List<entregas> entrega;
	
	/* trabajosAceptados Uno a Varios con pagos */
	
	@OneToMany(mappedBy="trabajoAceptado", fetch=FetchType.LAZY)
	private List<pagos> pago;
	
	/* trabajosAceptados Varios a Uno con propuestas */

	@JoinColumn(name="fk_propuesta", referencedColumnName="pk_propuesta")
	@ManyToOne
	private propuestas propuesta;
	
	public String fecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
		return sdf.format(fechaAceptado.getTime());
	}
}
