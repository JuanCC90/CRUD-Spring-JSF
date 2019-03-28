package com.codenotfound.primefaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {
	@Query("select p from Pelicula where p.id like (:id) and p.nombre like :nombre ")
	List<Pelicula> findByNombre(@Param("id") String id, @Param("nombre") String nombre);
	List<Pelicula> findByAnio(String anio);
	Pelicula getById(long id);
	List<Pelicula> findAll();
	Pelicula findById(long id);
	Pelicula deleteById(long id);
	Pelicula findByPremios(long premios);

}
