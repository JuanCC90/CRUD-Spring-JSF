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
	
	@Query("select p from Pelicula where p.anio like(:anio)")
	List<Pelicula> findByAnio(@Param("anio")String anio);
	
	Pelicula getById(long id);
	
	List<Pelicula> findAll();
	
	@Query("select p from Pelicula where p.id like (:id)")
	Pelicula findById(@Param ("id")long id);
	
	
	Pelicula deleteById(long id);
	
	@Query("select p from Pelicula where p.premios like (:premios)")
	PeliculaDTO findByPremios(@Param ("premios")long premios);

}
