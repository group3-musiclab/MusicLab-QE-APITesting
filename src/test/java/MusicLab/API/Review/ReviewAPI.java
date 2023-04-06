package MusicLab.API.Review;

import MusicLab.Base;
import MusicLab.utilities.API_Responses;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReviewAPI extends Base {
    public static String GET_SINGLE_REVIEW_IN_MENTOR_CASE = BASE_URL + "mentors/{id}/reviews";
    public static String POST_CREATE_REVIEW_IN_MENTOR_VALID_DATA = BASE_URL + "mentors/{id}/reviews";
    public static String POST_CREATE_REVIEW_IN_MENTOR_WITH_INVALID = BASE_URL + "mentors/{id}/reviews";

    public static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2OD" +
            "IwNDE5NDgsInJvbGUiOiJNZW50b3IiLCJ1c2VySWQiOjQ5fQ.bNs0GBEgUZUE8HrNke7-Xne3bxnqohM2CKLjY6LIR9M";


    @Step("Get Single Review In Mentor")
    public void setGetSingleReviewInMentorCase(int id) {
        SerenityRest.given()
                .pathParam("id" ,id);
    }

    @Step("Get Single Review In Mentor")
    public void setGetSingleReviewInMentorCaseInvalid(String id) {
        SerenityRest.given()
                .pathParam("id" ,id);
    }

    @Step("Post Create Review in Mentor valid data")
    public void setPostCreateReviewInMentorValidData(File json, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization", "Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }

    @Step("Post Create Review in mentor with invalid")
    public void setPostCreateReviewInMentorWithInvalid(File json, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization", "Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }
}
