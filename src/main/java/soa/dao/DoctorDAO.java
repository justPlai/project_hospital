package soa.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import soa.model.Doctor;
import soa.model.Hospital;

import org.hibernate.Query;

public class DoctorDAO {

	public ArrayList<Doctor> getAllDoctor() {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Doctor");
		ArrayList<Doctor> doctor = (ArrayList<Doctor>) query.list();
		session.close();
		return doctor;
	}

	public Doctor findByID(int id) {

		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Doctor where doctorId =" + id);
		ArrayList<Doctor> doc = (ArrayList<Doctor>) query.list();
		session.close();

		return doc.get(0);

	}

	public boolean addDoctor(Doctor doc) {

		try {
			Session session = SessionUtil.getSession();

			Transaction tx = session.beginTransaction();

			// tx.begin();

			session.save(doc);

			tx.commit();

			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;

		}

		return true;
	}

	public boolean update(Doctor doc) {

		try {
			Session session = SessionUtil.getSession();

			Transaction tx = session.beginTransaction();

			session.saveOrUpdate(doc);

			tx.commit();

			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;

		}

		return true;
	}

	public boolean delete(Doctor doc) {

		try {
			Session session = SessionUtil.getSession();

			Transaction tx = session.beginTransaction();

			session.delete(doc);

			tx.commit();

			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;

		}

		return true;
	}

}
