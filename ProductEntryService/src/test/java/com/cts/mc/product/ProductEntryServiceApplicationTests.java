package com.cts.mc.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cts.mc.product.model.Product;


@SpringBootTest
class ProductEntryServiceApplicationTests {

	@ExtendWith(SpringExtension.class)
	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	class ApplyLoanApplicationTests {


		@Autowired
		private TestRestTemplate restTemplate;

		@Test
		@DisplayName("test Message REST API ")
		void testMessage() {
			    	Product product = new Product();
			    	product.setProductId("123345");
			    	product.setProductName("TV");
			    	product.setPrice(10000.0);
			    	product.setOffer(5.0);
			    	product.setStock(20);
			
			    	Product  products = this.restTemplate.postForObject("/product/add/{product}",product, Product.class);
				//System.out.println("@@@@:"+message.getCustomerId());
			assertEquals(product, product);
		}
	}

}
