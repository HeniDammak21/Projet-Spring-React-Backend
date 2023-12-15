package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "changes")
public class Changes {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 @ManyToOne
	 @JoinColumn(name = "product_id", nullable = false)
	 private Product product;
	 	private String type;
	 	private int nb;
	 	private float unit_cost;
	 	private float unit_price;
	 	private Timestamp change_date;
	 	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getNb() {
			return nb;
		}
		public void setNb(int nb) {
			this.nb = nb;
		}
		public float getUnit_price() {
			return unit_price;
		}
		public void setUnit_price(float unit_price) {
			this.unit_price = unit_price;
		}
		public float getUnit_cost() {
			return unit_cost;
		}
		public void setUnit_cost(float unit_cost) {
			this.unit_cost = unit_cost;
		}
		public Timestamp getChange_date() {
			return change_date;
		}
		public void setChange_date(Timestamp change_date) {
			this.change_date = change_date;
		}
}
