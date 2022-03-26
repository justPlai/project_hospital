package soa.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.Query;

import soa.model.Hospital;

public class HospitalDAO {

	public ArrayList<Hospital> getAllHospital() {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Hospital");
		ArrayList<Hospital> hospital = (ArrayList<Hospital>) query.list();
		session.close();
		return hospital;
	}

	public Hospital findByID(int id) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Hospital where hospitalId =" + id);
		ArrayList<Hospital> hospital = (ArrayList<Hospital>) query.list();
		session.close();

		return hospital.get(0);

	}

	public boolean addHospital(Hospital hos) {

		try {
			Session session = SessionUtil.getSession();

			Transaction tx = session.beginTransaction();

			// tx.begin();

			session.save(hos);

			tx.commit();

			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;

		}

		return true;
	}

}
