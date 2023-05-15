package day06;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class XmlSchemaValidator {
    @Test
    public void xmlSchemaValidation(){
        given()
                .when()
                .get("http://restapi.adequateshop.com/api/Traveler")

                .then()
                .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveller.xsd"));
    }
}
