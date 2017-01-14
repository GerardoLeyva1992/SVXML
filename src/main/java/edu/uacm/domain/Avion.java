package edu.uacm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "modeloavion",
    "capacidad",
    "lineaaerea"
})
@Table(name="avion")
@Entity
@XmlRootElement(name = "avion")
public class Avion {
	@Id
	@XmlAttribute(name = "idavion")
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idavion;
	@NotNull
	@XmlElement(required = true)
	private String modeloavion;
	@NotNull
	@XmlElement(required = true)
	private int capacidad;
	@NotNull
	@XmlElement(required = true)
	private String lineaaerea;
	public long getIdavion() {
		return idavion;
	}
	public void setIdavion(long idavion) {
		this.idavion = idavion;
	}

	public String getModeloavion() {
		return modeloavion;
	}
	public void setModeloavion(String modeloavion) {
		this.modeloavion = modeloavion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getLineaaerea() {
		return lineaaerea;
	}
	public void setLineaaerea(String lineaaerea) {
		this.lineaaerea = lineaaerea;
	}
}
