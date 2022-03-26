package soa.dao;


import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.Query;

import soa.model.Medicine;

public class MedicineDAO {
	
	public ArrayList<Medicine> getAllMedicine(){
		 Session session = SessionUtil.getSession(); 
		 Query query = session.createQuery("from Medicine");
		 ArrayList<Medicine> medicine =  (ArrayList<Medicine>) query.list();
		 session.close();
		 return medicine ;
	}	

	public boolean addMedicine(Medicine h) {

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

}
