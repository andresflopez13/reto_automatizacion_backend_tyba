package co.com.tyba.reto.backend.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/authentication.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "co.com.tyba.reto.backend.stepdefinitions")
public class Authentication {

}
