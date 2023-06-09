package com.pioneercoders.collectiontype;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibenateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();

		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeName("Rama Krishna");
		employeeEntity.setAge(24);

		Address address = new Address();
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setStreet("BTM");
		address.setZipcode("560029");

		// set composite type address
		employeeEntity.setAddress(address);

		
		List<String> mobileNumbers = new ArrayList<String>();
		mobileNumbers.add("8123870076");
		mobileNumbers.add("+91-8123870076");
		
		// collection type mobile numbers
		employeeEntity.setMobileNumbers(mobileNumbers);

		session.save(employeeEntity);
		transaction.commit();

	}

}