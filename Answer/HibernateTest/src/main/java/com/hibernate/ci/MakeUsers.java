package com.hibernate.ci;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MakeUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create Session Factory
		SessionFactory factory = new Configuration()
                                 .configure("Hibernate.cfg.xml")
                                 .addAnnotatedClass(FriendEntity.class)
                                 .buildSessionFactory();
		
//		Create session
        Session session = factory.getCurrentSession();
        
        try {
//        	Create Friend object
			System.out.println("Creating new Friend object");
			FriendEntity tempfriend = new FriendEntity("Mohit","Singh","m66@gmail.com","9084858588");
			FriendEntity tempfriend1 = new FriendEntity("Vipin","Sharma","vs45@gmail.com",null);
			FriendEntity tempfriend2 = new FriendEntity("Vinod","Singh","vinod43@gmail.com","9634858588");
			FriendEntity tempfriend3 = new FriendEntity("Himanshu","Yadav","hy43@gmail.com","6344858588");
			FriendEntity tempfriend4 = new FriendEntity("Himanshu","Sharma","hs56@gmail.com",null);
			FriendEntity tempfriend5 = new FriendEntity("Deepak","Yadav","dy745@gmail.com","34484858588");
			FriendEntity tempfriend6 = new FriendEntity("Varun","Singh","varun443@gmail.com",null);
			
//	        Start Transaction
			session.beginTransaction();
			System.out.println("Saving the value");
//			Save the Friend object
			session.save(tempfriend);
			session.save(tempfriend1);
			session.save(tempfriend2);
			session.save(tempfriend3);
			session.save(tempfriend4);
			session.save(tempfriend5);
			session.save(tempfriend6);
			
//			Commit the Transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		finally {
			factory.close();
		}


	}

}
