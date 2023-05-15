package day03;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class HeadersDemo {
    @Test(priority = 1)
    public void testHeadersDemo(){
        given()
                .when()
                .get("https://www.google.com/")

                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding","gzip")
                .and()
                .header("Server","gws")
                .log().all();


    }

   @Test(priority = 2)
    public void getHeaders(){

      Response res = given()
                .when()
                .get("https://www.google.com/");

      //get single header
       //String headerValue = res.getHeader("Content-Type");
       //System.out.println("The value of content type value is" +headerValue);

       //get all the headers
      Headers myheaders = res.getHeaders();
      for(Header hd:myheaders){
          System.out.println(hd.getName() +"    "+hd.getValue());
      }


    }
}
