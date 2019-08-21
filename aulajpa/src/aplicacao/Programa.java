package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	public static void main(String[] args) {
	/*
		Pessoa p1 = new Pessoa(null,"Carlos da Silva","carlos@gmail.com");
		Pessoa p2 = new Pessoa(null,"Joaquim Torres","joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null,"Ana Maria","ana@gmail.com");
	*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");//Cria a fabrica de gerenciador de entidades
		EntityManager em = emf.createEntityManager();//Cria o gerenciador de entidades
	/*	
		em.getTransaction().begin();//Inicia uma transação
			em.persist(p1);//Cria o objeto no banco
			em.persist(p2);
			em.persist(p3);
		em.getTransaction().commit();
	*/
	
		Pessoa p = em.find(Pessoa.class, 1);
		
		System.out.println(p);
		/*	Entidade Monitorada: é uma entidade que acabou de ser 
		 	inserida, ou foi buscada (find) antes do EntityManager fechar
		*/
	/*
		em.getTransaction().begin();
			Pessoa p = em.find(Pessoa.class, 2);
			em.remove(p);
		em.getTransaction().commit();
	*/	
		System.out.println("Pronto");
		em.close();
		emf.close();
	}
}
