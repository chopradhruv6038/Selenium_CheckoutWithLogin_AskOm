package Org.Practice.Selenium.Utils;

import Org.Practice.Selenium.Objects.BillingAddress;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {


    public static BillingAddress deserializeJson(InputStream is, BillingAddress billingAddress) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

       return objectMapper.readValue(is, billingAddress.getClass());
    }
/*
    public static Credentials deserializeJsonCredenials (InputStream yes, Credentials credentials) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(yes, credentials.getClass());

    }*/

}
