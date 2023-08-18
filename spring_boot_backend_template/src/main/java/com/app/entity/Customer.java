package com.app.entity;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	
	@Column(name="cust_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;
	
	@Column(name = "name",length = 100,nullable = false)
	private String custName;
	
	@Column(length = 50,unique = true,nullable = false)
	private String email;
	
	@Column(length = 50,nullable = false)
	private String password;
	
	@Column(length = 10,nullable = false)
	private String mobile;
	
	@OneToMany(mappedBy = "cust", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Order> orders;
	
	@OneToOne(mappedBy = "cust", cascade = CascadeType.ALL)
	private Cart cart;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long custId, String custName, String email, String password, String mobile, List<Order> orders,
			Cart cart) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.orders = orders;
		this.cart = cart;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + ", orders=" + orders + ", cart=" + cart + "]";
	}
	
	
	
}
