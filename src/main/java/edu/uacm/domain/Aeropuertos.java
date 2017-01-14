package edu.uacm.domain;

//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.01.09 a las 12:14:32 AM CST 
//



import java.util.ArrayList;
import java.util.List;

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


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="aeropuerto" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="nombreaeropuerto"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;pattern value="([A-Z][a-z])+"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="ciudad" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="pais" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="idaeropuerto" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aeropuerto"
})
@XmlRootElement(name = "aeropuertos")
public class Aeropuertos {

  


	@XmlElement(required = true)
	public
     List<Aeropuertos.Aeropuerto> aeropuerto;

    /**
     * Gets the value of the aeropuerto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aeropuerto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAeropuerto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Aeropuertos.Aeropuerto }
     * 
     * 
     */
    public List<Aeropuertos.Aeropuerto> getAeropuerto() {
        if (aeropuerto == null) {
            aeropuerto = new ArrayList<Aeropuertos.Aeropuerto>();
        }
        return this.aeropuerto;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="nombreaeropuerto"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;pattern value="([A-Z][a-z])+"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ciudad" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="pais" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="idaeropuerto" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nombreaeropuerto",
        "ciudad",
        "pais"
    })
    @Table(name="aeropuerto")
    @Entity
    public static class Aeropuerto {

        @XmlElement(required = true)
    	@NotNull
        protected String nombreaeropuerto;
        @XmlElement(required = true)
    	@NotNull
        protected String ciudad;
        @XmlElement(required = true)
    	@NotNull
        protected String pais;
        @XmlAttribute(name = "idaeropuerto")
    	@Id
    	@NotNull
    	@GeneratedValue(strategy = GenerationType.AUTO)
        protected Long idaeropuerto;

        /**
         * Obtiene el valor de la propiedad nombreaeropuerto.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombreaeropuerto() {
            return nombreaeropuerto;
        }

        /**
         * Define el valor de la propiedad nombreaeropuerto.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombreaeropuerto(String value) {
            this.nombreaeropuerto = value;
        }

        /**
         * Obtiene el valor de la propiedad ciudad.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCiudad() {
            return ciudad;
        }

        /**
         * Define el valor de la propiedad ciudad.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCiudad(String value) {
            this.ciudad = value;
        }

        /**
         * Obtiene el valor de la propiedad pais.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPais() {
            return pais;
        }

        /**
         * Define el valor de la propiedad pais.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPais(String value) {
            this.pais = value;
        }

        /**
         * Obtiene el valor de la propiedad idaeropuerto.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getIdaeropuerto() {
            return idaeropuerto;
        }

        /**
         * Define el valor de la propiedad idaeropuerto.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setIdaeropuerto(Long value) {
            this.idaeropuerto = value;
        }

    }

}