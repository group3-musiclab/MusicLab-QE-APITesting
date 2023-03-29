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

import static org.hamcrest.Matchers.equalTo;

public class GetIntrumentStepDef {

    @Steps
    InstrumentAPI instrumentAPI;


    @Given("Get all list instrument")
    public void getAllListInstrument() {
        instrumentAPI.setGetAllListInstrument();
    }

    @Given("Get single instrument with valid ID {int}")
    public void getSingleInstrumentWithValidId(int id) {
        instrumentAPI.getSingleInstrumentValidId(id);
    }

    @Given("Get single instrument with invalid ID {string}")
    public void getSingleInstrumentWithInvalidId(String invalidid) {
        instrumentAPI.getSingleInstrumentInvalidId(invalidid);
    }

    @When("Send request get all list instrument")
    public void sendRequestGetAllListInstrument() {
        SerenityRest.when().get(InstrumentAPI.GET_ALL_INSTRUMENT);
    }

    @When("Send request get single list instrument")
    public void sendRequestGetSingleListInstrument() {
        SerenityRest.when().get(InstrumentAPI.GET_LIST_SINGLE_INSTRUMENT);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int bad) {
        SerenityRest.then().statusCode(bad);
    }

    @And("Validate get all list Instrument json schema")
    public void validateJsonSchema(){
        File jsonSchema = new File(JsonSchemaInstrument.SCHEMA+"GetListInstrumentsJsonSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
