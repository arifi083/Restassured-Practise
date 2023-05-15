package day06;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonSchemaValidation {
    @Test
    public void schemaValidation(){
        given()
                .when()
                .get(" http://localhost:3000/book")

                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storejsonSchema.json"));
    }
}
