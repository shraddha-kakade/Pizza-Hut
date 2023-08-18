package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
@Table(name = "Outlets")
public class Outlet {
	@Id //constraint : PK  , BUT not using auto id generation via @GeneratedValue(...)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 20,name = "outlet_id")
	private Long outletId;

	@NotBlank(message = "Name is required")
	@Column(length = 20,name = "outlet_name")
	private String outletName;
	
	@Column(length = 100)
	private String address;
	@Column(length = 10)
	private Long tables ;
	
	@OneToMany(mappedBy = "outlet", cascade = CascadeType.ALL, orphanRemoval = true /* , fetch = FetchType.EAGER */ )
	private List<Order>order;
	
	@OneToMany(mappedBy = "outlet",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reservation> reservations;

	public Outlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Outlet(Long outletId, @NotBlank(message = "Name is required") String outletName, String address, Long tables,
			List<Order> order, List<Reservation> reservations) {
		super();
		this.outletId = outletId;
		this.outletName = outletName;
		this.address = address;
		this.tables = tables;
		this.order = order;
		this.reservations = reservations;
	}

	public Long getOutletId() {
		return outletId;
	}

	public void setOutletId(Long outletId) {
		this.outletId = outletId;
	}

	public String getOutletName() {
		return outletName;
	}

	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getTables() {
		return tables;
	}

	public void setTables(Long tables) {
		this.tables = tables;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Outlet [outletId=" + outletId + ", outletName=" + outletName + ", address=" + address + ", tables="
				+ tables + ", order=" + order + ", reservations=" + reservations + "]";
	}
	
	
}
