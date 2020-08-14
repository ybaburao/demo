package com.cts.mc.order.service;

import java.util.List;

import com.cts.mc.order.exception.OrderException;
import com.cts.mc.order.model.Product;

public interface IOrderProductService {
	public Product addProductToCart(int productId)throws OrderException;
	public List<Product> listCartProducts()throws OrderException;
	public String checkoutOrders(int productId)throws OrderException ;

}
