package MusicLab.StepDefinitions.Mentor;

import MusicLab.API.Mentor.MentorsAPI;
import MusicLab.utilities.Mentor.JsonSchemaMentor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetSingleListMentorsStepDef {

    @Steps
    MentorsAPI mentorsAPI;

    @Given("Get mentors profile")
    public void getMentorsProfile() {
        mentorsAPI.setGetSingleMentorsProfile();
    }

    @Given("Get single mentors with valid ID {int}")
    public void getSingleMentorsWithValidId(int id) {
        mentorsAPI.getSingleMentorByValidID(id);
    }

    @Given("Get single mentors with invalid ID {string}")
    public void getSingleMentorsWithInvalidId(String invalidid) {
        mentorsAPI.getSingleMentorByInvalidID(invalidid);
    }

    @Given("Get single mentors with blank ID {}")
    public void getSingleMentorsWithblankId() {
        mentorsAPI.getSingleMentorBlankId();
    }

    @When("Send request get mentors profile")
    public void sendRequestGetMentorsProfile() {
        SerenityRest.when().get(MentorsAPI.GET_SINGLE_MENTORS_PROFILE);
    }

    @When("Send request get single mentors with valid id")
    public void sendRequestGetSingleListMentorsWithValidId() {
        SerenityRest.when().get(MentorsAPI.GET_SINGLE_MENTORS_PROFILE_BY_ID);
    }

    @When("Send request get single mentors with invalid id")
    public void sendRequestGetSingleListMentorsWithInvalidId() {
        SerenityRest.when().get(MentorsAPI.GET_SINGLE_MENTORS_PROFILE_BY_INVALID_ID);
    }

    @When("Send request get single mentors with blank id")
    public void sendRequestGetSingleListMentorsWithBlankId() {
        SerenityRest.when().get(MentorsAPI.GET_SINGLE_MENTORS_PROFILE_BY_BLANK_ID);
    }

    @And("Validate single mentor profile json schema")
    public void validateJsonSchema(){
        File jsonSchema = new File(JsonSchemaMentor.SCHEMA+"GetSingleMentorProfileJsonSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
