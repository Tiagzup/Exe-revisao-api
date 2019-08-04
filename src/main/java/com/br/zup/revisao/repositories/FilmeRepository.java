package com.br.zup.revisao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.revisao.modells.Filme;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {

}
