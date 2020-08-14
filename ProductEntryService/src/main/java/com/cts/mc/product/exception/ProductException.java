package com.cts.mc.product.exception;

public class ProductException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  ProductException() {
        super();
    }
    public  ProductException(String message, Throwable cause) {
        super(message, cause);
    }
    public ProductException(String message) {
        super(message);
    }
    public ProductException(Throwable cause) {
        super(cause);
    }

}
