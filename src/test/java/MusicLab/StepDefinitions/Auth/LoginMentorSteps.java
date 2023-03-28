package MusicLab.StepDefinitions.Auth;

import MusicLab.API.Auth.LoginMentor;
import MusicLab.Base;
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
    LoginMentor loginMentor;

    @Given("Mentor login with valid json")
    public void mentorLoginWithValidJson() {
        File json = new File(ReqBodyAuth.MENTOR);
        loginMentor.login(json);
    }

    @When("Send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(LoginMentor.LOGIN);
    }

    @Then("Status code should {int} OK")
    public void statusCodeShouldOK(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("Response body should be {string} as message")
    public void responseBodyShouldBeAsMessage(String message) {
        SerenityRest.then().body(API_Responses.message, equalTo(message));
    }

    @And("Validate login json schema")
    public void validateLoginJsonSchema() {
        File json = new File(JsonSchemaAuth.MESSAGE);
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
