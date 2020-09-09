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
@Table(name="etiquetas_tipos_disenios")
public class etiquetasTipoDisenio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_etiqueta_tipo_disenio")
	private Long idEtiquetaTD;

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
	
	/* etiquetasTipoDisenio Varios a Uno con usuarios */

	@JoinColumn(name="fk_usuario", referencedColumnName="pk_usuario")
	@ManyToOne
	private Usuario usuario;
	
	/* etiquetasTipoDisenio Varios a Uno con tipoDisenio */

	@JoinColumn(name="fk_tipo_disenio", referencedColumnName="pk_tipo_disenio")
	@ManyToOne
	private tipoDisenio tipoDisenio;
	
}
