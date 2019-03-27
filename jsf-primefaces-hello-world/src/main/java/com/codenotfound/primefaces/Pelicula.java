package com.codenotfound.primefaces;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ManagedBean
@SessionScoped
@Entity
@Named
public class Pelicula implements Serializable {
	
	//Entorno:
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", updatable=false, nullable=false)
	private long id;
	private String nombre;
	private String anio;
	private long premios;
	
	
	//Constructores:
	
	protected Pelicula() {	
	}
	
	public Pelicula(String nombre, String anio, long premios) {
		this.nombre=nombre;
		this.anio=anio;
		this.premios=premios;
	}
	
	//Metodos-Funciones:
	
	public long getId() {
		return this.id;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getAnio() {
		return this.anio;
	}
	
	public void setAnio(String anio) {
		this.anio=anio;
	}
	
	public long getPremios() {
		return this.premios;
	}
	
	public void setPremios(long premios) {
		this.premios=premios;
	}
	
	
	@Override
	public String toString() {
		return String.format(
				"Peliculas[nId=%d, nombre='%s', anio='%s', premios='%d']",
				id,nombre,anio,premios);
	}
	
	
	
	

}
