package MusicLab.StepDefinitions.Auth;

import MusicLab.API.Auth.Auth;
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

public class RegisterMentorSteps {

    @Steps
    Auth auth;

    @Given("Mentor register with valid json")
    public void mentorRegisterWithValidJson() {
        File json = new File(ReqBodyAuth.REGIS_MENTOR);
        auth.login(json);
    }

    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(Auth.REGISTER);
    }

    @Then("Status code should {int} Created auth")
    public void statusCodeShouldCreated(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("Validate register json schema")
    public void validateRegisterJsonSchema() {
        File json = new File(JsonSchemaAuth.MESSAGE);
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Existing regis email
    @Then("Status code should {int} Internal Server Error auth")
    public void statusCodeShouldInternalServerError(int code) {
        SerenityRest.then().statusCode(code);
    }

//    Invalid
    @Given("Mentor register with invalid json")
    public void mentorRegisterWithInvalidJson() {
        File json = new File(ReqBodyAuth.REGIS_MENTOR_INVALID);
        auth.login(json);
    }

//    Blank
    @Given("Mentor register with blank json")
    public void mentorRegisterWithBlankJson() {
        File json = new File(ReqBodyAuth.REGIS_MENTOR_BLANK);
        auth.login(json);
    }
}
