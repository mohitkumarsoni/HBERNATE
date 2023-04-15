package com.Many2Many;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@Column(name = "Project_Id")
	private int pid;
	@Column(name = "Project_Name")
	private String pName;
	@ManyToMany(mappedBy = "proList")	//konse employee k pass konse project hai
	private List<Employee> empList;
	
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
	
	
	public Project(int pid, String pName, List<Employee> empList) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.empList = empList;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
