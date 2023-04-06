package MusicLab.StepDefinitions.Review;

import MusicLab.API.Review.ReviewAPI;
import MusicLab.utilities.Review.ReqBodyReview;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class PostCreateInvalidStep {

    @Steps
    ReviewAPI reviewAPI;

    @Given("Post create review with invalid JSON and {int} as id mentor")
    public void postCreateReviewWithInvalidJSON(int id) {
        File jsonReq = new File(ReqBodyReview.REQ_BODY+"PostCreateReviewinMentorWithInvalid.json");
        reviewAPI.setPostCreateReviewInMentorWithInvalid(jsonReq, id);
    }

    @Given("Post create review with empty comment and {int} as id mentor")
    public void postCreateReviewWithEmptyComment(int id) {
        File jsonReq = new File(ReqBodyReview.REQ_BODY+"PostCreateReviewinMentorWithempty.json");
        reviewAPI.setPostCreateReviewInMentorWithInvalid(jsonReq, id);
    }
}
