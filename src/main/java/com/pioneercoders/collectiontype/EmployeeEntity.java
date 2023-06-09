package com.pioneercoders.collectiontype;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_ADDRESS_TBL", schema="pcdb")
public class EmployeeEntity {

	@Id
	@Column(name="EMP_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="EMP_NAME",nullable = false, length = 30)
	private String employeeName;
	
	@Column(name="AGE", nullable = true, length = 3)
	private int age;

	@Embedded
	private Address address;
	
	@ElementCollection
	@CollectionTable(name="EMP_MOBILE_NUBMBER_TBL", joinColumns=@JoinColumn(name ="EMP_ID"))
	@Column(name="MOBILE_NUMBER",nullable = false, length = 15)
	private List<String> mobileNumbers;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	
	public List<String> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(List<String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	
	
}
