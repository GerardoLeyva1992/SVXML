package edu.uacm.dao.impl;


import java.sql.ResultSet;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.uacm.dao.AeropuertoDao;
import edu.uacm.domain.Aeropuertos.Aeropuerto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AeropuertoDaoImpl implements AeropuertoDao{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	JdbcTemplate jdbcTemplate;
	//inyecta la conexion al jdbc en application.properties
	@Override
	public Aeropuerto getById(Long id) {
		//String query="SELECT id, model from vehiculo where id=?"; es lo mismo                    //1, 2
		String query="SELECT nombreaeropuerto from aeropuerto where idaeropuerto="+id;
		try{
			log.debug(query);
		return jdbcTemplate.queryForObject(query, new RowMapper<Aeropuerto>() {
			//funcion anonima
			@Override
			public Aeropuerto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Aeropuerto aer=new Aeropuerto();
				//aer.setIdaeropuerto(rs.getLong(1));
				//vehiculo.setId(rs.getLong(1));
				//lo que me regresa rs en get se lo asigno a vehiculo con el metodo set
				aer.setNombreaeropuerto(rs.getString(1));
				//vehiculo.setModelo(rs.getString(2));
				return aer;
			}
		});
		}catch(EmptyResultDataAccessException dataException){
			return null;
		}catch(BadSqlGrammarException sqlException){
			//por que es modelo no model error en escribir la orden
			//podemos mandar mensajes de errores
			return null;
		}
	}
	

}
