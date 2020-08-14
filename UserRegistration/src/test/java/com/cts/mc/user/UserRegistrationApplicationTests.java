package com.cts.mc.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cts.mc.user.model.User;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	@ExtendWith(SpringExtension.class)
	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	class ApplyLoanApplicationTests {


		@Autowired
		private TestRestTemplate restTemplate;

		@Test
		@DisplayName("test Message REST API ")
		void testMessage() {
			    	User user = new User();
			    	user.setUserId("12345");
			    	user.setFirstName("raj");
			    	user.setLastName("ram");
			    	user.setDob("08-08-2020");
			    	user.setEmail("sample.mail@gmail.com");
			
		 User  users = this.restTemplate.postForObject("/loanservice/applyloan",user, User.class);
				//System.out.println("@@@@:"+message.getCustomerId());
			assertEquals(user, users);
		}
	}
}