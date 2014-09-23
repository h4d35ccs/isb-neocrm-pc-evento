/**
 * 
 */
package com.isb.neocrm.pc.evento.pres.rs.api;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.isb.neocrm.pc.evento.logic.domain.Evento;

/**
 * @author ottoabreu
 *
 */
@XmlRootElement(name = "Eventos")
@JsonInclude(Include.NON_NULL)
public class EventoResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty("fecha_hoy")
	private String sysDate;
	@JsonProperty("item")
	private Collection<Evento> item;
	@JsonProperty("mensaje")
	private String emptyList;

	public String getEmptyList() {
		return emptyList;
	}

	public void setEmptyList(String emptyList) {
		this.emptyList = emptyList;
	}

	public Collection<Evento> getItem() {
		return item;
	}

	public void setItem(Collection<Evento> item) {
		this.item = item;
	}

	public String getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate.toString();
	}

	public void setSysDate(String sysDate) {
		this.sysDate = sysDate;
	}

	@Override
	public String toString() {
		return "EventoResponse [sysDate=" + sysDate + ", item=" + item
				+ ", emptyList=" + emptyList + "]";
	}
	
}
