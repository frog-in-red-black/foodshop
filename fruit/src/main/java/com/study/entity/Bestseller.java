package com.study.entity;

public class Bestseller {
	private int id;
	private int pid;
	private Product product;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Bestseller(int id, int pid, Product product) {
		super();
		this.id = id;
		this.pid = pid;
		this.product = product;
	}
	public Bestseller() {
		super();
	}
	
	

}
