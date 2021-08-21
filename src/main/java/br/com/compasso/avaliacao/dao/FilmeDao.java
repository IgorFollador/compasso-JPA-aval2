package br.com.compasso.avaliacao.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.compasso.avaliacao.modelo.Filme;

public class FilmeDao {
	
	private EntityManager entityM;

	public FilmeDao(EntityManager em) {
		this.entityM = em;
	}
	
	public void create(Filme filme) {
		try {
			this.entityM.persist(filme);
		} catch (Exception e) {
			e.fillInStackTrace();
			System.out.println("Não foi possivel cadastrar o produto\nErro:"
					+ e.getMessage());
		}
	}
	
	public List<Filme> findAll() {
		String jpql = "SELECT filme FROM Filme filme";
		return entityM.createQuery(jpql, Filme.class).getResultList();
	}
	
	public Filme findById(Long id) {
		return entityM.find(Filme.class, id);
	}
	
	public List<Filme> findByName(String nome) {
		String jpql = "SELECT filme FROM Filme filme "
				+ "WHERE filme.nome = :nome";
		return entityM.createQuery(jpql, Filme.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public void update(Filme filme) {
		try {
			this.entityM.merge(filme);
			this.entityM.persist(filme);
		} catch (Exception e) {
			e.fillInStackTrace();
			System.out.println("Não foi possivel atualizar o produto\nErro:"
					+ e.getMessage());
		}
		
	}
	
	public void delete(Filme filme) {
		try {
			filme = entityM.merge(filme);
			this.entityM.remove(filme);
		} catch (Exception e) {
			e.fillInStackTrace();
			System.out.println("Não foi possivel remover o produto\nErro:"
					+ e.getMessage());
		}
	}
}
