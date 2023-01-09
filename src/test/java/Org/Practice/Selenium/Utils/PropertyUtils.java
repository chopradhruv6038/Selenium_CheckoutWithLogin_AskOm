package Org.Practice.Selenium.Utils;

import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils { // This class is made to load the properties.

//this method takes filePath as the argument and it will return the properties object which is from the java util package.
public static
Properties propertyLoader(String filePath) throws FileNotFoundException {

        Properties properties = new Properties(); // creating a new instance of the properties class.

        BufferedReader reader; // creating a buffered reader object to read the file.

        try{

            reader = new BufferedReader(new FileReader(filePath));

            try{

                //using the properties object and the load method and passing the reader to the load method. it is done to load the properties.
                properties.load(reader);
                reader.close(); // closing the reader and then handling the IO Exception.
            }catch (IOException e) {
                e.printStackTrace(); // just in case if there is any failure while loading the properties file we are going to raise the exception.
                throw  new RuntimeException("failed to load properties file :" + filePath);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
            throw new FileNotFoundException("properties file not found at : " + filePath);

        }
        return properties;
    }





























}
