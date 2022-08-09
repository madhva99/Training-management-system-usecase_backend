package com.tms.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="tms_manager")
public class Manager {
	
	@Id
	@SequenceGenerator(name = "seq_manager",initialValue = 2000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq_manager")
	private int managerId;
	private String managerEmail;
	@Size(min = 4,max = 15)
	private String name;
	private String manager_pw;
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager_pw() {
		return manager_pw;
	}
	public void setManager_pw(String manager_pw) {
		this.manager_pw = manager_pw;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
}
