package com.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.entity.Bestseller;
import com.study.entity.Product;


@Mapper
public interface ProductDao {
	
	public List<Product> selectAll();

	public int getCount();

	public List<Product> getProcudtByPage(@Param("begin")int begin,@Param("size") int size);
	
	public List<Bestseller> getBestseller();
	
	public Product getById(int pid);
	

}
