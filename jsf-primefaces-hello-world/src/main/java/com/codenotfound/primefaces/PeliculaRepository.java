package com.codenotfound.primefaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {
	List<Pelicula> findByNombre(String nombre);
	Pelicula getById(long id);
	List<Pelicula> findAll();
	Pelicula findById(long id);
	Pelicula deleteById(long id);

}
