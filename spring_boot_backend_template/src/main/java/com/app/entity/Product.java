package com.app.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id //constraint : PK  , BUT not using auto id generation via @GeneratedValue(...)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length = 20,name = "prod_id")
	private Long prodId;
	
	@Column(length = 20)
	private Long price;
	
	@Column(length = 30,name = "prod_name")
	private String prodName;
	
	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
	@Column(length = 30,name = "prod_type")
	private ProdType prodType;
	
	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
	private Cart cart;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long prodId, Long price, String prodName, ProdType prodType, Cart cart) {
		super();
		this.prodId = prodId;
		this.price = price;
		this.prodName = prodName;
		this.prodType = prodType;
		this.cart = cart;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public ProdType getProdType() {
		return prodType;
	}

	public void setProdType(ProdType prodType) {
		this.prodType = prodType;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", price=" + price + ", prodName=" + prodName + ", prodType=" + prodType
				+ ", cart=" + cart + "]";
	}
	
	
}
