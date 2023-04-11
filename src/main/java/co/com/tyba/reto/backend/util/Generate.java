package co.com.tyba.reto.backend.util;

import co.com.tyba.reto.backend.model.UserAuthentication;
import com.github.javafaker.Faker;

import java.util.Locale;


public class Generate {
    private static Faker faker = new Faker(new Locale("es"));

    public static UserAuthentication userForSuccessfulAuthentication(String email, String pass) {
        UserAuthentication userAuthentication = new UserAuthentication(email, pass);
        return userAuthentication;
    }

    public static UserAuthentication userForFailAuthentication() {
        UserAuthentication userAuthentication = new UserAuthentication(
                faker.internet().emailAddress(), faker.numerify("######"));
        return userAuthentication;
    }

    public static UserAuthentication userForFailPasswordlengthError() {
        UserAuthentication userAuthentication = new UserAuthentication(
                faker.internet().emailAddress(), faker.numerify("###"));
        return userAuthentication;
    }
}
