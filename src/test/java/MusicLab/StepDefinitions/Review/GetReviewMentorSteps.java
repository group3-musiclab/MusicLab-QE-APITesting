package MusicLab.StepDefinitions.Review;

import MusicLab.API.Review.ReviewAPI;
import MusicLab.utilities.Review.JsonSchemaReview;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class GetReviewMentorSteps {

    @Steps
    ReviewAPI reviewAPI;

    @Given("Get single review with valid ID {int}")
    public void getSingleReviewWithValidID(int id) {
        reviewAPI.setGetSingleReviewInMentorCase(id);
    }

    @When("Send request get single mentors review")
    public void sendRequestGetSingleMentorsWithValidId() {
        SerenityRest.when().get(ReviewAPI.GET_SINGLE_REVIEW_IN_MENTOR_CASE);
    }

    @Then("Status code should be {int} OK review")
    public void statusCodeShouldBeOK(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("Validate single review json schema")
    public void validateSingleReviewJsonSchema() {
        File jsonSchema = new File(JsonSchemaReview.SCHEMA+"GetSingleReviewinMentor.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    @Given("Get single review with invalid ID {string}")
    public void getSingleReviewWithInvalidID(String id) {
        reviewAPI.setGetSingleReviewInMentorCaseInvalid(id);
    }

    @Then("Status code should be {int} Bad Request review")
    public void statusCodeShouldBeBadRequestReview(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("Validate single review json schema invalid")
    public void validateSingleReviewJsonSchemaInvalid() {
        File jsonSchema = new File(JsonSchemaReview.SCHEMA+"message_schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
