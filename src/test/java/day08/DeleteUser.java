package day08;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    @Test
    public void test_DeleteUser(ITestContext context){

        int id = (int) context.getAttribute("user_id");
        String bearerToken ="9dc88dac4d818ab1b515bb6f3f6cd28c5ee0e0dffa16546c41918d4b6db4bba5";

        given()
                .headers("Authorization","Bearer "+bearerToken)
                .pathParam("id",id)


                .when()
                .delete("https://gorest.co.in/public/v2/users/{id}")

                .then()
                .statusCode(204)
                .log().all();



    }
}
