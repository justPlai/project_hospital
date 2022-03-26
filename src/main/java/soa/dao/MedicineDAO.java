package soa.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.Query;

import soa.model.Hospital;
import soa.model.Medicine;
import soa.model.Medicine;

public class MedicineDAO {

	public ArrayList<Medicine> getAllMedicine() {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Medicine");
		ArrayList<Medicine> medicine = (ArrayList<Medicine>) query.list();
		session.close();
		return medicine;
	}
	
	public Medicine findById(int id) {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Medicine where medicineId =" + id);
		ArrayList<Medicine> medicine = (ArrayList<Medicine>) query.list();
		session.close();
		if (medicine.isEmpty()) {
			return null;
		} else {
			return medicine.get(0);
		}
	}

	public boolean addMedicine(Medicine h) {

		try {
			Session session = SessionUtil.getSession();

			Transaction tx = session.beginTransaction();

			// tx.begin();

			session.save(h);

			tx.commit();

			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;

		}

		return true;

	}

	public boolean updateMedicine(Medicine M) {

		try {
			Session session = SessionUtil.getSession();

			Transaction tx = session.beginTransaction();

			// tx.begin();

			session.saveOrUpdate(M);

			tx.commit();

			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;

		}

		return true;
	}

	public boolean deleteById(int id) {
		try {
			Session session = SessionUtil.getSession();
			Transaction tx = session.beginTransaction();

			Query query = session.createQuery("delete from Medicine where medecineId =" + id);
			int result = query.executeUpdate();
			// ArrayList<Hospital> hospital = (ArrayList<Hospital>) query.list();

			tx.commit();
			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;

		}
		return true;

	}

}
