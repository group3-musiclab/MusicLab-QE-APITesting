package MusicLab.StepDefinitions.Genre;

import MusicLab.API.Genre.Genre;
import MusicLab.utilities.Auth.JsonSchemaAuth;
import MusicLab.utilities.Genre.JsonSchemaGenre;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetGenreSteps {

    @Steps
    Genre genre;

    @Given("Get all data about genre mentor")
    public void getAllDataAboutGenreMentor() {
        genre.getAllGenre();
    }

    @When("Send request get data genre")
    public void sendRequestGetDataGenre() {
        SerenityRest.when().get(Genre.GET);
    }

    @And("Validate get genre json schema")
    public void validateGetGenreJsonSchema() {
        File json = new File(JsonSchemaGenre.SCHEMA_GET_ALL);
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
