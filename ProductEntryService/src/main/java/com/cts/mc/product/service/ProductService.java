package com.cts.mc.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.mc.product.dao.ProductJsonRepository;
import com.cts.mc.product.exception.ProductException;
import com.cts.mc.product.model.Product;

@Service
public class ProductService implements IProductService{
@Autowired
ProductJsonRepository productJsonRepository;
	@Override
	public Product addProduct(Product product) throws ProductException {
		productJsonRepository.readJson(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		productJsonRepository.readJson(product);
		return product;
	}

	@Override
	public Product deleteProduct(String productId) throws ProductException {
		productJsonRepository.deleteElementFromJson(productId);
		return null;
	}

	@Override
	public Product getProductById(String productId) throws ProductException {
		Product product = productJsonRepository.getProductById(productId);
		return  product;
	}

}
