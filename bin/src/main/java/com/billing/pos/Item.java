package com.billing.pos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "ITEM")
public class Item {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String author;
	private BigDecimal price;
	private String itemGroup;
	private String discount;
	private String descritpion;
	private String detailName;

	// avoid this "No default constructor for entity"
	public Item() {
	}

	public Item(Long id, String name, String author, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Item(String name, String author, BigDecimal price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
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

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", author=" + author + ", "
				+ "price=" + price + ", group=" + itemGroup
				+ ", discount=" + discount + ", descritpion=" + descritpion 
				+ ", detailName=" + detailName + "]";
	}

}
