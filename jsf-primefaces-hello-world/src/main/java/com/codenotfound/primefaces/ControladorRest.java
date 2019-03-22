package com.codenotfound.primefaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRest {

	//Entorno:
	@Autowired
	private PeliculaService peliServi;
	
	//Metodos:
	@RequestMapping("/AllPelis")		//Metodo devuelve todos los elementos(Peliculas) de la BD
	public List<PeliculaDTO> getAll(){
		return peliServi.getAll();
	}
	
	
	@PostMapping("/Pelicula/post")		//Metodo para añadir elemento(Pelicula) a la BD
	public List<PeliculaDTO> nuevaPeli(@RequestBody PeliculaDTO newPeli){
		List<PeliculaDTO> peliculas= peliServi.setPelicula(newPeli);
		return peliculas;
	}
	
	@GetMapping("Pelicula/get/{id}")   //Metodo para buscar elemento(Pelicula) por Id
	public PeliculaDTO busqueda(@PathVariable("id") Long id) {
		return peliServi.buscar(id);
		
	}
	
	
	@PutMapping("/Pelicula/put/{id}")	//Metodo para actualizar elemento(Pelicula) por Id
	public List<PeliculaDTO> actualizarPeli(@RequestBody Pelicula nuevaPeli, @PathVariable Long id){
		List<PeliculaDTO> peliculas = peliServi.actualizaPelicula(nuevaPeli, id);
		return peliculas;
	}
	
	
	
	@DeleteMapping("/Pelicula/Delete/{id}")		//Metodo para borrar elementos(Peliculas) por Id
	public List<PeliculaDTO> borrarPelicula(@PathVariable long id){
		peliServi.borraPelicula(id);
		return peliServi.getAll();
	}
	
	

	

	
	

	
}
