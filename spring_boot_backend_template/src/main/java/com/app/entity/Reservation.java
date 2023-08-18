package com.app.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name = "outlet_id") 
	private Outlet outlet;
	
	@Column(name="no_of_tables")
	private long tableNo;
	
	@Column(name="dateTime")
	private LocalDate dateTime;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(long id, Outlet outlet, long tableNo, LocalDate dateTime) {
		super();
		this.id = id;
		this.outlet = outlet;
		this.tableNo = tableNo;
		this.dateTime = dateTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Outlet getOutlet() {
		return outlet;
	}

	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}

	public long getTableNo() {
		return tableNo;
	}

	public void setTableNo(long tableNo) {
		this.tableNo = tableNo;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", outlet=" + outlet + ", tableNo=" + tableNo + ", dateTime=" + dateTime + "]";
	}
	
	
}
