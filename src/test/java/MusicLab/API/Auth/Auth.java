package MusicLab.API.Auth;

import MusicLab.Base;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class Auth extends Base {
    public static String LOGIN = BASE_URL + "login";
    public static String REGISTER = BASE_URL + "register";

    @Step("Auth")
    public void login(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Register")
    public void register(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
