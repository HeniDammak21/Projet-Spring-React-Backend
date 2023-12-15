package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "product")
public class Product {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 @ManyToOne
	 @JoinColumn(name = "category_id", nullable = false)
	 private Category category;
	 private String name;
	 private String description;
     private String brand;
     private float cost;
     private float selling_price;
     private float original_price;
     private int qty;
     private String image;
     private boolean to_buy;
     
     @JsonManagedReference
	    @JsonIgnore
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	    private Set<Changes> changes;
        
        public Product() {
        	
        }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public float getSelling_price() {
			return selling_price;
		}

		public void setSelling_price(float selling_price) {
			this.selling_price = selling_price;
		}

		public float getOriginal_price() {
			return original_price;
		}

		public void setOriginal_price(float original_price) {
			this.original_price = original_price;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public float getCost() {
			return cost;
		}

		public void setCost(float cost) {
			this.cost = cost;
		}

		public boolean isTo_buy() {
			return to_buy;
		}

		public void setTo_buy(boolean to_buy) {
			this.to_buy = to_buy;
		}

}
