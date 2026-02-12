package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.CreateAccountRequest;

import java.util.Map;

public class TestDataFactory {

    public static String uniqueEmail() {
        return "user" + System.currentTimeMillis() + "@test.com";
    }

    public static CreateAccountRequest newUser(String email, String password) {
        CreateAccountRequest r = new CreateAccountRequest();
        r.name = "proeqti";
        r.email = email;
        r.password = password;
        r.title = "Miss";
        r.birth_date = "10";
        r.birth_month = "May";
        r.birth_year = "2002";
        r.firstname = "finaluri";
        r.lastname = "proeqti";
        r.company = "IBSU";
        r.address1 = "Tbilisi";
        r.address2 = "Georgia";
        r.country = "India";
        r.zipcode = "0100";
        r.state = "Tbilisi";
        r.city = "Tbilisi";
        r.mobile_number = "555123123";
        return r;
    }

    public static Map<String, String> toFormParams(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(obj, new TypeReference<Map<String, String>>() {});
    }
}
