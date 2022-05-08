package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@Controller
public class ProductController {
	
	IProductService productService;
	
	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}


	@RequestMapping("/")
	public String home(ModelMap map) {
		// get all the produts bt
		List<Product> products = productService.getAll();
		map.addAttribute("products", products);
		return "home";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Product product) {
		 productService.addProduct(product);
		return "admin";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("choice") String choice ,ModelMap map) {
		List<Product> products = productService.getByChoice(choice);
		map.addAttribute("products", products);
		return "home";
		
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int productId) {
		productService.deleteProduct(productId);
		return "admin";
	}
	
	@RequestMapping("/getOneProduct")
	public String getOneProduct(@RequestParam("productId") int productId,Model model) {
		 Product product = productService.getById(productId);
		 model.addAttribute("product",product);
		 return "updateProductForm";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(Product product) {
		productService.updateProduct(product);
		return "admin";
	}
	
	
}
