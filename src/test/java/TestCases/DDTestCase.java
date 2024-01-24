package TestCases;

import org.testng.annotations.Test;

import Endpoints.UserEndpoints;
import Payloads.user;
import Utilities.DataProviders;
import io.restassured.response.Response;

public class DDTestCase {
	@Test(priority=1, dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String UserID, String UserName, String FirstName, String LastName,String Email, String Passwor, String Phone) {
		user UserPayload=new user();
		UserPayload.setId(Integer.parseInt(UserID));
		UserPayload.setUsername(UserName);
		UserPayload.setFirstname(FirstName);
		UserPayload.setLastname(LastName);
		UserPayload.setEmail(Email);
		UserPayload.setPassword(Passwor);
		UserPayload.setPhone(Phone);
		
		Response response=UserEndpoints.createUser(UserPayload);
		response.then().log().all();
		
	}

}
