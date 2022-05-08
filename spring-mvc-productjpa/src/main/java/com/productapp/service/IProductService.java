package com.productapp.service;

import java.util.List;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;

public interface IProductService {

	void addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(int productId);

	Product getById(int prodcutId) throws ProductNotFoundException;

	List<Product> getAll();

	List<Product> getByCategory(String category) throws ProductNotFoundException;

	List<Product> getByChoice(String choice) throws ProductNotFoundException;

	List<Product> getByLesserPrice(double price) throws ProductNotFoundException;

	List<Product> getByBrandStartingWith(String brand) throws ProductNotFoundException;

}
