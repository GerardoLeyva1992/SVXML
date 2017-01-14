package edu.uacm.domain;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name="vuelo")
@Entity
public class Vuelo {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idvuelo;
	@NotNull
	private Date horasalida;
	@NotNull
	private Date horallegada;
	@NotNull
	private Long aeropuerto_idaeropuerto;
	@NotNull
	private Long aeropuerto_idaeropuerto2;
	private Long avion_idavion;
	public Long getIdvuelo() {
		return idvuelo;
	}
	public void setIdvuelo(Long idvuelo) {
		this.idvuelo = idvuelo;
	}
	public Date getHorasalida() {
		return horasalida;
	}
	public void setHorasalida(Date horasalida) {
		this.horasalida = horasalida;
	}
	public Date getHorallegada() {
		return horallegada;
	}
	public void setHorallegada(Date horallegada) {
		this.horallegada = horallegada;
	}
	public Long getAeropuerto_idaeropuerto() {
		return aeropuerto_idaeropuerto;
	}
	public void setAeropuerto_idaeropuerto(Long aeropuerto_idaeropuerto) {
		this.aeropuerto_idaeropuerto = aeropuerto_idaeropuerto;
	}
	public Long getAeropuerto_idaeropuerto2() {
		return aeropuerto_idaeropuerto2;
	}
	public void setAeropuerto_idaeropuerto2(Long aeropuerto_idaeropuerto2) {
		this.aeropuerto_idaeropuerto2 = aeropuerto_idaeropuerto2;
	}
	public Long getAvion_idavion() {
		return avion_idavion;
	}
	public void setAvion_idavion(Long avion_idavion) {
		this.avion_idavion = avion_idavion;
	}


}
