package MusicLab.StepDefinitions.Genre;

import MusicLab.API.Genre.Genre;
import MusicLab.utilities.Genre.ReqBodyGenre;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class PostGenreSteps {

    @Steps
    Genre genre;

    @Given("Mentor post genre with valid json")
    public void mentorPostGenreWithValidJson() {
        File json = new File(ReqBodyGenre.POST);
        genre.postGenre(json);
    }

    @When("Send request post genre")
    public void sendRequestPostGenre() {
        SerenityRest.when().post(Genre.POST);
    }

//    Invalid
    @Given("Mentor post genre with invalid json")
    public void mentorPostGenreWithInvalidJson() {
        File json = new File(ReqBodyGenre.POST_INVALID);
        genre.postGenre(json);
    }

//    Blank
    @Given("Mentor post genre with blank json")
    public void mentorPostGenreWithBlankJson() {
        File json = new File(ReqBodyGenre.POST_BLANK);
        genre.postGenre(json);
    }

//    No auth
    @Given("Mentor post genre with valid json with no auth")
    public void mentorPostGenreWithValidJsonWithNoAuth() {
        File json = new File(ReqBodyGenre.POST);
        genre.postGenreNoAuth(json);
    }

    @When("Send request post genre no auth")
    public void sendRequestPostGenreNoAuth() {
        SerenityRest.when().post(Genre.POST);
    }

    @Then("Status code should {int} Unauthorized auth")
    public void statusCodeShouldUnauthorized(int code) {
        SerenityRest.then().statusCode(code);
    }
}
