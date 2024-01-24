package Endpoints;

import Payloads.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class UserEndpoints {
	public static Response createUser(user payload){
		Response response=given()
	    .contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Roots.post_url);
		return response;
	}
	
	public static Response readUser(String username) {
		Response response=  given()
		.pathParam("username", username)
		.when()
		.get(Roots.get_url);
		return response;
	}
	public static Response UpdateUser(String username, user payload) {
		Response response=  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				.when()
				.put(Roots.put_url);
				return response;
	}
	public static Response deleteUser(String username) {
		Response response= given()
				.pathParam("username", username)
				
				.when()
				.delete(Roots.delete_url);
		return response;
		
	}

}
