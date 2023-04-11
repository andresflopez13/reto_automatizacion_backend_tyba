package co.com.tyba.reto.backend.stepdefinitions;

import co.com.tyba.reto.backend.tasks.AuthenticateIntoBackend;
import co.com.tyba.reto.backend.util.Generate;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.jupiter.api.extension.ExtendWith;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.StringContains.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class AuthenticationDefinition {

    public static EnvironmentVariables environmentVariables;

    @Before
    public void setStage() {
        setTheStage(Cast.whereEveryoneCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl"))));
    }

    @Dado("que {string} desea loguearse en restful-booker")
    public void theUserWantsTologinToTybaBackEnd(String name) {
        theActorCalled(name).entersTheScene();
    }

    @Cuando("ingresa el email y contrasenia correcta")
    public void enterTheEmailAndCorrectPassword() {
        theActorInTheSpotlight().attemptsTo(AuthenticateIntoBackend.withCredentials(
                Generate.userForSuccessfulAuthentication(
                        environmentVariables.getProperty("restapi.username"),
                        environmentVariables.getProperty("restapi.password"))));
    }

    @Entonces("verifica que el usuario se autentica correctamente")
    public void verifiesThatTheUserIsAuthenticatedCorrectly() {
        theActorInTheSpotlight().should(seeThatResponse("Status code is 200 - OK",
                response -> response.statusCode(200)
                        .body(containsString("token"))));
    }

    @Cuando("ingresa el email y contrasenia incorrecta")
    public void enterTheWrongEmailAndPassword() {
        theActorInTheSpotlight().attemptsTo(AuthenticateIntoBackend.withCredentials(
                Generate.userForFailAuthentication()));
    }

    @Entonces("verifica que el usuario no se autentica correctamente")
    public void verifiesThatTheUserIsNotAuthenticatedCorrectly() {
        theActorInTheSpotlight().should(seeThatResponse(
                response -> response.statusCode(200).
                        body(containsString("Bad credentials"))));
    }
}
