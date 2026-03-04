package com.billing.pos;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	private double price;
    private double quantity;
	private String discount;
	private String descritpion;
	
	@Enumerated(EnumType.STRING)
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", discount="
				+ discount + ", descritpion=" + descritpion + ", category=" + category + "]";
	}

	public Product(int id, String name, double price, double quantity, String discount, String descritpion,
			Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
		this.descritpion = descritpion;
		this.category = category;
	}

	public Product() {
		super();
	}

	// avoid this "No default constructor for entity"
}