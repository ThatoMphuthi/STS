package API;

import org.testng.annotations.Test;

public class Controller {

    @Test(priority = 1, description = "Testing POST Order API")
    public void testPOST(){
        System.out.println("Test Case : Test POST Order API");
        Service.POST();
    }

    @Test(priority = 2, description = "Testing Get Order API")
    public void testGet(){
        System.out.println("Test Case : Test Get Order API");
        Service.GET2();
    }
}
