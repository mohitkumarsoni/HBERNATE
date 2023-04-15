package com.Many2Many;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	@Column(name = "Employee_Id")
	private int eid;
	@Column(name = "Employee_Name")
	private String eName;
	@ManyToMany		//(mappedBy = "empList") : kitne project pr kitne employees ko assign kia hai
	private List<Project> proList;
	
	/*
	 * NOTE : you can't use (mappedBy) on both (many to many) related tables at some time	 
	 */
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public List<Project> getProList() {
		return proList;
	}
	public void setProList(List<Project> proList) {
		this.proList = proList;
	}
	
	
	
	
	public Employee(int eid, String eName, List<Project> proList) {
		super();
		this.eid = eid;
		this.eName = eName;
		this.proList = proList;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
