package MusicLab.StepDefinitions.Mentor;

import MusicLab.API.Instrument.InstrumentAPI;
import MusicLab.API.Mentor.MentorsAPI;
import MusicLab.utilities.Instrument.JsonSchemaInstrument;
import MusicLab.utilities.Mentor.JsonSchemaMentor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetAllMentorsStepDef {

    @Steps
    MentorsAPI mentorsAPI;

    @Given("Get all list mentors")
    public void getAllListMentors() {
        mentorsAPI.getAllListMentors();
    }

    @Given("Get all list mentors with valid parameters {string}")
    public void getAllListMentorsWithParameters(String param) {
        mentorsAPI.setGetAllListMentorsPage(param);
    }

    @Given("Get all list mentors with invalid parameters {string}")
    public void getAllListMentorsWithInvalidParameters(String id) {
        mentorsAPI.setGetAllListMentorsInvalidParam(id);
    }

    @Given("Get list mentors top week")
    public void getListMentorsTopWeek() {
        mentorsAPI.getAllListMentorsByTopweek();
    }

    @When("Send request get all list mentors")
    public void sendRequestGetAllListMentros() {
        SerenityRest.when().get(MentorsAPI.GET_ALL_LIST_MENTORS);
    }

    @When("Send request get all list mentors with parameters")
    public void sendRequestGetAllListMentrosWithValidParameter() {
        SerenityRest.when().get(MentorsAPI.GET_ALL_LIST_MENTORS_WITH_PARAM);
    }

    @When("Send request get all list mentors top week")
    public void sendRequestGetAllListMentrosTopWeek() {
        SerenityRest.when().get(MentorsAPI.GET_ALL_LIST_MENTORS_BY_TOPWEEK);
    }

    @And("Validate get all list mentors json schema")
    public void validateJsonSchema(){
        File jsonSchema = new File(JsonSchemaMentor.SCHEMA+"GetAllListMentorsJsonSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate get all list mentors top week json schema")
    public void validateJsonSchemaMentorsTopWeek(){
        File jsonSchema = new File(JsonSchemaMentor.SCHEMA+"GetAllListMentorsTopWeekJsonSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
