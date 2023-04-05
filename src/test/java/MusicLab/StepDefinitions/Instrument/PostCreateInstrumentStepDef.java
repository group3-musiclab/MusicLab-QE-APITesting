package MusicLab.StepDefinitions.Instrument;

import MusicLab.API.Instrument.InstrumentAPI;
import MusicLab.utilities.API_Responses;
import MusicLab.utilities.Instrument.JsonSchemaInstrument;
import MusicLab.utilities.Instrument.ReqBodyInstrument;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostCreateInstrumentStepDef {

    @Steps
    InstrumentAPI instrumentAPI;

    @Given("Post create mentor instrument with valid JSON")
    public void postCreateMentorInstrumentWithValidJson() {
        File jsonReq = new File(ReqBodyInstrument.REQ_BODY + "ValidPostCreateInstrumenJsonReqBody.json");
        instrumentAPI.setPostMentorsInstrument(jsonReq);
    }

    @Given("Post create mentor instrument with invalid JSON")
    public void postCreateMentorInstrumentWithInvalidJson() {
        File jsonReq = new File(ReqBodyInstrument.REQ_BODY + "InvalidPostCreateInstrumenJsonReqBody.json");
        instrumentAPI.setPostCreateInstrumentInvalidJSON(jsonReq);
    }

    @Given("Post create mentor instrument with valid JSON no Auth")
    public void postCreateMentorInstrumentWithValidJsonNoAuth() {
        File jsonReq = new File(ReqBodyInstrument.REQ_BODY + "ValidPostCreateInstrumenJsonReqBody.json");
        instrumentAPI.setPostCreateInstrumentNoAuth(jsonReq);
    }

    @When("Send post create mentor instrument")
    public void sendPostCreateInstrument() {
        SerenityRest.when().post(InstrumentAPI.POST_MENTORS_INSTRUMENT);
    }

    @Then("Status code should be {int} Create -Mentors_Instruments")
    public void statusCodeShouldBeCreate(int create) {
        SerenityRest.then().statusCode(create);
    }

    @Then("Status code should be {int} Unauthorized -Mentors_Instruments")
    public void statusCodeShouldBeUnauthorized(int auth) {
        SerenityRest.then().statusCode(auth);
    }

    @And("Response should be {string} -Mentors_Instruments")
    public void responsBodyShouldBeBody(String body) {
        SerenityRest.then()
                .body(API_Responses.BODY_MESSAGE,equalTo(body));
    }

    @And("Validate post create instrument resources json schema")
    public void validatePostCreateInstrumentResourcesJsonSchema() {
        File jsonSchema = new File(JsonSchemaInstrument.SCHEMA +"PostCreateInstrumentJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
