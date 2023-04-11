package co.com.tyba.reto.backend.tasks;

import co.com.tyba.reto.backend.model.UserAuthentication;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class AuthenticateIntoBackend implements Task {

    private UserAuthentication credentials;
    public static EnvironmentVariables environmentVariables;

    public AuthenticateIntoBackend(UserAuthentication credentials) {
        this.credentials = credentials;
    }
    @Step("{0} ingresa los datos en el body del servicio y realiza la petición")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(environmentVariables.getProperty("restapi.path_auth"))
                .with(request -> request.contentType(ContentType.JSON)
                        .body(credentials)));
    }

    public static AuthenticateIntoBackend withCredentials(UserAuthentication credentials) {
        return Tasks.instrumented(AuthenticateIntoBackend.class, credentials);
    }
}
