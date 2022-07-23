package com.ecom.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    //Read the Properties file in resource
    //readItem("url")
    //readItem("browser")

    static Properties properties;

    public PropertyReader(){
        loadAllProperties();
    }

    //load the file from the resource
    public void loadAllProperties(){
        properties = new Properties();

        //read the file prod.config
        try {
            //make this function with params
            String filename = System.getProperty("user.dir")+"/src/main/resources/prod_config.properties";
            properties.load(new FileInputStream(filename));

        }catch (IOException e){
            throw  new RuntimeException("Not able to find the file");

        }
    }
    public static String readItem(String propertyName){
        return properties.getProperty(propertyName);
    }
}
