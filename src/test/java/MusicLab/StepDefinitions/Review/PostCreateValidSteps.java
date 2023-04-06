package MusicLab.StepDefinitions.Review;

import MusicLab.API.Review.ReviewAPI;
import MusicLab.utilities.Review.JsonSchemaReview;
import MusicLab.utilities.Review.ReqBodyReview;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class PostCreateValidSteps {

    @Steps
    ReviewAPI reviewAPI;

    @Given("Post create Review with valid JSON and {int} as id mentor")
    public void postCreateReviewWithValidJSON(int id) {
        File jsonReq = new File(ReqBodyReview.REQ_BODY+"PostCreateReviewinMentorValidData.json");
        reviewAPI.setPostCreateReviewInMentorValidData(jsonReq, id);
    }

    @When("Send post create Review")
    public void sendPostCreateReview() {
        SerenityRest.when().post(ReviewAPI.POST_CREATE_REVIEW_IN_MENTOR_VALID_DATA);
    }

    @Then("Status code should be {int} Create review")
    public void statusCodeShouldBeCreateReview(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("Validate post create Review json schema")
    public void validatePostCreateReviewJsonSchema() {
        File jsonSchema = new File(JsonSchemaReview.SCHEMA+"message_schema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
