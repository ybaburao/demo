package com.cts.mc.order.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mc.order.exception.OrderException;
import com.cts.mc.order.model.Product;
import com.cts.mc.order.service.OrderProductService;

@RestController
@RequestMapping("/OrderProduct")
public class OrderProductController {
	static Logger log = Logger.getLogger(OrderProductController.class.getName());
	
	@Autowired
	OrderProductService orderProductService;
	@PutMapping("/addToCart/{productId}")
	public Product addProductToCart(@PathVariable int productId) throws OrderException {
		log.debug("Adding product to cart "+productId);
		
		return orderProductService.addProductToCart(productId);
	}

	@GetMapping("/listCart")
	public List<Product> listCartProducts() throws OrderException {
		log.debug("fetching the products from cart ");
		return orderProductService.listCartProducts();
	}
	@GetMapping("/checkoutProducts/{orderId}")
	public String checkoutOrders(@PathVariable int orderId) throws OrderException{
		return orderProductService.checkoutOrders(orderId);
	}

}
