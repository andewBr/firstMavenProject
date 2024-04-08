package org.example;

import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            prop.load(PropertiesFile.class.getClassLoader().getResourceAsStream("prod.properties"));

            //get the property value and print it out
            System.out.println(prop.getProperty("filePath"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}