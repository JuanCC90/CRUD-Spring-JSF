package com.codenotfound.primefaces;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;

@ManagedBean
@SessionScoped
@Entity
@Named
public class Pelicula implements Serializable {
	
	//Entorno:
	@Id
	private long id;
	private String nombre;
	private String anio;
	private long premios;
	
	
	//Constructores:
	
	protected Pelicula() {	
	}
	
	public Pelicula(long id, String nombre, String anio, long premios) {
		this.id=id;
		this.nombre=nombre;
		this.anio=anio;
		this.premios=premios;
	}
	
	//Metodos-Funciones:
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id=id;
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
