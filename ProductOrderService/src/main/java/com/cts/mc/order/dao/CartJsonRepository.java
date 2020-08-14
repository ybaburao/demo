package com.cts.mc.order.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cts.mc.order.exception.OrderException;
import com.cts.mc.order.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class CartJsonRepository {
	static Logger log = Logger.getLogger(CartJsonRepository.class.getName());
	// get Product by productId
	ObjectMapper mapper = new ObjectMapper();

	public Product getProductById(int productId) throws OrderException {
		Product orderedProduct = null;
		log.debug(" get product by productId");

		CopyOnWriteArrayList<Product> existingProducts = new CopyOnWriteArrayList<>();
		InputStream input;
		try {
			input = new FileInputStream("D:\\313474\\ProductEntryService\\src\\main\\resources\\Product.json");
			if (input.available() == 0) {
				log.debug(" Json file is empty----writing first object");
			} else {
				log.debug("Json file is not empty ");
				List<Product> productList = Arrays.asList(mapper.readValue(input, Product[].class));

				existingProducts = new CopyOnWriteArrayList<>(productList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new OrderException(
					"Exception occured whlile storing the Product in Product.json for the productId : " + productId);
		}
		

		// deletion logic
		Iterator<Product> existingProductsIterator = existingProducts.iterator();

		while (existingProductsIterator.hasNext()) {
			Product product = (Product) existingProductsIterator.next();
			if (product.getProductId() == (productId)) {
				orderedProduct = product;

			}

		}

		return orderedProduct;
	}

	public void writeJson(Product product) throws OrderException {
		try {
			mapper.writeValue(new FileOutputStream("D:\\313474\\OnlineOrderProcessing\\ProductOrderService\\src\\main\\resources\\CartData.json"),
					product);
		} catch (Exception e) {
			throw new OrderException("Exception occured whlile adding the products to the cart");
		}
	}
	// list the products from cart

	public List<Product> getProductFromCart() throws OrderException {

		List<Product> cartList = null;

		InputStream input;
		try {
			input = new FileInputStream("D:\\313474\\OnlineOrderProcessing\\ProductEntryService\\src\\main\\resources\\Product.json");
			if (input.available() == 0) {
				log.debug(" Json file is empty----writing first object");
			} else {
				log.debug("Json file is not empty ");
				cartList = Arrays.asList(mapper.readValue(input, Product[].class));

			}
		} catch (Exception e) {
			throw new OrderException("Exception occured whlile fetching the products from cart");
		}
		
		return cartList;
	}

}
