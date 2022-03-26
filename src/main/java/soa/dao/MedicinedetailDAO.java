package soa.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import soa.model.Doctor;
import soa.model.Medicinedetail;

import org.hibernate.Query;

public class MedicinedetailDAO {

	public ArrayList<Medicinedetail> getAllMedicinedetail() {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Medicinedetail");
		ArrayList<Medicinedetail> Medicinedetail = (ArrayList<Medicinedetail>) query.list();
		session.close();
		return Medicinedetail;
	}

	public boolean addMedicinedetail(Medicinedetail h) {

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

}
