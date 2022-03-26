package soa.dao;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import soa.model.Doctor;
import soa.model.Hospital;

import org.hibernate.Query;



public class DoctorDAO {
	
	public ArrayList<Doctor> getAllDoctor(){
		 Session session = SessionUtil.getSession(); 
		 Query query = session.createQuery("from Doctor");
		 ArrayList<Doctor> doctor =  (ArrayList<Doctor>) query.list();
		 session.close();
		 return doctor ;
	}	
	public Doctor findByID(int id) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Doctor where doctorId =" + id);
		ArrayList<Doctor> Doctor = (ArrayList<Doctor>) query.list();
		session.close();
		if(Doctor.isEmpty())
		{
			return null;
		}
		else
		{
		return Doctor.get(0);
		}

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

	public boolean updateDoctor(Doctor d) {

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
	public boolean DeleteByID(int id) {
		try {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("delete from Doctor where doctorId =" + id);
		int result = query.executeUpdate();
		//ArrayList<Hospital> hospital = (ArrayList<Hospital>) query.list();
		

		tx.commit();
		session.close();
		}
		catch (TransactionException e) {
			e.printStackTrace();
			return false;

		}
		return true;

	}
	
}
