package br.com.compasso.avaliacao.executa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.compasso.avaliacao.dao.FilmeDao;
import br.com.compasso.avaliacao.modelo.Filme;
import br.com.compasso.avaliacao.util.JPAUtil;

public class ExecutaFilmesEPaginas {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			
			int nPagina, nFilmes, opt;
			EntityManager em = JPAUtil.getEntityManager();
			FilmeDao filmeDao = new FilmeDao(em);
			
			System.out.print("Selecione uma opção:\n"
					+ "1 - Realizar Busca\n"
					+ "2 - Cadastrar livros(execute na primeira vez)\n-> ");
			opt = input.nextInt();
			
			if(opt==2) cadastraFilmes();
			//Cria paginação
			List<Filme> pagina01 = new ArrayList<>();
			List<Filme> pagina02 = new ArrayList<>();
			for (Long i=1l; i<=20; i++) {
				if(i<=10l) {
					pagina01.add(filmeDao.findById(i));
				}else pagina02.add(filmeDao.findById(i));
			}
			
			while(true) {
				System.out.print("\nDigite o número da página desejada:\n"
						+ "Página 1 - Página 2 - 0 para sair\n-> ");
				nPagina = input.nextInt();
				if(nPagina == 0) {
					System.out.println("Finalizando a aplicação...");
					System.exit(0);
				}
				System.out.print("\nDigite o número de filmes da que você deseja:\n"
						+ "1 - 10\n-> ");
				nFilmes = input.nextInt();
				switch (nPagina) {
				case 1:
					for (Filme f : pagina01) {
						if(nFilmes > 0) {
							System.out.print("\n" + f.getNome() 
								+ " - ID " + f.getId()
								+"\n"+f.getDescricao()
								+"\n"+f.getAno()
								+"\n-------------------------------------------------");
							nFilmes--;
						}
					}
					System.out.println();
					break;
				case 2:
					for (Filme f : pagina02) {
						if(nFilmes > 0) {
							System.out.print("\n" + f.getNome() 
								+ " - ID " + f.getId()
								+"\n"+f.getDescricao()
								+"\n"+f.getAno()
								+"\n-------------------------------------------------");
							nFilmes--;
						}
					}
					System.out.println();
					break;
				}	
			}
		}
	}

	private static void cadastraFilmes() {
		Filme filme01 = new Filme("O Poderoso Chefão", "Sollozzo, em uma reunião com Vito, Sonny e outros...", 1972);
		Filme filme02 = new Filme("O Mágico de Oz", "Em Kansas, Dorothy (Judy Garland) vive em...", 1939);
		Filme filme03 = new Filme("Pulp Fiction – Tempo de Violência", "Vincent Vega e Jules Winnfield são dois assassinos...", 1994);
		Filme filme04 = new Filme("Casablanca ", "O exilado americano Rick Blaine encontrou...", 1942);
		Filme filme05 = new Filme("Forrest Gump – O Contador de Histórias", "Quarenta anos da história dos Estados Unidos, vistos pelos olhos...", 1994);
		Filme filme06 = new Filme("O Rei Leão", "O recém-nascido recebe a bênção do sábio babuíno Rafiki, mas...", 1994);
		Filme filme07 = new Filme("Avatar ", "Jake viaja a Pandora, uma lua extraterrestre, onde encontra diversas...", 2009);
		Filme filme08 = new Filme("Rocky, um Lutador", "Para tentar dar um ânimo no esporte, um programa de televisão decide...", 1976);
		Filme filme09 = new Filme("Contatos Imediatos do Terceiro Grau", "Em uma pequena cidade americana vive Roy Neary...", 1977);
		Filme filme10 = new Filme("O Senhor dos Anéis – A Sociedade do Anel", "Numa terra fantástica e única, chamada Terra-Média, um hobbit...", 2001);
		Filme filme11 = new Filme("Matrix", "Em um futuro próximo, Thomas Anderson, um jovem programador...", 1999);
		Filme filme12 = new Filme("Titanic", "Trata-se de um luxuoso e imponente navio, anunciado na época como inafundável...", 1997);
		Filme filme13 = new Filme("O Iluminado", "Jack Torrance aceita ser caseiro de inverno do isolado Hotel Overlook...", 1980);
		Filme filme14 = new Filme("Star Wars: Episódio V - O Império Contra-Ataca", "As forças imperais comandadas por Darth Vader lançam um ataques...", 1980);
		Filme filme15 = new Filme("Harry Potter e a Pedra Filosofal ", "Harry Potter é um jovem comum de 11 anos até que recebe uma carta...", 2001);
		Filme filme16 = new Filme("O Homem nas Trevas", "Três adolescentes sempre escaparam de seus roubos, todos...", 2016);
		Filme filme17 = new Filme("Os Outros", "Durante a Segunda Guerra, uma mulher vive com os filhos num...", 2001);
		Filme filme18 = new Filme("Psicose", "Marion Crane é uma secretária que rouba 40 mil dólares da imobiliária...", 1960);
		Filme filme19 = new Filme("It - Capítulo 2", "Uma promessa feita há vinte e sete anos chama 7 adultos para...", 2019);
		Filme filme20 = new Filme("Invocação do Mal", "Os mundialmente renomados investigadores paranormais Ed e Lorraine Warren...", 2013);
		
		EntityManager em = JPAUtil.getEntityManager();
		FilmeDao filmeDao = new FilmeDao(em);
		
		em.getTransaction().begin();
		
		filmeDao.create(filme01);
		filmeDao.create(filme02);
		filmeDao.create(filme03);
		filmeDao.create(filme04);
		filmeDao.create(filme05);
		filmeDao.create(filme06);
		filmeDao.create(filme07);
		filmeDao.create(filme08);
		filmeDao.create(filme09);
		filmeDao.create(filme10);
		filmeDao.create(filme11);
		filmeDao.create(filme12);
		filmeDao.create(filme13);
		filmeDao.create(filme14);
		filmeDao.create(filme15);
		filmeDao.create(filme16);
		filmeDao.create(filme17);
		filmeDao.create(filme18);
		filmeDao.create(filme19);
		filmeDao.create(filme20);
	
		em.getTransaction().commit();
		em.close();
		
	}
}
