package edu.uacm.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name="escala")
@Entity
public class Escala {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.SEQUENCE)

	private Long idescala;
	@NotNull
	private Date horasalida;
	@NotNull
	private Date horallegada;
	@NotNull
	private Long aeropuerto_idaeropuerto;
	@NotNull
	private Long aeropuerto_idaeropuerto2;
	@NotNull
	private Long vuelo_idvuelo;
	public Long getIdescala() {
		return idescala;
	}
	public void setIdescala(Long idescala) {
		this.idescala = idescala;
	}
	public Date getHorasalida() {
		return horasalida;
	}
	public void setHorasalida(Date horasalida2) {
		this.horasalida = horasalida2;
	}
	public Date getHorallegada() {
		return horallegada;
	}
	public void setHorallegada(Date horallegada2) {
		this.horallegada = horallegada2;
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
	public Long getVuelo_idvuelo() {
		return vuelo_idvuelo;
	}
	public void setVuelo_idvuelo(Long vuelo_idvuelo) {
		this.vuelo_idvuelo = vuelo_idvuelo;
	}



}
