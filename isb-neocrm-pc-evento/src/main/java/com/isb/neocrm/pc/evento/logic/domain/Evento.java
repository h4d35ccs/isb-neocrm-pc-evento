package com.isb.neocrm.pc.evento.logic.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Clase de dominio correspondiente al Evento Author: schamorro Date: 05/09/14.
 */
@XmlRootElement(name = "item")
public class Evento implements Serializable {
	private static final long serialVersionUID = 8039686696076370531L;

	@XmlElement(name = "idempr")
	private String idempr;
	@JsonProperty("tipo")
	@XmlElement(name = "tipo")
	private String tipopers;
	@XmlElement(name = "codigo")
	@JsonProperty("codigo")
	private Integer codpers;
	@XmlElement(name = "codigoEvento")
	@JsonProperty("codigoEvento")
	private String codevento;
	@XmlElement(name = "titulo")
	@JsonProperty("titulo")
	private String title;
	@XmlElement(name = "fechaini")
	private String fechaini;
	@XmlElement(name = "fechasys")
	private String fechaSys;
	@XmlElement(name = "fechafin")
	private String fechafin;
	@XmlElement(name = "descripcion")
	@JsonProperty("descripcion")
	private String detalle;
	@XmlElement(name = "idmostrado")
	private int idmostrado;
	@JsonProperty("img_uri")
	@XmlElement(name = "img_uri")
	private String imagen;

	public String getIdEMPR() {
		return idempr;
	}

	public void setIdEMPR(String idempr) {
		this.idempr = idempr;
	}

	public String getTipoPers() {
		return tipopers;
	}

	public void setTipoPers(String tipopers) {
		this.tipopers = tipopers;
	}

	public Integer getCodPers() {
		return codpers;
	}

	public void setCodPers(Integer codpers) {
		this.codpers = codpers;
	}

	public String getCodEvento() {
		return codevento;
	}

	public void setCodEvento(String codevento) {
		this.codevento = codevento;
	}

	public String getTitulo() {
		return title;
	}

	public void setTitulo(String titulo) {
		this.title = titulo;
	}

	public String getFecha_ini() {
		return fechaini;
	}

	public void setFecha_ini(String fechaini) {
		this.fechaini = fechaini;
	}

	public String getFecha_fin() {
		return fechafin;
	}

	public void setFecha_fin(String fechafin) {
		this.fechafin = fechafin;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Integer getIdMostrado() {
		return idmostrado;
	}

	public void setIdMostrado(Integer idmostrado) {
		this.idmostrado = idmostrado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getFecha_sys() {
		return fechaSys;
	}

	public void setFecha_sys(String fechaSys) {
		this.fechaSys = fechaSys;
	}

}
