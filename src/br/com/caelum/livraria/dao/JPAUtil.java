package br.com.caelum.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("livraria");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(EntityManager em) {
		em.close();
	}
}

//java -cp /home/gleiton/dev/livraria2/WebContent/WEB-INF/lib/hsqldb.jar org.hsqldb.server.WebServer --database.0 file:mydb --dbname.0 xdb
