package e1_onetoone_hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import e1_onetoone_hibernate.dto.Person;
import e1_onetoone_hibernate.dto.PanCard;



public class PersonCrud {
 
	
	public EntityManager getmanager()
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hari");
		EntityManager manager=factory.createEntityManager();
		return manager;
	}
	
	
	public void savePerson(Person person,int id )
	{
		EntityManager manager=getmanager();
		PanCard card=manager.find(PanCard.class, id);
		if(card!=null)
		{
			person.setCard(card);
			EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(person);
		transaction.commit();
	}
	}
	public void updatePerson(int id,Person person)
	{
		EntityManager manager=getmanager();
		Person dbperson=manager.find(Person.class, id);
		
		if(dbperson!=null)
		{
			dbperson.setName(person.getName());
		    dbperson.setEmail(person.getEmail());
			dbperson.setPhone(person.getPhone());
		
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.merge(dbperson);
			transaction.commit();
		}
	}
	
	public void deletePerson(int id)
	{
		EntityManager manager=getmanager();
        Person card=manager.find(Person.class, id);
        
        if(card!=null)
        {
        EntityTransaction transaction=manager.getTransaction();
        transaction.begin();
        manager.remove(card);
        transaction.commit();
        }
        else
        	System.out.println("ur id is not exist to delete");
	}
	
	public void getPersonById(int id)
	{
		EntityManager manager=getmanager();
		Person card=manager.find(Person.class, id);
		if(card!=null)
		{
		System.out.println(card);
		}
		else
			System.out.println("no user found"+id);
	}
	
	
	
}
