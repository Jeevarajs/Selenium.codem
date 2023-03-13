package stepDefinions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Addplace;
import pojo.Location;
import resources.Apiresourcess;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefination extends Utils {
	 ResponseSpecification resspec;
	 RequestSpecification res;
	 TestDataBuild data=new TestDataBuild();
	 Response response;
		static String place_id;
	 

@Given("Add Place Payload with {string}  {string} {string}")
public void add_place_payload_with(String name, String language, String address) throws IOException {
    // Write code here that turns the phrase above into concrete actions
         resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
				  res=given().spec(requestSpecification())
				 .body(data.addPlace(name, language, address));
	}
@When("user calls {string} with {string} http request")
public void user_calls_with_http_request(String resource, String method) {
		
	    // Write code here that turns the phrase above into concrete actions
		
		Apiresourcess resourceAPI=Apiresourcess.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		 resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 
		 if(method.equalsIgnoreCase("POST"))
			 response =res.when().post(resourceAPI.getResource());
			else if(method.equalsIgnoreCase("GET"))
				 response =res.when().get(resourceAPI.getResource());
			
	}
				
		 
	
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions

		assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions

		assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws IOException {
	
	   // requestSpec
	     place_id=getJsonPath(response,"place_id");
		 res=given().spec(requestSpecification()).queryParam("place_id",place_id);
		 user_calls_with_http_request(resource,"GET");
		  String actualName=getJsonPath(response,"name");
		  assertEquals(actualName,expectedName);
		 
	    
	}
	
	@Given("DeletePlace Payload")
	public void deleteplace_Payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   
		res =given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
	
}
