package br.com.compasso.avaliacao.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Integer ano;
	
	public Filme(String nome, String descricao, Integer ano) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.ano = ano;
	}
}
