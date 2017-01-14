package edu.uacm.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Table(name="pasajero")
@Entity
public class Pasajero {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)	
private Long idpasajero;
@NotNull
private String nombre;
@NotNull
private String apellidopaterno;
private String apellidomaterno;
@NotNull
private String fechanacimiento;
@NotNull
private String nacionalidad;
@NotNull
private Long vuelo_idvuelo;
public Long getIdpasajero() {
	return idpasajero;
}
public void setIdpasajero(Long idpasajero) {
	this.idpasajero = idpasajero;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellidopaterno() {
	return apellidopaterno;
}
public void setApellidopaterno(String apellidopaterno) {
	this.apellidopaterno = apellidopaterno;
}
public String getApellidomaterno() {
	return apellidomaterno;
}
public void setApellidomaterno(String apellidomaterno) {
	this.apellidomaterno = apellidomaterno;
}
public String getFechanacimiento() {
	return fechanacimiento;
}
public void setFechanacimiento(String fechanacimiento) {
	this.fechanacimiento = fechanacimiento;
}
public String getNacionalidad() {
	return nacionalidad;
}
public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}
public Long getVuelo_idvuelo() {
	return vuelo_idvuelo;
}
public void setVuelo_idvuelo(Long vuelo_idvuelo) {
	this.vuelo_idvuelo = vuelo_idvuelo;
}

}