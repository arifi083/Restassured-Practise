package day06;

import Day02.Pojo_Post_Request;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class SerilaizationDeserilaization {

    @Test
    public void pojoToJson() throws JsonProcessingException {

        //created java object using pojo class

        Student stupojo = new Student();
        stupojo.setName("Mim");
        stupojo.setLocation("Hobigong");
        stupojo.setPhone("01733717060");

        String courseArr[] ={"restAssured","postman"};
        stupojo.setCourse(courseArr);

        //convert java object to/pojo -------json object (serilaization)
        ObjectMapper objmap = new ObjectMapper();
       String jsonData = objmap.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
        System.out.println(jsonData);

    }



    // json to pojo -----deserialization
    @Test
    public void jsonToPojo() throws JsonProcessingException {

        String jsonData = "{\n" +
                "  \"name\" : \"Mim\",\n" +
                "  \"location\" : \"Hobigong\",\n" +
                "  \"phone\" : \"01733717060\",\n" +
                "  \"course\" : [ \"restAssured\", \"postman\" ]\n" +
                "}";


        //convert json to pojo object
        ObjectMapper objmapper = new ObjectMapper();

       Student stupojo = objmapper.readValue(jsonData,Student.class);

        System.out.println("Name"+ " "+stupojo.getName());
        System.out.println("Location"+" "+stupojo.getLocation());
        System.out.println("Phone"+" "+stupojo.getPhone());
        System.out.println("course [1]"+" " +stupojo.getCourse()[0]);
        System.out.println("course [2]"+" "+stupojo.getCourse()[1]);


    }
}
