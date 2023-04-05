package MusicLab.StepDefinitions.Auth;

import MusicLab.API.Auth.Auth;
import MusicLab.utilities.API_Responses;
import MusicLab.utilities.Auth.JsonSchemaAuth;
import MusicLab.utilities.Auth.ReqBodyAuth;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginMentorSteps {

    @Steps
    Auth auth;

    @Given("Mentor auth with valid json")
    public void mentorLoginWithValidJson() {
        File json = new File(ReqBodyAuth.MENTOR);
        auth.login(json);
    }

    @When("Send request post auth")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(Auth.LOGIN);
    }

    @Then("Status code should {int} OK auth")
    public void statusCodeShouldOK(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("Response body should be {string} as message")
    public void responseBodyShouldBeAsMessage(String message) {
        SerenityRest.then().body(API_Responses.message, equalTo(message));
    }

    @And("Validate auth json schema")
    public void validateLoginJsonSchema() {
        File json = new File(JsonSchemaAuth.MESSAGE);
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


//    Invalid auth
    @Given("Mentor auth with invalid json")
    public void mentorLoginWithInvalidJson() {
        File json = new File(ReqBodyAuth.MENTOR_INVALID);
        auth.login(json);
    }

    @Then("Status code should {int} Bad Request auth")
    public void statusCodeShouldBadRequest(int code) {
        SerenityRest.then().statusCode(code);
    }


//    Blank auth
    @Given("Mentor auth with blank json")
    public void mentorLoginWithBlankJson() {
        File json = new File(ReqBodyAuth.MENTOR_BLANK);
        auth.login(json);
    }
}
