package com.app.entity;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 20,name = "emp_id")
	private Long empId;

	@Column(length = 100,name = "emp_name",nullable = false)
	private String empName;

	@Column(length = 15,nullable = false)
	private String mobile;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)//MERGE : NEW n INTERESTING !!!!!
	@JoinColumn(name = "outlet_id") // Optional BUT reco , to specify the name of FK col.
	private Outlet out;
	
	@OneToMany(mappedBy = "emp",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Order> orders;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long empId, String empName, String mobile, Outlet out, List<Order> orders) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.mobile = mobile;
		this.out = out;
		this.orders = orders;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Outlet getOut() {
		return out;
	}

	public void setOut(Outlet out) {
		this.out = out;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", mobile=" + mobile + ", out=" + out + ", orders="
				+ orders + "]";
	}
	
	
}
