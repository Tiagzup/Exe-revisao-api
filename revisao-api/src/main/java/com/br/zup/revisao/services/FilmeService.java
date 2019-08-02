package com.br.zup.revisao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.revisao.exceptions.filmNotFoundException;
import com.br.zup.revisao.modells.Filme;
import com.br.zup.revisao.repositories.FilmeRepository;

@Service
public class FilmeService {
	@Autowired
	private FilmeRepository filmeRepository;
	
	public Iterable<Filme> findAll() {
		return filmeRepository.findAll();
	}
	public long quantityFilm () {
		return filmeRepository.count();
	}
	public Filme catchFilmById (int id) {
		return filmeRepository.findById(id).get();
	}
	public  void saveFilm (Filme filme) {
		 filmeRepository.save(filme);
	}
	public void updateFilm (int id, Filme filme) {
		Optional<Filme> optionalFilme = filmeRepository.findById(id);
		if (!optionalFilme.isPresent()) {
			
		}
	}
	public void deleteFilm (int id) {
		filmeRepository.deleteById(id); {
			throw new filmNotFoundException("Não há filmes nesse id");
		}
		
	}
	
	public void  rentFilm (int id, Filme filme) {
		Optional<Filme> optionalFilme = filmeRepository.findById(id);
		if(!optionalFilme.isPresent()) {
		}
		filme.setId(id);
		filme.setQuantidadeDisponivel(filme.getQuantidadeDisponivel()-1);
		filmeRepository.save(filme);
	}
	
	
	
	
}
