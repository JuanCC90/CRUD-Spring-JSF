package com.codenotfound.primefaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	private PeliculaRepository pelisRepo;
	private PeliculaDTO pelicula;

	@Autowired
	private PeliculaService serviPeli;
	
	RestTemplate rt;
	
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
	
	
	public void buscar() {
		peliculas = new ArrayList<>();
		rt = new RestTemplate();
		ResponseEntity<PeliculaDTO> res =  rt.getForEntity("http://localhost:8080/Pelicula/get/"+id,PeliculaDTO.class);
		peliculas.add(res.getBody());
	}
	
	
	public void borraPeli(long id) {
		serviPeli.borraPelicula(id);
		rt = new RestTemplate();
		rt.delete("http://localhost:8080/Pelicula/Delete/"+id);
		peliculas.addAll(serviPeli.getAll());
	}
	

	public void agregar() {
		/*
		PeliculaDTO peli=new PeliculaDTO();
		peli.setId(id);
		peli.setAnio(anio);
		peli.setNombre(nombre);
		peli.setPremios(premios);
		serviPeli.setPelicula(peli);
		peliculas = new ArrayList<>();
		peliculas.addAll(serviPeli.getAll());
		*/
		pelicula=new PeliculaDTO();
		pelicula.setId(id);
		pelicula.setNombre(nombre);
		pelicula.setAnio(anio);
		pelicula.setPremios(premios);
		
		rt = new RestTemplate();
		
		HttpEntity<PeliculaDTO> request = new HttpEntity<>(pelicula);
		rt.postForObject("http://localhost:8080/Pelicula/post", request, PeliculaDTO[].class);
	}

	public void actualiza() {
		/*
		Pelicula peli=new Pelicula();
		peli.setId(id);
		peli.setNombre(nombre);
		peli.setAnio(anio);
		peli.setPremios(premios);
		serviPeli.actualizaPelicula(peli, id);
		peliculas=new ArrayList<>();
		peliculas.addAll(serviPeli.getAll());
		*/
		pelicula = new PeliculaDTO();
		pelicula.setId(id);
		pelicula.setNombre(nombre);
		pelicula.setAnio(anio);
		pelicula.setPremios(premios);
		
		rt = new RestTemplate();
		HttpEntity<PeliculaDTO> request = new HttpEntity<>(pelicula);
		rt.put("http://localhost:8080/Pelicula/put/"+id,request, PeliculaDTO[].class);
		
	}
	
	
	
	

	
	
	
	
}
