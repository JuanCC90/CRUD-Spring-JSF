package com.codenotfound.primefaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
@ViewScoped
public class BasicView implements Serializable{
	
	private long id;
	private String nombre;
	private String anio;
	private long premios;
	
	private List<PeliculaDTO> peliculas;
	private PeliculaRepository pelisRepo;
	
	@Autowired
	private PeliculaService serviPeli;
	
	public BasicView() {
		
	}
	
	public List<PeliculaDTO> getPeliculas(){
		return peliculas;
	}
	
	public void setPelicula(PeliculaService serviPeli) {
		this.serviPeli=serviPeli;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	public String getAnio() {
		return anio;
	}
	
	public void setAnio(String anio) {
		this.anio=anio;
	}
	
	public long getPremios() {
		return premios;
	}
	
	public void setPremios(long premios) {
		this.premios=premios;
	}
	
	
	public void  buscar() {
		peliculas = new ArrayList<>();
		PeliculaDTO dto = serviPeli.buscar(id);
		peliculas.add(dto);
	}
	
	
	public void borraPeli() {
		serviPeli.borraPelicula(id);
	}
	
	public void agregar() {
		PeliculaDTO peli=new PeliculaDTO();
		peli.setId(id);
		peli.setAnio(anio);
		peli.setNombre(nombre);
		peli.setPremios(premios);
		peliculas = new ArrayList<>();
		peliculas.add(peli);
		serviPeli.getAll();
	}

	
	
	
	

	
	
	
	
}
