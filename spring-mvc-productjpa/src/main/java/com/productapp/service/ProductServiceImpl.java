package com.productapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements  IProductService{
	

	IProductRepository productRepository;
	public ProductServiceImpl(IProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

    
    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getByCategory(String category) throws ProductNotFoundException {
        return productRepository.findByCategory(category).stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByChoice(String choice) throws ProductNotFoundException {
        return productRepository.findByChoice(choice).stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByLesserPrice(double price) throws ProductNotFoundException {
        return productRepository.findByPriceLessThan(price).stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByBrandStartingWith(String brand) throws ProductNotFoundException {
        return productRepository.findByBrandStartingWith(brand).stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    @Override
    public Product getById(int productId) throws ProductNotFoundException {
        return productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("Invalid id"));
    }

    

    

}
