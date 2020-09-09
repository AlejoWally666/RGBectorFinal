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
@Table(name="redes")
public class redes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_red")
	private Long idred;
	
	@Column(name="url_red")
	private String urlRed;

	public redes() {
		super();
	}
	
	public redes(Long id) {
		super();
		this.idred=id;
	}

	public Long getIdred() {
		return idred;
	}

	public void setIdred(Long idred) {
		this.idred = idred;
	}

	public String getUrlRed() {
		return urlRed;
	}

	public void setUrlRed(String urlRed) {
		this.urlRed = urlRed;
	}
	
	/* redes Varios a Uno con pedidos */

	@JoinColumn(name="fk_pedido", referencedColumnName="pk_pedido")
	@ManyToOne
	private pedidos pedido;
}
