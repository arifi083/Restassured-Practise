package Day02;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
 1. post request body using HasMap
 2. post request body using org.json
 3. post request body using POJO(Plain old java object)
 4. post request body using External json file

 */





public class MultiplePostRequest {

    // 1. post request body using HasMap


    //@Test(priority = 1)
    public void testPostUsingHasMap(){
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("name","Mim");
        data.put("location","Hobigong");
        data.put("phone","01733717060");

        String courseArr[] ={"restAssured","postman"};
        data.put("course",courseArr);
        System.out.println(data);



        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("http://localhost:3000/students")


                .then()
                .statusCode(201)
                .body("name",equalTo("Mim"))
                .body("location",equalTo("Hobigong"))
                .body("phone",equalTo("01733717060"))
               .body("course[0]",equalTo("restAssured"))
                .body("course[1]",equalTo("postman"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();


    }



    //2. post request body using org.json


   // @Test(priority = 1)
    public void testPostUsingJsonLibrary(){

        JSONObject data = new JSONObject();
        data.put("name","Mim");
        data.put("location","Hobigong");
        data.put("phone","01733717060");

        String courseArr[] ={"restAssured","postman"};
        data.put("course",courseArr);
        System.out.println(data);



        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("http://localhost:3000/students")


                .then()
                .statusCode(201)
                .body("name",equalTo("Mim"))
                .body("location",equalTo("Hobigong"))
                .body("phone",equalTo("01733717060"))
                .body("course[0]",equalTo("restAssured"))
                .body("course[1]",equalTo("postman"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();


    }




    //3. post request body using POJO(Plain old java object)


   // @Test(priority = 1)
    public void testPostUsingPOJO(){

      Pojo_Post_Request data = new Pojo_Post_Request();
      data.setName("Mim");
      data.setLocation("Hobigong");
      data.setPhone("01733717060");

      String courseArr[] ={"restAssured","postman"};
      data.setCourse(courseArr);



        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("http://localhost:3000/students")


                .then()
                .statusCode(201)
                .body("name",equalTo("Mim"))
                .body("location",equalTo("Hobigong"))
                .body("phone",equalTo("01733717060"))
                .body("course[0]",equalTo("restAssured"))
                .body("course[1]",equalTo("postman"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();


    }




    //4. post request body using External json file(body.json)

    @Test(priority = 1)
    public void testPostUsingExternalJsonFile() throws FileNotFoundException {

        File f = new File(".\\body.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);


        given()
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("http://localhost:3000/students")


                .then()
                .statusCode(201)
                .body("name",equalTo("Mim"))
                .body("location",equalTo("Hobigong"))
                .body("phone",equalTo("01733717060"))
                .body("course[0]",equalTo("restAssured"))
                .body("course[1]",equalTo("postman"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();


    }








    @Test(priority = 2)
    public void testDelete(){
        given().
                when()
                .delete("http://localhost:3000/students/5")

                .then()
                .statusCode(200);


    }


}
