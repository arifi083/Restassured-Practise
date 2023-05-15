package day03;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoggingDemo {
    @Test
    public void testLog(){
        given()

                .when()
                .get("https://reqres.in/api/users?page=2")


                .then()
                //.log().all();
                //.log().body();
                //.log().cookies();
                .log().headers();
    }
}
