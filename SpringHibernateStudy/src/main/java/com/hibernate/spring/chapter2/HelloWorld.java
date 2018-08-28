package com.hibernate.spring.chapter2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.spring.HibernateUtil;

public class HelloWorld {
	public static void main(String[] args) {
		// 첫 번째 작업 단위
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Message message = new Message("Hello World");
		Long msgId = (Long) session.save(message);
		
		System.out.println("msgId: " + msgId);
		
		tx.commit();
		session.close();
		
		// 두 번째 작업 단위
		Session newSession = HibernateUtil.getSessionFactory().openSession();
		Transaction newTransaction = newSession.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Message> messages = newSession.createQuery("from Message m order by m.text asc").list();
		
		System.out.println(messages.size() + "message(s) found:");
		
		for (Message loadedMsg : messages) {
			System.out.println(loadedMsg.getText());
		}
		
		newTransaction.commit();
		newSession.close();
		
		// 애플리케이션 종료
		HibernateUtil.shutdown();
	}
}
