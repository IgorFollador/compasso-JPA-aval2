package br.com.compasso.avaliacao.executa;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.compasso.avaliacao.dao.ProdutoDao;
import br.com.compasso.avaliacao.modelo.Produto;
import br.com.compasso.avaliacao.util.JPAUtil;

//EXECUÇÃO DO PRIMEIRO EXERCÍCIO DA AVALIAÇÃO DA SPRINT II
public class ExecutaCrud {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			int opt;
			
			while(true) {
				System.out.print("Digite a opção desejada:\n"
						+ "1 - Cadastrar três produtos\n"
						+ "2 - Atualizar o primeiro produto\n"
						+ "3 - Remover o segundo produto\n"
						+ "0 - Sair\n-> ");
				
				opt = input.nextInt();
				
				switch (opt) {
				case 0:
					System.out.println("Finalizando a aplicação...");
					System.exit(0);
				case 1:
					System.out.println("Cadastrando produtos...");
					cadastrarProdutos();
					break;
				case 2:
					atualizarProduto(1l);
					break;
				case 3:
					excluirProduto(2l);
					break;
				}	
			}
		}
	}

	private static void cadastrarProdutos() {
		Produto pendrive = new Produto("Pendrive Multilaser", "USB 2.0/8GB", 
				500, new BigDecimal("20.9"));
		Produto televisao = new Produto("TV LG", "4K UHD, C/WiFi, HDR", 
				233, new BigDecimal("2999.99"));
		Produto bicicleta = new Produto("Bicicleta KSW", "21 Marchas Shimano, Freios A Disco, Aro 29", 
				52, new BigDecimal("1599.0"));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		produtoDao.create(pendrive);
		produtoDao.create(televisao);
		produtoDao.create(bicicleta);
		
		em.getTransaction().commit();
		em.close();
	}
	
	private static void atualizarProduto(Long id) {
		System.out.println("Atualizando produto de ID " + id);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto produto = produtoDao.findById(id);
		produto.setNome("Pendrive Kingston");
		produto.setDescricao("DataTraveler USB 3.0 64GB");
		produto.setQuantidade(489);
		em.getTransaction().begin();
		produtoDao.update(produto);
		em.getTransaction().commit();
		em.close();
	}
	
	private static void excluirProduto(Long id) {
		System.out.println("Excluindo produto de ID " + id);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);	
		
		Produto produto = produtoDao.findById(id);
		em.getTransaction().begin();
		produtoDao.delete(produto);
		em.getTransaction().commit();
		em.close();
	}

}
