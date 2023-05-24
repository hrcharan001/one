package e1_onetoone_hibernate.controller;

import java.util.Scanner;

import e1_onetoone_hibernate.dao.PanCardCrud;
import e1_onetoone_hibernate.dao.PersonCrud;
import e1_onetoone_hibernate.dto.PanCard;
import e1_onetoone_hibernate.dto.Person;

public class PersonPanCard {

	public static void main(String[] args) {
		PanCardCrud crud=new PanCardCrud();
		PersonCrud crud2=new PersonCrud();
		Scanner sc=new Scanner(System.in);
		boolean check=true;
		do
		{
		System.out.println("choose options \n 1.save pancard \n 2.save person \n 3.updatepancard \n 4.updateperson \n 5.delete pancard "
				+ "\n 6.delete person \n 7.getpancard \n 8.getperson");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		{
			System.out.println("enter ur name");
			String name=sc.next();
			System.out.println("enter ur emailid");
			String email=sc.next();
			System.out.println("enter ur pannumber");
			String pannumber=sc.next();
			System.out.println("enter ur phone");
			long phone=sc.nextLong();
			
			PanCard card=new PanCard(name, email, pannumber, phone);
			crud.savePanCard(card);
		}
		break;
		
		case 2:
		{
			System.out.println("enter ur name");
			String name=sc.next();
			System.out.println("enter ur emailid");
			String email=sc.next();
			System.out.println("enter ur phoneno");
			long phone=sc.nextLong();
			System.out.println("enter ur address");
			String address=sc.next();
			System.out.println("enter ur panID");
			int id=sc.nextInt();
			
			Person person=new Person(name, email, phone, address);
			crud2.savePerson(person, id);
			
			
		}
		break;
		case 3:
		{
			System.out.println("enter ur name");
			String name=sc.next();
			System.out.println("enter ur id");
			int id=sc.nextInt();
			System.out.println("enter ur phoneno");
			long phone=sc.nextLong();
			System.out.println("enter ur emailid");
			String email=sc.next();
			PanCard card=new PanCard();
			card.setName(name);
			card.setPhone(phone);
			card.setEmail(email);
			
			crud.updatePanCard(id, card);
			
		}
		break;
		case 4:
		{
			System.out.println("enter ur name");
			String name=sc.next();
			System.out.println("enter ur phoneno");
			long phone=sc.nextLong();
			System.out.println("enter ur emailid");
			String email=sc.next();
			System.out.println("enter ur id");
			int id=sc.nextInt();
			Person person=new Person();
			person.setName(name);
			person.setPhone(phone);
			person.setEmail(email);
			
			crud2.updatePerson(id, person);
		}
		break;
		case 5:
		{
			System.out.println("enter ur id");
			int id=sc.nextInt();
		
			
			crud.deletePanCard(id);
			System.out.println("deleted");
		}
		break;
		case 6:
		{
			System.out.println("enter ur id");
			int id=sc.nextInt();
		
			
			crud2.deletePerson(id);
			System.out.println("deleted");
		}
		break;
		case 7:
		{
			crud.getPanCardById(3);
		}
		break;
		case 8:
		{
			crud2.getPersonById(1);
		}
			
		
		default:
			break;
		
		
		
		
		
		}
		
		
		
		
		
		
		
		
		
		}
		while(check);
		{
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
