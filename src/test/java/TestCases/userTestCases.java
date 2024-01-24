package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Endpoints.UserEndpoints;
import Payloads.user;
import io.restassured.response.Response;

public class userTestCases {
	Faker faker;
	user Userpayload;
	
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		Userpayload=new user();
		Userpayload.setId(faker.idNumber().hashCode());
		  Userpayload.setUsername ( faker.name().username());
		  Userpayload.setFirstname(faker.name().firstName());
		  Userpayload.setLastname ( faker.name().lastName());
		  Userpayload.setEmail (faker.internet().safeEmailAddress());
		  Userpayload.setPassword(faker.internet().password(5, 10));
		  Userpayload.setPhone (faker.phoneNumber().cellPhone());
	       
	}
	@Test(priority=1)
	public void testPostUser() {
		Response response=UserEndpoints.createUser(Userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=2)
	public void testGetUserName() {
		Response response=UserEndpoints.readUser(this.Userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=3)
	public void updateUserDetails() {
		
		Userpayload.setFirstname(faker.name().firstName());
		  Userpayload.setLastname ( faker.name().lastName());
		  Userpayload.setEmail (faker.internet().safeEmailAddress());
	Response response=	UserEndpoints.UpdateUser(this.Userpayload.getUsername(), Userpayload);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	
	//Checking the data after update
	Response responseAfterUpdate=UserEndpoints.readUser(this.Userpayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void deleteUserDetails() {
		Response response=UserEndpoints.deleteUser(this.Userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	

}
