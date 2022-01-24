package com.example.crud.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int quantity;
	@Column
	private double price;
	public Integer getId() {
		return id;
	}
	public String  getName() {
		return name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
		
	}
	public void setName(String name) {
	this.name=name;
		
	}
	public void setPrice(int price) {
		this.price=price;
		
	}
	public double getPrice() {
		return price;
	}
	
	
}
