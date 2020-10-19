package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.entity.Bestseller;
import com.study.entity.Product;
import com.study.service.ProductService;
import com.study.util.Page;



@Controller
public class FruitController {
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("/allFruit")
	public String  showAllFruit(Model model) {

		List<Product> productList=productService.selectAll();
		
		for(Product product:productList) {
			System.out.println(product);
		}
		
		List<Bestseller> bestsellerList=productService.getBestseller();
		for(Bestseller bestseller:bestsellerList){
			System.out.println(bestseller.getProduct().getImg());
		}
		model.addAttribute("bestsellerList", bestsellerList);
		model.addAttribute("productList", productList);
		return "index";
	}
	
	

	@RequestMapping("/fruitByPage")
	public String  showFruitByPage(Integer currentPage,Model model) {
		
		if(currentPage==null) {
			currentPage=1;
		}

		Page<Product> page=productService.getByPage(currentPage);
		System.out.println(page);
		model.addAttribute("page", page);
	
		return "product-list";
	}

}
