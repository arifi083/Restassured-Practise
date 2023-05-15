package day08;

import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser {
    @Test
    public void test_createUser(ITestContext context){

        Faker faker = new Faker();
        JSONObject data = new JSONObject();

        data.put("name",faker.name().fullName());
        data.put("gender","Male");
        data.put("email",faker.internet().emailAddress());
        data.put("status","inactive");


        String bearerToken ="9dc88dac4d818ab1b515bb6f3f6cd28c5ee0e0dffa16546c41918d4b6db4bba5";


       int id = given()
                .headers("Authorization","Bearer "+bearerToken)
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://gorest.co.in/public/v2/users")
               .jsonPath().getInt("id");

        System.out.println("generate id:"+" "+ id);

        context.setAttribute("user_id",id);
        System.out.println(context.getAttribute("user_id"));


    }





}
