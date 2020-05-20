package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManager {
	private static MyEntityManager instance;
	
	private EntityManager entityManager;
	
	private MyEntityManager() {
		entityManager = Persistence.createEntityManagerFactory("LTWWWJAVA_DHKTPM13A_TUAN02_PHANSANGVO_BAI7").createEntityManager();
	}
	
	public static MyEntityManager getInstance() {
		if(instance == null)
			instance = new MyEntityManager();
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}