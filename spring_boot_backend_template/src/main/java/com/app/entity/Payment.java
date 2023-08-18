package com.app.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Payments")
public class Payment {
	@Id //constraint : PK  , BUT not using auto id generation via @GeneratedValue(...)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 20,name = "pay_id")
	private Long payId;
	
	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
	@Column(length = 30)
	private PayType type;
	
	@OneToOne
	@JoinColumn(name = "cust_id")
	private Customer cust;
	
	@OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Long payId, PayType type, Customer cust, Order order) {
		super();
		this.payId = payId;
		this.type = type;
		this.cust = cust;
		this.order = order;
	}

	public Long getPayId() {
		return payId;
	}

	public void setPayId(Long payId) {
		this.payId = payId;
	}

	public PayType getType() {
		return type;
	}

	public void setType(PayType type) {
		this.type = type;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", type=" + type + ", cust=" + cust + ", order=" + order + "]";
	}
	
	
}
