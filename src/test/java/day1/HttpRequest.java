package day1;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;


public class HttpRequest {

    int id;
    @Test(priority = 1)
    public void getUserList(){
        given()

                .when()
                .get("https://reqres.in/api/users?page=2")


                .then()
                .statusCode(200)
                .body("page",Matchers.equalTo(2))
                .log().all();
    }

    @Test(priority = 2)
    public void createUser(){

        Map<String,Object> data = new HashMap<String,Object>();
        data.put("name","arif");
        data.put("job","sqa");
        System.out.println(data);

       int id = given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");

    }


   @Test(priority = 3,dependsOnMethods = {"createUser"})
    public void updateUser(){
       Map<String,Object> data = new HashMap<String,Object>();
       data.put("name","atif");
       data.put("job","devops");
       System.out.println(data);

       given()
               .contentType("application/json")
               .body(data)

               .when()
               .put("https://reqres.in/api/users/"+id)

               .then()
               .statusCode(200)
               .log().all();

   }
    @Test(priority = 4)
    public void deleteUser(){
        given().
                when()
                .delete("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(204)
                .log().all();

    }

}
