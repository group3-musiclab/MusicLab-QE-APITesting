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
        InstrumentAPI.setPostMentorsInstrument(jsonReq);
    }

    @Given("Post create mentor instrument with invalid JSON")
    public void postCreateMentorInstrumentWithInvalidJson() {
        File jsonReq = new File(ReqBodyInstrument.REQ_BODY + "InvalidPostCreateInstrumenJsonReqBody.json");
        InstrumentAPI.setPostCreateInstrumentInvalidJSON(jsonReq);
    }

    @Given("Post create mentor instrument with valid JSON no Auth")
    public void postCreateMentorInstrumentWithValidJsonNoAuth() {
        File jsonReq = new File(ReqBodyInstrument.REQ_BODY + "ValidPostCreateInstrumenJsonReqBody.json");
        InstrumentAPI.setPostCreateInstrumentNoAuth(jsonReq);
    }

    @When("Send post create mentor instrument")
    public void sendPostCreateInstrument() {
        SerenityRest.when().post(InstrumentAPI.POST_MENTORS_INSTRUMENT);
    }

    @Then("Status code should be {int} Create")
    public void statusCodeShouldBeCreate(int create) {
        SerenityRest.then().statusCode(create);
    }

    @Then("Status code should be {int} Unauthorized")
    public void statusCodeShouldBeUnauthorized(int auth) {
        SerenityRest.then().statusCode(auth);
    }

    @And("Response should be {string}")
    public void responsBodyShouldBeNameEmailAndBody(String body) {
        SerenityRest.then()
                .body(API_Responses.BODY_MESSAGE,equalTo(body));
    }

    @And("Validate post create comment resources json schema")
    public void validatePostCreateCommentResourcesJsonSchema() {
        File jsonSchema = new File(JsonSchemaInstrument.SCHEMA +"PostCreateInstrumentJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
