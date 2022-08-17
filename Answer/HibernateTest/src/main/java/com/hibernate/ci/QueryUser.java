package com.hibernate.ci;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create session factory
		 SessionFactory factory = new Configuration()
									.configure("Hibernate.cfg.xml")
									.addAnnotatedClass(FriendEntity.class)
									.buildSessionFactory();
				
				// Create a session
		 Session session = factory.getCurrentSession();
		 
		 try {
			// Begin transaction
				session.beginTransaction();
				
//				Query Friend --> get Friend tuples in the list theFriend
				List<FriendEntity> theFriend = session.createQuery("from FriendEntity").getResultList();
				
//				Display the Friend
				System.out.println("\nGetting all Friends:");
				DisplayFriend(theFriend);
				
//				Answer 1.1  Find all friends with the phone numbers
//				Get all friends from table whose phone number is not null
				
				theFriend = session.createQuery("from FriendEntity f where f.phonenumber IS NOT NULL").getResultList();
				System.out.println("\nGetting Friends who have  phone number: ");
				DisplayFriend(theFriend);
				
				
//				Answer 1.2 Find all friends whose first name starts with a given sub-string	
//				Query Friend whose First name start with "V"
				theFriend = session.createQuery("from FriendEntity f where f.firstName LIKE 'V%'").getResultList();
				System.out.println("\nGetting Friends whose first name starts with 'V': ");
				DisplayFriend(theFriend);
				
//				Answer 1.3 Find all friends whose names contain a given sub-string.	
//				Query friends whose name (first name or last name) contains "im"
				theFriend = session.createQuery("from FriendEntity WHERE CONCAT(firstName,lastName) LIKE '%im%'").getResultList();
				System.out.println("\nGetting Friends whose name contain 'im'.....");
				DisplayFriend(theFriend);
				
				
				
				// Commit the transaction
				session.getTransaction().commit();
				System.out.println("Done !!");
				
				
				
				
		 }
		 finally {
			 factory.close();
		 }
				
				

	}

	private static void DisplayFriend(List<FriendEntity> theFriend) {
		for(FriendEntity tempfriend : theFriend){
			System.out.println(tempfriend);
			
		}
	}

}
