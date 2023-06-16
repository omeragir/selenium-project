package com.cydeo.tests.day09_javaFaker_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test(){
        //create Java Faker Object
        Faker faker=new Faker();

        //Print out a random first name using java faker object
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        //Print out a random last name using java faker object
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        //Print out a random full name using java faker object
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        //Print out a random city using java faker object
        System.out.println("faker.address().city() = " + faker.address().city());
        //Print out a random zipcode using java faker object
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());

        //Print out a random numerify() using java faker object
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("068-###-####"));
        //for credit card
        System.out.println("faker.numerify(\"####-####-####\") = " + faker.numerify("####-####-####"));

        //letterify() method is used to generate random letter with specific formatting
        System.out.println("faker.letterify(\"????-????-????\") = " + faker.letterify("????-????-????"));
        //bothify() method is used to generate random letter and digits  with specific formatting
        System.out.println("faker.numerify(\"#?#?-#?#?-#?#?\") = " + faker.bothify("#?#?-#?#?-#?#?"));

        //chuckNorris method is used to create chuckNorris fact
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.Muhtar().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris","Muhtar"));

    }
}
