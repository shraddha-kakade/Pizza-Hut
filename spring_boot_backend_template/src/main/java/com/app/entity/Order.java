package com.app.entity;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer cust;
	
	@ManyToOne
	@JoinColumn(name = "outlet_id")
	private Outlet outlet;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee emp;
	
	@ManyToOne
	@JoinColumn(name = "agent_id")
	private DeliveryAgent deliveryAgent;
	
	@Column(name = "order_time",nullable = false)
	private LocalTime orderTime;
	
	@Column(name = "delivery_time")
	private LocalTime deliveryTime;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Cart cart;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(long orderId, Customer cust, Outlet outlet, Employee emp, DeliveryAgent deliveryAgent,
			LocalTime orderTime, LocalTime deliveryTime, Payment payment, Cart cart) {
		super();
		this.orderId = orderId;
		this.cust = cust;
		this.outlet = outlet;
		this.emp = emp;
		this.deliveryAgent = deliveryAgent;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.payment = payment;
		this.cart = cart;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Outlet getOutlet() {
		return outlet;
	}

	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public DeliveryAgent getDeliveryAgent() {
		return deliveryAgent;
	}

	public void setDeliveryAgent(DeliveryAgent deliveryAgent) {
		this.deliveryAgent = deliveryAgent;
	}

	public LocalTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}

	public LocalTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", cust=" + cust + ", outlet=" + outlet + ", emp=" + emp
				+ ", deliveryAgent=" + deliveryAgent + ", orderTime=" + orderTime + ", deliveryTime=" + deliveryTime
				+ ", payment=" + payment + ", cart=" + cart + "]";
	}
	
	
	
}
