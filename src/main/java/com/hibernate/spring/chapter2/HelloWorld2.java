package com.hibernate.spring.chapter2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloWorld2 {
	
	public static void main(String[] args) {
		// EntityManagerFactory 시작
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloworld");
		
		// 첫 번째 작업 단위
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Message message = new Message("Hello World");
		em.persist(message);
		
		tx.commit();
		em.close();
		
		// 두 번째 작업 단위
		EntityManager secondEmf = emf.createEntityManager();
		EntityTransaction secondTx = secondEmf.getTransaction();
		secondTx.begin();
		
		@SuppressWarnings("unchecked")
		List<Message> messages = secondEmf.createQuery("select m from Message m order by m.text asc").getResultList();
		
		System.out.println(messages.size() + " messge(s) found");
		
		for (Message msg : messages) {
			System.out.println(msg.getText());
		}
		
		secondTx.commit();
		secondEmf.close();

		// 애플리케이션 종료
		emf.close();
		
	}

}
