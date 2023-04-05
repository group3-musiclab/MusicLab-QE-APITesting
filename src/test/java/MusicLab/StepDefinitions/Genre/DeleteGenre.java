package MusicLab.StepDefinitions.Genre;

import MusicLab.API.Genre.Genre;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteGenre {

    @Steps
    Genre genre;

    @Given("Delete genre with id {int}")
    public void deleteGenreWithId(int id) {
        genre.mentorGenreDelete(id);
    }

    @When("Send request delete genre")
    public void sendRequestDeleteGenre() {
        SerenityRest.when().delete(Genre.DELETE_GENRE);
    }


//    Invalid
    @Given("Delete genre with id {string}")
    public void deleteGenreWithId(String id) {
        genre.deleteGenreInvalid(id);
    }

//    Blank
    @Given("Delete genre with blank id")
    public void deleteGenreWithBlankId() {
        genre.deleteGenreBlank();
    }

    @When("Send request delete genre blank parameter")
    public void sendRequestDeleteGenreBlankParameter() {
        SerenityRest.when().delete(Genre.DELETE_GENRE_BLANK);
    }

    @Then("Status code should {int} Method Not Allowed auth")
    public void statusCodeShouldMethodNotAllowed(int code) {
        SerenityRest.then().statusCode(code);
    }
}
