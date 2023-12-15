package com.example.demo.dto;

public class ChangeRequest {
	 private int id;
	 private int product;
	 	private String type;
	 	private int nb;
	 	private float unit_cost;
	 	private float unit_price;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getProduct() {
			return product;
		}
		public void setProduct_id(int product) {
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
}
