package com.codenotfound.primefaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {
	@Query("select p from Pelicula where p.id like (:id) and p.nombre like (:nombre) and p.anio like (:anio) and p.premios like (:premios) ")
	List<Pelicula> findByNombre(@Param("id") long id, @Param("nombre") String nombre, @Param("anio") String anio, @Param("premios") long premios);
	
	
	Pelicula getById(long id);
	
	List<Pelicula> findAll();
	
	
	Pelicula findById(long id);
	
	
	Pelicula deleteById(long id);
	
}
