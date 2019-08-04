package com.br.zup.revisao.modells;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Filme implements Serializable {
	private static final long seriaVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "O campo nome precisa ser preenchido")
	@Size(min = 2, message = "O nome do filme precisa ter no mínimo dois caractéres")
	private String nome;
	@NotBlank(message = "O link da capa não pode ser branco")
	@Size(min = 10, message = "O link da capa precisa ter no mínimo dez caratéres")
	private String linkDaCapa;
	@NotBlank(message = "O campo ano precisa ser preenchido")
	private int ano;
	@NotBlank(message = "O campo duracao precisa ser preenchido")
	private int duracao;
	@NotBlank(message = "O campo gênero precisa ser preenchido")
	@Size(min = 2, message = "O campo gênero precisa ter no mínimo dois caractéres")
	private String genero;
	@NotBlank(message = "O campo classificação indicativa precisa ser preenchido")
	private int classificacaoIndicativa;
	private int quantidadeDisponivel;
	
	
	
	public Filme() {
		
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getLinkDaCapa() {
		return linkDaCapa;
	}



	public void setLinkDaCapa(String linkDaCapa) {
		this.linkDaCapa = linkDaCapa;
	}



	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}



	public int getDuracao() {
		return duracao;
	}



	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}



	public void setClassificacaoIndicativa(int classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}



	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}



	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}
	
}






















