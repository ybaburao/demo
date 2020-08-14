package com.cts.mc.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.mc.order.dao.CartJsonRepository;
import com.cts.mc.order.exception.OrderException;
import com.cts.mc.order.model.EmailMessage;
import com.cts.mc.order.model.Product;

@Service
public class OrderProductService implements IOrderProductService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CartJsonRepository cartJsonRepository;

	@Override

	public Product addProductToCart(int productId) throws OrderException {

		Product product = cartJsonRepository.getProductById(productId);
		cartJsonRepository.writeJson(product);
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public List<Product> listCartProducts() throws OrderException {
		// TODO Auto-generated method stub
		List<Product> cartProducts = cartJsonRepository.getProductFromCart();
		return cartProducts;
	}

	@Override
	public String checkoutOrders(int orderId) throws OrderException {
		List<Product> productList = listCartProducts();
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setTo_address("ybaburao@gmail.com");
		emailMessage.setOrderId("12345");
		emailMessage.setBody("Your order for the Order id: "+orderId+ " is confirmed");
		restTemplate.getForObject("https://emailconfirmationservice/email/send",EmailMessage.class,emailMessage);
		return "Your Order Confirmed";
	}
	

}
