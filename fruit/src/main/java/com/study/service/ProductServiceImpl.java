package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dao.ProductDao;
import com.study.entity.Bestseller;
import com.study.entity.Product;
import com.study.util.Constant;
import com.study.util.Page;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		return productDao.selectAll();
	}

	@Override
	public Page<Product> getByPage(Integer currentPage) {
		// TODO Auto-generated method stub
		Page<Product> page=new Page();
		
		int totalCount=productDao.getCount();
		int totalPage;
		if(totalCount%Constant.Size==0) {
			
			totalPage=totalCount/Constant.Size;
			
		}else {
			totalPage=totalCount/Constant.Size+1;
			
		}
		int begin=(currentPage-1)*Constant.Size;
		int size=Constant.Size;
		List<Product> productList=productDao.getProcudtByPage(begin,size);
		
		page.setCurrentPage(currentPage);
		page.setList(productList);
		page.setTotalPage(totalPage);
		page.setTotalCount(totalCount);
		return page;
	}

	@Override
	public List<Bestseller> getBestseller() {
		List<Bestseller> bestsellerList=productDao.getBestseller();
		for(Bestseller bestseller:bestsellerList) {
			int pid = bestseller.getPid();
			Product product=productDao.getById(pid);
			bestseller.setProduct(product);
		}
		return bestsellerList;
	}

	
	

}
