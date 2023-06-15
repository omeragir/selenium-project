package com.cydeo.tests.day08_webTables_properties_configReader;

import org.testng.annotations.Test;

public class LearningProperties {

    //Java is tracking some information about our computer,our project,and username etc.
    //Let`s print them out
    @Test
    //key=value
    //we pass the key,it will return the value.
    public void java_properties_reading_test(){
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    }

}
