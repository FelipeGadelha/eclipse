package br.com.portifolio.helpdesk.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	//garantir s� uma instancia na mem�ria
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("helpdesk");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
