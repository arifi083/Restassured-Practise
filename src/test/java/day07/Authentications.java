package day07;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Authentications {

    @Test(priority = 1)
    public void testBasicAuthentications(){

        given()
                .auth().basic("postman","password")

                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    @Test(priority = 2)
    public void testDigestAuthentication(){
        given()
                .auth().digest("postman","password")

                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }

    @Test(priority = 3)
    public void testPreemtiveAuthentication(){
        given()
                .auth().preemptive().basic("postman","password")

                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }


    @Test(priority = 4)
    public void testBearerTokenAuthentication(){

        String bearerToken ="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";


        given()
                .headers("Authorization","Bearer "+bearerToken)

                .when()
                .get("https://api.github.com/user/repos")

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 5)
    public void testOAuthAuthentication(){

        given()
                .auth().oauth("consumerKey","ConsumerSecrat","accessToken","tokenSecrate")

                .when()
                .get("url")

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 6)
    public void testOAuth2Authentication(){

        given()
                .auth().oauth2("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")

                .when()
                .get("https://api.github.com/user/repos")

                .then()
                .statusCode(200)
                .log().all();
    }


}
