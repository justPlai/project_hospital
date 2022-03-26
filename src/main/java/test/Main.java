package test;

import org.hibernate.Hibernate;

import soa.dao.SessionUtil;

public class Main {

	public static void main(String[] args) {

		SessionUtil.getSession();
	}

}
