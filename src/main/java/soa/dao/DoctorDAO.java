package soa.dao;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import soa.model.Doctor;

import org.hibernate.Query;



public class DoctorDAO {
	
	public ArrayList<Doctor> getAllDoctor(){
		 Session session = SessionUtil.getSession(); 
		 Query query = session.createQuery("from Doctor");
		 ArrayList<Doctor> doctor =  (ArrayList<Doctor>) query.list();
		 session.close();
		 return doctor ;
	}

	public boolean addDoctor(Doctor h) {

		try {
			Session session = SessionUtil.getSession();

			Transaction tx = session.beginTransaction();

			//tx.begin();

			session.save(h);

			tx.commit();

			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;
		
		}

		return true;
	} 

	public boolean update(Doctor d) {

		try {
			Session session = SessionUtil.getSession();

			Transaction tx = session.beginTransaction();

			//tx.begin();

			session.saveOrUpdate(d);

			tx.commit();

			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;
		
		}

		return true;
	} 
	
}
