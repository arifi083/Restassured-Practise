package day08;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUser {
    @Test
    public void test_GetUser(ITestContext context){

        System.out.println(context.getAttribute("user_id"));
        int id = (int) context.getAttribute("user_id");  //this id is come from createUser request

        String bearerToken ="9dc88dac4d818ab1b515bb6f3f6cd28c5ee0e0dffa16546c41918d4b6db4bba5";

        given()
                .headers("Authorization","Bearer "+bearerToken)
                .pathParam("id",id)


                .when()
                .get("https://gorest.co.in/public/v2/users/{id}")

                .then()
                .statusCode(200)
                .log().all();



    }
}
