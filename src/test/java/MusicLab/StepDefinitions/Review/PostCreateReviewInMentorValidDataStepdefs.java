package MusicLab.StepDefinitions.Review;

import MusicLab.API.Review.ReviewAPI;
import MusicLab.utilities.Instrument.JsonSchemaInstrument;
import MusicLab.utilities.Mentor.ReqBodyMentor;
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

public class PostCreateReviewInMentorValidDataStepdefs {

    @Steps
    ReviewAPI reviewAPI ;

    @Given("Post create Review with valid JSON")
    public void postCreateReviewWithValidJSON() {
        File jsonReq = new File(ReqBodyReview.REQ_BODY + "PostCreateReviewinMentorValidData.json");
        ReviewAPI.setPostCreateReviewInMentorValidData(jsonReq) ;
    }

    @When("Send post create Review")
    public void sendPostCreateReview() { SerenityRest.when().post(
            ReviewAPI.POST_CREATE_REVIEW_IN_MENTOR_VALID_DATA );
    }

    @Then("Status code should be {int} Create")
    public void statusCodeShouldBeCreate(int create) {
        SerenityRest.then().statusCode(create);
    }

    @And("Validate post create Review json schema")
    public void validatePostCreateReviewJsonSchema() {
        File jsonSchema = new File(JsonSchemaReview.SCHEMA +"PostCreateReviewinMentorValidData.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
