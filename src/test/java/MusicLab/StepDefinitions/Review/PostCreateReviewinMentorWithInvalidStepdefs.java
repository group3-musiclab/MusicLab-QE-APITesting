package MusicLab.StepDefinitions.Review;

import MusicLab.API.Review.ReviewAPI;
import MusicLab.utilities.Instrument.ReqBodyInstrument;
import MusicLab.utilities.Review.ReqBodyReview;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class PostCreateReviewinMentorWithInvalidStepdefs {

    @Steps
    ReviewAPI reviewAPI ;

    @Given("Post create Review with invalid JSON")
    public void postCreateReviewWithInvalidJSON() {
        File jsonReq = new File(ReqBodyReview.REQ_BODY + "PostCreateReviewinMentorWithInvalid.json.json");
        ReviewAPI.setPostCreateReviewInMentorWithInvalid(jsonReq) ;
    }

    @Given("Post create Review with empty comment")
    public void postCreateReviewWithEmptyComment() {
        File jsonReq = new File(ReqBodyReview.REQ_BODY + "PostCreateReviewinMentorWithempty.json");
        ReviewAPI.setPostCreateReviewInMentorWithInvalid(jsonReq) ;
    }
}
