package MusicLab.StepDefinitions.Genre;

import MusicLab.API.Genre.Genre;
import MusicLab.utilities.Genre.JsonSchemaGenre;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetMentorGenre {

    @Steps
    Genre genre;

    @Given("get data mentor genre with {int} as id mentor")
    public void getDataMentorGenre(int id) {
        genre.getMentorGenre(id);
    }

    @When("Send request get data genre mentor")
    public void sendRequestGetDataGenreMentor() {
        SerenityRest.when().get(Genre.GET_MENTORS);
    }

    @And("Validate get mentor genre json schema")
    public void validateGetMentorGenreJsonSchema() {
        File json = new File(JsonSchemaGenre.SCHEMA_GET_MENTOR);
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Invalid id
    @Given("get data mentor genre with {string} as id mentor")
    public void getDataMentorGenreWithAsIdMentor(String id) {
        genre.mentorGenre(id);
    }

//    Message
    @And("Validate message genre schema")
    public void validateMessageGenreSchema() {
        File json = new File(JsonSchemaGenre.MESSAGE_GENRE);
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
