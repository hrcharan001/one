package e1_onetoone_hibernate.dao;

import java.lang.annotation.Target;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import e1_onetoone_hibernate.dto.PanCard;

public class PanCardCrud {
	
	public EntityManager getmanager()
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hari");
		EntityManager manager=factory.createEntityManager();
		return manager;
	}

	public void savePanCard(PanCard card)
	{
		EntityManager manager=getmanager();
		EntityTransaction transaction=manager.getTransaction();
	    transaction.begin();
	    manager.persist(card);
	    transaction.commit();
	
	}
	
	public void updatePanCard(int id,PanCard card)
	{
		EntityManager manager=getmanager();

		PanCard dbcard=manager.find(PanCard.class, id);
		if(dbcard!=null)
		{
			dbcard.setName(card.getName());
			dbcard.setPhone(card.getPhone());
			dbcard.setEmail(card.getEmail());
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.merge(dbcard);
			transaction.commit();
		}
		
	}
	
	public void deletePanCard(int id)
	{
		EntityManager manager=getmanager();
        PanCard dbcard=manager.find(PanCard.class, id);
        
        if(dbcard!=null)
        {
        EntityTransaction transaction=manager.getTransaction();
        transaction.begin();
        manager.remove(dbcard);
        transaction.commit();
        }
        else
        	System.out.println("ur id is not exist to delete");
	}
	
public void getPanCardById(int id)
{
	EntityManager manager=getmanager();
	PanCard dbcard=manager.find(PanCard.class, id);
	if(dbcard!=null)
	{
	System.out.println(dbcard);
	}
	else
		System.out.println("no user found"+id);
}
}
