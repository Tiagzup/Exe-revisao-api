package com.br.zup.revisao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.revisao.modells.Filme;
import com.br.zup.revisao.repositories.FilmeRepository;

@Service
public class FilmeService {
	@Autowired
	private FilmeRepository filmeRepository;
	
	public Iterable<Filme> findAll() {
		return filmeRepository.findAll();
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
