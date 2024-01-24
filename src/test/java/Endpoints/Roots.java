package Endpoints;

/*
Create user(post):https://petstore.swagger.io/v2/user
GetUser(Get):https://petstore.swagger.io/v2/user/{username}
Update User(Put):https://petstore.swagger.io/v2/user/{username}
Delete User (Delete): https://petstore.swagger.io/v2/user/{username}

*/

public class Roots {
	public static String base_url= "https://petstore.swagger.io/v2";
	
	//User Model
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//Need to create store module endponts
	//Need to crate pet modul endpoints
	
	

}
