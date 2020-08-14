package com.cts.mc.product.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cts.mc.product.exception.ProductException;
import com.cts.mc.product.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ProductJsonRepository {
	static Logger log = Logger.getLogger(ProductJsonRepository.class.getName());
	ObjectMapper mapper = new ObjectMapper();

	// read json ---get UserDetail
	public void readJson(Product product) throws ProductException {

		log.debug(" readJson method start");

		ArrayList<Product> existingProduct = null;
		InputStream input;
		try {
			input = new FileInputStream("D:\\313474\\OnlineOrderProcessing\\ProductEntryService\\src\\main\\resources\\Product.json");
			if (input.available() == 0) {
				log.debug(" Json file is empty----writing first object");
				writeJson(Arrays.asList(product));
			} else {
				log.debug("Json file is not empty ");
				List<Product> usersList = Arrays.asList(mapper.readValue(input, Product[].class));

				existingProduct = new ArrayList<>(usersList);
				updateJson(existingProduct, product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ProductException(
					"Exception occured whlile storing the Product in Product.json for the productId : "
							+ product.getProductId());
		}
		
	}

	// write json ---insert User

	public void writeJson(List<Product> product) throws ProductException {
		try {
			mapper.writeValue(new FileOutputStream("D:\\313474\\OnlineOrderProcessing\\ProductEntryService\\src\\main\\resources\\Product.json"),
					product);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ProductException("Exception occured whlile storing the Product in Product.json");
		}
	}

	// write json ---update iser
	public void updateJson(ArrayList<Product> existingProducts, Product newProduct) throws ProductException {
		log.debug("UpdateJson method......");
		int initialSize = existingProducts.size();
		log.debug(" Existing Json objects count " + initialSize);

		boolean[] flag = { true };
		flag[0] = false;

		if (existingProducts.size() == 0) {
			log.debug("Json file is empty duplicate");
			existingProducts.add(newProduct);
		} else {

			log.debug(" update json method else block ");
			existingProducts.forEach(existingProduct -> {
				if (existingProduct.getProductId().equals(newProduct.getProductId())) {
					log.debug(" User already exists so updating it ");
					existingProduct.setProductName(newProduct.getProductName());
					existingProduct.setPrice(newProduct.getPrice());
					existingProduct.setPrice(newProduct.getPrice());
					existingProduct.setStock(newProduct.getStock());
					existingProduct.setOffer(newProduct.getOffer());
					flag[0] = true;
				}

			});

			log.debug(" flage is " + flag[0]);
			if (flag[0] == false) {
				log.debug("object doesn't exists in json adding it to json ");
				existingProducts.addAll(Arrays.asList(newProduct));
			}
		}

		try {
			mapper.writeValue(new FileOutputStream("D:\\313474\\OnlineOrderProcessing\\ProductEntryService\\src\\main\\resources\\Product.json"),
					existingProducts);
		} catch (Exception e) {
			throw new ProductException(
					"Exception occured whlile updating the Product in Product.json for the productId : "
							+ newProduct.getProductId());
		}
	}

	// remove element from json

	public void deleteElementFromJson(String productId) throws ProductException {
		log.debug(" deleteElementFromJson method ");

		CopyOnWriteArrayList<Product> existingProducts = new CopyOnWriteArrayList<>();
		InputStream input;
		try {
			input = new FileInputStream("D:\\313474\\OnlineOrderProcessing\\ProductEntryService\\src\\main\\resources\\Product.json");
			if (input.available() == 0) {
				log.debug(" Json file is empty----writing first object");
			} else {
				log.debug("Json file is not empty ");
				List<Product> usersList = Arrays.asList(mapper.readValue(input, Product[].class));

				existingProducts = new CopyOnWriteArrayList<>(usersList);
			}
		} catch (Exception e) {
			throw new ProductException(
					"Exception occured whlile deleting the Product in Product.json for the productId : " + productId);
		}
		

		// deletion logic
		Iterator<Product> existingProductsIterator = existingProducts.iterator();

		while (existingProductsIterator.hasNext()) {
			Product product = (Product) existingProductsIterator.next();
			if (product.getProductId().equals(productId)) {
				existingProducts.remove(product);

			}

		}
		try {
			writeJson(existingProducts);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get Product by productId

	public Product getProductById(String productId) throws ProductException {
		Product orderedProduct = null;
		log.debug(" deleteElementFromJson method ");

		CopyOnWriteArrayList<Product> existingProducts = new CopyOnWriteArrayList<>();
		InputStream input;
		try {
			input = new FileInputStream("D:\\313474\\OnlineOrderProcessing\\ProductEntryService\\src\\main\\resources\\Product.json");
			if (input.available() == 0) {
				log.debug(" Json file is empty----writing first object");
			} else {
				log.debug("Json file is not empty ");
				List<Product> usersList = Arrays.asList(mapper.readValue(input, Product[].class));

				existingProducts = new CopyOnWriteArrayList<>(usersList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ProductException(
					"Exception occured whlile retriving the Product in Product.json for the productId : " + productId);
		}
		

		// deletion logic
		Iterator<Product> existingProductsIterator = existingProducts.iterator();

		while (existingProductsIterator.hasNext()) {
			Product product = (Product) existingProductsIterator.next();
			if (product.getProductId().equals(productId)) {
				orderedProduct = product;

			}

		}
		return orderedProduct;
	}

}
