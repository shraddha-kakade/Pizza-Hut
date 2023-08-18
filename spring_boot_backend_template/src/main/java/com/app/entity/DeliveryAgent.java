package com.app.entity;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "Delivery_Agent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAgent {
	@Id //constraint : PK  , BUT not using auto id generation via @GeneratedValue(...)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 20,name = "agent_id")
	private Long agentId;
	
	@Column(length = 30,name = "agent_name")
	private String agentName;
	
	@Column(length = 10,name = "agent_mobile")
	private String agentMobile;
	
	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
	@Column(length = 30)
	private Status status;
	
	@OneToMany(mappedBy = "deliveryAgent", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true /* , fetch = FetchType.EAGER */ )
//	@JsonIgnore //To tell Jackson : ignore this property during ser n de-ser.
	//@JsonIgnoreProperties 
	private List<Order>  orders;

	public DeliveryAgent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryAgent(Long agentId, String agentName, String agentMobile, Status status, List<Order> orders) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.agentMobile = agentMobile;
		this.status = status;
		this.orders = orders;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentMobile() {
		return agentMobile;
	}

	public void setAgentMobile(String agentMobile) {
		this.agentMobile = agentMobile;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "DeliveryAgent [agentId=" + agentId + ", agentName=" + agentName + ", agentMobile=" + agentMobile
				+ ", status=" + status + ", orders=" + orders + "]";
	}
	
	
	
}
