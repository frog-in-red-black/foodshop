package com.study.entity;

public class Product {
	private int id;
	private String productname;
	private String img;
	private String mark;
	private float price;
	
	
	
	

	
	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public String getProductname() {
		return productname;
	}






	public void setProductname(String productname) {
		this.productname = productname;
	}






	public String getImg() {
		return img;
	}






	public void setImg(String img) {
		this.img = img;
	}






	public String getMark() {
		return mark;
	}






	public void setMark(String mark) {
		this.mark = mark;
	}






	public float getPrice() {
		return price;
	}






	public void setPrice(float price) {
		this.price = price;
	}






	public Product() {
		super();
	}






	public Product(int id, String productname, String img, String mark, float price) {
		super();
		this.id = id;
		this.productname = productname;
		this.img = img;
		this.mark = mark;
		this.price = price;
	}






	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", img=" + img + ", mark=" + mark + ", price="
				+ price + "]";
	}






	
	
	
	

}
