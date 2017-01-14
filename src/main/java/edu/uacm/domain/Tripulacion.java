package edu.uacm.domain;





import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name="tripulacion")
@Entity @IdClass(Tripulacion.class)
public class Tripulacion implements Serializable  {
	@Id
	private Long vuelo_idvuelo;
	@Id
	private Long empleado_codigo;
	@NotNull
	private String puesto;

	
	public Long getVuelo_idvuelo() {
		return vuelo_idvuelo;
	}
	public void setVuelo_idvuelo(Long vuelo_idvuelo) {
		this.vuelo_idvuelo = vuelo_idvuelo;
	}
	public Long getEmpleado_codigo() {
		return empleado_codigo;
	}
	public void setEmpleado_codigo(Long empleado_codigo) {
		this.empleado_codigo = empleado_codigo;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	

	
	

}
