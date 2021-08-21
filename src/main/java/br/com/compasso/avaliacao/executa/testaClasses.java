package br.com.compasso.avaliacao.executa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.compasso.avaliacao.dao.ProdutoDao;
import br.com.compasso.avaliacao.modelo.Produto;
import br.com.compasso.avaliacao.util.JPAUtil;

public class testaClasses {

	public static void main(String[] args) {
		Produto pendrive = new Produto("Pendrive Multilaser", "USB 2.0/8GB", 
				500, new BigDecimal("20.9"));
		Produto televisao = new Produto("TV LG", "4K UHD, C/WiFi, HDR", 
				233, new BigDecimal("2999.99"));
		Produto bicicleta = new Produto("Bicicleta KSW", "21 Marchas Shimano, Freios A Disco, Aro 29", 
				52, new BigDecimal("1599.0"));
		
		System.out.println(pendrive.getNome());
		
		//EntityManager em = JPAUtil.getEntityManager();
//		ProdutoDao produtoDao = new ProdutoDao(em);
//		
//		em.getTransaction().begin();
//		
//		produtoDao.create(pendrive);
//		produtoDao.create(televisao);
//		produtoDao.create(bicicleta);
//		
//		em.getTransaction().commit();
//		em.close();

	}

}
