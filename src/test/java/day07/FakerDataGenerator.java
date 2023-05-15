package day07;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

     @Test
    public void testGenerateDammyData(){

        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        String userName = faker.name().username();
        String password = faker.internet().password();
        String phoneNumber = faker.phoneNumber().cellPhone();
        String email = faker.internet().safeEmailAddress();

        System.out.println("Full name:"+fullName);
        System.out.println("First name:"+firstName);
        System.out.println("last name:"+lastName);
        System.out.println("user name:"+userName);
        System.out.println("Password:"+password);
        System.out.println("phone Number:"+phoneNumber);
        System.out.println("email:"+email);

    }
}
