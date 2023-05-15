package day03;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class CookiesDemo {

    @Test(priority = 1)
    public void testCookies(){

        given()
                .when()
                .get("https://www.google.com/")

                .then()
                .cookie("AEC","ARSKqsLWiK0Pq0164jpPawUDicy5mAN8nwxNFSXzKceYFnsRpeFRxgMSsrw")
                .log().all();
    }
    @Test
    public void getCookies(){
      Response res = given()
                .when()
                .get("https://www.google.com/");

      //single cookies info
       //String cookies_values = res.getCookie("AEC");
      // System.out.println("value of cookies is >>>>>"+cookies_values);

      //get all cookies info
        Map<String,String> cookies_Values = res.getCookies();
        //System.out.println(cookies_Values.keySet());

        for(String k:cookies_Values.keySet()){
            String cookie_Values = res.getCookie(k);
            System.out.println(k+"     "+cookie_Values);

        }
    }

}
