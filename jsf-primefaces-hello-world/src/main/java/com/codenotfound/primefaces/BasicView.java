package com.codenotfound.primefaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@ManagedBean
@ViewScoped
@Data
public class BasicView implements Serializable{
	
	private long id;
	private String nombre;
	private String anio;
	private long premios;
	
	private List<PeliculaDTO> peliculas;
	private List<PeliculaDTO> peliculaTmp;
	
	private PeliculaRepository pelisRepo;
	private PeliculaDTO pelicula;

	@Autowired
	private PeliculaService serviPeli;
	
	public BasicView() {
		
	}
	
	public List<PeliculaDTO> getPeliculaTmp(){
		return this.peliculaTmp;
	}
	
	public List<PeliculaDTO> getPeliculas(){
		peliculas = serviPeli.getAll();
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
	
	
	public void buscar() {
		peliculaTmp = new ArrayList<>();
		PeliculaDTO dto = serviPeli.buscar(id);
		peliculaTmp.add(dto);
	}
	
	
	public List<PeliculaDTO> borraPeli() {
		peliculas = serviPeli.borraPelicula(id);
		return peliculas;
	}
	
	public void agregar() {
		PeliculaDTO peli=new PeliculaDTO();
		peli.setId(id);
		peli.setAnio(anio);
		peli.setNombre(nombre);
		peli.setPremios(premios);
		serviPeli.setPelicula(peli);
		peliculas = new ArrayList<>();
		peliculas.addAll(serviPeli.getAll());
	}

	public void actualiza() {
		Pelicula peli=new Pelicula();
		peli.setId(id);
		peli.setNombre(nombre);
		peli.setAnio(anio);
		peli.setPremios(premios);
		serviPeli.actualizaPelicula(peli, id);
		peliculas=new ArrayList<>();
		peliculas.addAll(serviPeli.getAll());
		
		RestTemplate es = new RestTemplate();
	}
	
	
	
	

	
	
	
	
}
