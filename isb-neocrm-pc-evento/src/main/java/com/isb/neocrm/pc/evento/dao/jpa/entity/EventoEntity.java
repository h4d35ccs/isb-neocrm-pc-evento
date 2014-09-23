package com.isb.neocrm.pc.evento.dao.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entidad en BBDD del evento. Author: schamorro Date: 10/09/14.
 */

@Entity
@NamedQueries({ @NamedQuery(name = "findEventByTipoPerAndCodePer", 
query = "SELECT E FROM EventoEntity E WHERE E.codpers = :codpers AND E.tipopers = :tipopers") })
// @Table(name = "PC_EVENTOS", schema = "DESNEOC")
@Table(name = "PC_EVENTOS")
public class EventoEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	private String tipopers;
	@Id
	private int codpers;
	@Id
	@Column(name = "COD_EVENTO")
	private String codevento;

	private String idempr;
	// @Id
	@Column(name = "IND_MOSTRADO")
	private Integer ind_mostrado;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "FECHA_INI")
	private Date fechaini;

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechaini() {
		return fechaini;
	}

	@Column(name = "FECHA_FIN")
	private Date fechafin;

	@Column(name = "DETALLE")
	private String detalle;

	@Column(name = "IMAGEN")
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
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

//	public String getFechaini() {
//
//		return this.getDateByFormat(EVENTO_DEFAULT_DATE_FORMAT,
//				EVENTO_DEFAULT_TIME_ZONE, fechaini);
//	}
//
//	public String getFechafin() {
//
//		return this.getDateByFormat(EVENTO_DEFAULT_DATE_FORMAT,
//				EVENTO_DEFAULT_TIME_ZONE, fechafin);
//	}
//
//	private String getDateByFormat(String format, String timezone, Date date) {
//
//		TimeZone tz = TimeZone.getTimeZone(timezone);
//		DateFormat df = new SimpleDateFormat(format);
//		df.setTimeZone(tz);
//
//		return df.format(date);
//	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public void setFecha_fin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Integer getIdMostrado() {
		return ind_mostrado;
	}

	public void setIdMostrado(Integer ind_mostrado) {
		this.ind_mostrado = ind_mostrado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "EventoEntity [tipopers=" + tipopers + ", codpers=" + codpers
				+ ", codevento=" + codevento + ", idempr=" + idempr
				+ ", ind_mostrado=" + ind_mostrado + ", titulo=" + titulo
				+ ", fechaini=" + fechaini + ", fechafin=" + fechafin
				+ ", detalle=" + detalle + ", imagen=" + imagen + "]";
	}

	
}
