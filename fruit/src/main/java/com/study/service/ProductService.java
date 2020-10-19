package com.study.service;

import java.util.List;

import com.study.entity.Bestseller;
import com.study.entity.Product;
import com.study.util.Page;

public interface ProductService {

	public List<Product> selectAll();

	public Page<Product> getByPage(Integer currentPage);

	public List<Bestseller> getBestseller();

	

}
