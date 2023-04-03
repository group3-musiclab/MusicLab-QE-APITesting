package MusicLab.API.Review;

import MusicLab.Base;
import MusicLab.utilities.API_Responses;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReviewAPI extends Base {
    public static String GET_SINGLE_REVIEW_IN_MENTOR_CASE = BASE_URL + "Review";
    public static String POST_CREATE_REVIEW_IN_MENTOR_VALID_DATA = BASE_URL + "Review";
    public static String POST_CREATE_REVIEW_IN_MENTOR_WITH_INVALID = BASE_URL + "Review";


    @Step("Get Single Review In Mentor")
    public void setGetSingleReviewInMentorCase(int id) {
        SerenityRest.given()
                .pathParam(API_Responses.ID ,id);

    }

    @Step("Post Create Review in Mentor valid data")
    public static void setPostCreateReviewInMentorValidData(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);

    }

    @Step("Post Create Review in mentor with invalid")
    public static void setPostCreateReviewInMentorWithInvalid(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);

    }
}
