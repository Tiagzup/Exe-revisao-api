package com.br.zup.revisao.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.revisao.modells.Filme;
import com.br.zup.revisao.services.FilmeService;

@RequestMapping("/filmes")
@RestController
@CrossOrigin(origins = "*")
public class FilmController {
	@Autowired
	private FilmeService filmeService;
	@GetMapping
	public ResponseEntity<?> findAllFilms (){
		if (filmeService.quantityFilm() > 0 ) {
			return ResponseEntity.ok(filmeService.findAllFilms());
		}
		return  ResponseEntity.noContent().build();
	}
	@GetMapping("{id}")
	public ResponseEntity<?> catchFilmById (@PathVariable int id){
		try {
			return ResponseEntity.ok(filmeService.catchFilmById(id));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	@GetMapping("/alugar/{id}")
	public ResponseEntity<?> rentFilm (@PathVariable int id, @Valid @RequestBody Filme film) {
		try {
			filmeService.rentFilm(id, film);
			return ResponseEntity.ok().body(filmeService.catchFilmById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@GetMapping("/devolver/{id}")
	public ResponseEntity<?> returnFilm (@PathVariable int id,@Valid @RequestBody Filme film) {
		filmeService.returnFilm(id, film);
		return ResponseEntity.ok().body(filmeService.catchFilmById(id));
		
	}
	@PostMapping("/salvar")
	public ResponseEntity<?> saveFilm (@Valid @RequestBody Filme film){
		filmeService.saveFilm(film);
		return ResponseEntity.status(HttpStatus.CREATED).body(film);
	}
	
	
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<?> updateFilm (@PathVariable int id, @Valid @RequestBody Filme film) {
		try {
			film.setId(id);
			filmeService.updateFilm(id, film);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(film);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(film);
		}
		
	}
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> deletleFilm (@PathVariable int id) {
		try {
			filmeService.deleteFilm(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	
}







