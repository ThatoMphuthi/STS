package API;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class Service {

    public static int id;

    public static void GET2(){
        String requestURL = "https://petstore.swagger.io/v2/store/order/"+id;

        //Send request
        Response response = given()
                .contentType("Application/json")
                .get(requestURL);

        //Initialize response objects
        String responseBody = response.getBody().asPrettyString();
        String headers = response.getHeaders().toString();
        int statusCode = response.getStatusCode();

        System.out.println("Response Headers : \n" + headers);
        System.out.println("Response Body : \n" + responseBody);
        System.out.println("Status Code : \n" + statusCode);

        assertAPI(statusCode);
    }

    public static void POST(){
        String requestURL = "https://petstore.swagger.io/v2/store/order";

        String body = "{\"id\":3,\"petId\":0,\"quantity\":0,\"shipDate\":\"2023-02-22T11:47:31.369Z\",\"status\":\"placed\",\"complete\":true}";



        Response response = given()
                .contentType("Application/json")
                .body(body)
                .post(requestURL);

        JsonPath jsonPathEvaluator = response.jsonPath();

        String responseBody = response.getBody().asPrettyString();
        String headers = response.getHeaders().toString();
        int statusCode = response.getStatusCode();

        System.out.println("Response Headers : \n" + headers);
        System.out.println("Response Body : \n" + responseBody);
        System.out.println("Status Code : \n" + statusCode);

        assertAPI(statusCode);

        id = jsonPathEvaluator.getInt("id");

    }


    public static void assertAPI(int statusCode){
        if(statusCode >=200 && statusCode <= 299){
            System.out.println("Passed");
            assertTrue(true);
        }else {
            System.out.println("Failed");
            assertTrue(false);
        }
    }
}
