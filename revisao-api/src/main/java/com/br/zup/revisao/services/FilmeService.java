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
	public Filme catchFilmById (int id) {
		int filmesDisponiveis = filmeRepository.findById(id).get().getQuantidadeDisponivel();
		try {
			
		}
	}
	
	
	
}
