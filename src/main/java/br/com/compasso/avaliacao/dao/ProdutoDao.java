package br.com.compasso.avaliacao.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.compasso.avaliacao.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager entityM;

	public ProdutoDao(EntityManager em) {
		this.entityM = em;
	}
	
	public void create(Produto produto) {
		try {
			this.entityM.persist(produto);
			System.out.println("\nProduto " + produto.getNome() 
			+ " com ID: " + produto.getId() + " foi cadastrado com sucesso!");
			
		} catch (Exception e) {
			e.fillInStackTrace();
			System.out.println("Não foi possivel cadastrar o produto\nErro:"
					+ e.getMessage());
		}
	}
	
	public List<Produto> findAll() {
		String jpql = "SELECT produto FROM Produto produto";
		return entityM.createQuery(jpql, Produto.class).getResultList();
	}
	
	public Produto findById(Long id) {
		return entityM.find(Produto.class, id);
	}
	
	public List<Produto> findByName(String nome) {
		String jpql = "SELECT produto FROM Produto produto "
				+ "WHERE produto.nome = :nome";
		return entityM.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public void update(Produto produto) {
		produto.setDataAlteracao(LocalDateTime.now());
		try {
			this.entityM.merge(produto);
			this.entityM.persist(produto);
			System.out.println("Produto de ID " + produto.getId() + " atualizado com sucesso!");
		} catch (Exception e) {
			e.fillInStackTrace();
			System.out.println("Não foi possivel atualizar o produto\nErro:"
					+ e.getMessage());
		}
		
	}
	
	public void delete(Produto produto) {
		try {
			produto = entityM.merge(produto);
			this.entityM.remove(produto);
			System.out.println("Produto de ID " + produto.getId() + " removido com sucesso!");
		} catch (Exception e) {
			e.fillInStackTrace();
			System.out.println("Não foi possivel remover o produto\nErro:"
					+ e.getMessage());
		}
	}
}
