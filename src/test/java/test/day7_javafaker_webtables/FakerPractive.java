package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerPractive {

    @Test
    public void faker_test(){
        Faker faker = new Faker();

        String name = faker.name().fullName(); // Miss Samanta Schmidt
        System.out.println("name = " + name);
        String firstName = faker.name().firstName(); // Emory
        System.out.println("faker = " + faker);
        String lastName = faker.name().lastName(); // Barton
        System.out.println("lastName = " + lastName);

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
        System.out.println("streetAddress = " + streetAddress);






    }
}
