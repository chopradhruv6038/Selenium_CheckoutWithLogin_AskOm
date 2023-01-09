package Org.Practice.Selenium.Utils;

import org.apache.hc.client5.http.auth.InvalidCredentialsException;

import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigLoader { // This is the singleton class made to read the properties.
    //creating two variables:

    private final Properties properties; // we need this variable to load the properties over here.
private static ConfigLoader configLoader; //Very important, here we are creating a variable called configLoader
    //The type of above variable is ConfigLoader class.
    // The type of  variable can be the class as well apart from the string, integer and so on. Please note it.


    // Now we need to create a constructor for this class and the constructor will be private because we don't want any other class in this framework to create the instance of this class.
//Only this class should be able to create its own instance. THIS IS THE MAGIC OF THE SINGLETON DESIGN PATTERN. If the constructor is private it will not be accessible outside this class.

    // We can not create an instance of this class outside its own class, this is the logic behind the singleton design pattern.

    private ConfigLoader() throws FileNotFoundException {
        //inside the constructor we are going to load the properties.
// note: we could use the property Loader method directly because it is static


        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");

    }
// now we need to make an instance of config Loader class and access it, and also we need to make sure that we make only one instance because it is a singleton class.

    // we will create a method which will be public and that method should provide an instance of the ClassLoader class.

public static ConfigLoader getInstance() throws FileNotFoundException {

        // checking using if, the variable configLoader is null (There is no instance of the class already) then create an instance of ConfigLoader class.

if (configLoader == null){
    configLoader = new ConfigLoader(); // assigning the new instance to the configLoader variable.
    //note: when getInstance method is called again for the second time the config loader will not be null anymore because it has got a value (Instance of the class.) since it is static, it will return that value.
}

return configLoader;
}

// creating method to read the base url.
    //for each config property we can create a method and then we will access the method in our test class.

public String getBaseUrl(){

        String prop = properties.getProperty("baseUrl");

        if(prop != null) return prop;
        else throw new RuntimeException("Properties base url is not specified in the config.properties file");
    }


    public String getUsername()  {


            String prop = properties.getProperty("username");


            if (prop != null)
                return prop;
            else throw new RuntimeException("Properties username is not specified in the config.properties file");

        }



    public String getPassword() {

        String prop = properties.getProperty("password");

        if(prop != null) return prop;
        else throw new RuntimeException("Properties password is not specified in the config.properties file");
    }
}

