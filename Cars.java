package com.wipro.bestcar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand;
	private String model;
	private int year;
	private int no_Of_Kms;
	private String price;
	private String fuel;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getNo_Of_Kms() {
		return no_Of_Kms;
	}
	public void setNo_Of_Kms(int no_Of_Kms) {
		this.no_Of_Kms = no_Of_Kms;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	@Override
	public String toString() {
		return "Cars [id=" + id + ", brand=" + brand + ", model=" + model + ", year=" + year + ", no_Of_Kms="
				+ no_Of_Kms + ", price=" + price + ", fuel=" + fuel + "]";
	}



}
