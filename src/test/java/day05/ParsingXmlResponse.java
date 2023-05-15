package day05;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ParsingXmlResponse {
    @Test
    public void testXmlResponse(){
        //Approach 1

       /*
        given()
                .when()
                .get("http://restapi.adequateshop.com/api/Traveler")

                .then()
                .statusCode(200)
                .header("Content-Type","application/xml; charset=utf-8")
                .body("TravelerinformationResponse.page",equalTo("1"))
                .body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"))
                .log().all();


        */

        //approach 2

        Response res = given()
                                .when()
                                .get("http://restapi.adequateshop.com/api/Traveler");


        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
        String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
        Assert.assertEquals(pageNo,"1");

        String travelerName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
        Assert.assertEquals(travelerName,"Developer");

    }

    @Test
    public void testXmlResponseBody(){
        Response res = given()
                .when()
                .get("http://restapi.adequateshop.com/api/Traveler?page=1");


        XmlPath xmlObj = new XmlPath(res.asString());

        //verify total Number of travllers
        List<String> travllers = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
        Assert.assertEquals(travllers.size(),10);

        List<String> travllers_name = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");

        boolean status =false;

        for(String travllerName:travllers_name){
            //System.out.println(travllerName);
            if(travllerName.equals("Developer123")){
                status = true;
                break;
            }
        }

        Assert.assertEquals(status,true);


    }



}
