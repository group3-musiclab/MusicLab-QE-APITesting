package MusicLab.StepDefinitions.Review;

import MusicLab.API.Review.ReviewAPI;
import MusicLab.utilities.Mentor.JsonSchemaMentor;
import MusicLab.utilities.Review.JsonSchemaReview;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.apache.bcel.generic.NEW;

import java.io.File;

public class GetSingleReviewinMentorStepdefs {

    @Steps
    ReviewAPI reviewAPI;

    @Given("Get single review with valid ID {int}")
    public void getSingleReviewWithValidID(int id) {reviewAPI.setGetSingleReviewInMentorCase(id);
    }

    @When("Send request get single mentors with valid id")
    public void sendRequestGetSingleMentorsWithValidId() {
        SerenityRest.when().get(ReviewAPI.GET_SINGLE_REVIEW_IN_MENTOR_CASE);
    }

    @And("Validate single review json schema")
    public void validateSingleReviewJsonSchema() {
        File jsonSchema = new File(JsonSchemaReview.SCHEMA+"GetSingleReviewinMentor.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
