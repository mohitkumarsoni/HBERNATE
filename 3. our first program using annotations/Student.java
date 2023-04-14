package com.Git.gitHubHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "Student_Name")
	private String nameString;
	@Column(name = "Student_City")
	private String cityString;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getCityString() {
		return cityString;
	}

	public void setCityString(String cityString) {
		this.cityString = cityString;
	}

	public Student(int id, String nameString, String cityString) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.cityString = cityString;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", nameString=" + nameString + ", cityString=" + cityString + "]";
	}

}
