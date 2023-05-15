package day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJsonResponseData {
    @Test(priority = 1)
    public void testJsonResponse(){

        //Approach 1  result ase nai

//        given()
//                .contentType(ContentType.JSON)
//                //.contentType(ContentType.JSON)
//
//                .when()
//                .get("http://localhost:3000/book")
//
//
//                .then()
//                .statusCode(200)
//                .header("Content-Type","application/json; charset=utf-8")
//                //.log().all();
//                .body("book[0].category",equalTo("novel"));


        //Approach 2 result ase nai

//        Response res = given()
//                .contentType("ContentType.JSON")
//
//                .when()
//                .get(" http://localhost:3000/students");
//
//        Assert.assertEquals(res.getStatusCode(),200);
//        Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
//        String courseName = res.jsonPath().get("students[0].name").toString();
//        System.out.println(courseName);
//        Assert.assertEquals(courseName,"arif");





//        //approach 3 result ase right
//        given()
//                .contentType("ContentType.JSON")
//
//                .when()
//                .get("https://reqres.in/api/users?page=2")
//
//                .then()
//                .statusCode(200)
//                .header("Content-Type","application/json; charset=utf-8")
//                .body("data.id[0]", Matchers.equalTo(7)).
//                log().all();





        //Approach 4 result ase

//        Response res = given()
//                .contentType("ContentType.JSON")
//
//                .when()
//                .get("https://reqres.in/api/users?page=2");
//
//        Assert.assertEquals(res.getStatusCode(),200);
//        Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
//        String firstName = res.jsonPath().get("data[0].first_name").toString();
//        System.out.println(firstName);
//        Assert.assertEquals(firstName,"Michael");


    }
    @Test(priority = 2)
    public void testJsonResponseBodyData(){
       Response res = given()
                .contentType(ContentType.JSON)

                .when()
                .get("http://localhost:3000/book");


        JSONObject jsonData = new JSONObject(res.toString());  //convert response to json Object

        boolean status = false;
        for(int i=0;i<jsonData.getJSONArray("book").length();i++){
            String bookTitle = jsonData.getJSONArray("book").getJSONObject(i).get("title").toString();
            //System.out.println(bookTitle);
            if(bookTitle.equals("love yourserlf")){
                status = true;
                break;
            }
        }
        Assert.assertEquals(status,true);


        double totalPrice = 0;
        for(int i=0;i<jsonData.getJSONArray("book").length();i++){
            String price = jsonData.getJSONArray("book").getJSONObject(i).get("price").toString();
            totalPrice = totalPrice + Double.parseDouble(price);

        }
        System.out.println("total price of books is" + totalPrice);






    }
}
