package MusicLab.API.Mentor;

import MusicLab.Base;
import MusicLab.utilities.API_Responses;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class MentorsAPI extends Base {
    public static  String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODEyNzk3NTgsInJvbGUiOiJNZW50b3IiLCJ1c2VySWQiOjE5fQ.DMXgj-ACiPMZqmbDeGeNTJOUz5O9-rxdftSqnWxCRJA";
    public static String GET_ALL_LIST_MENTORS = BASE_URL + "mentors";
    public static String GET_ALL_LIST_MENTORS_WITH_PARAM = BASE_URL + "mentors?page={id}";
    public static String GET_ALL_LIST_MENTORS_BY_TOPWEEK = BASE_URL + "mentors/topweek";
    public static String GET_SINGLE_MENTORS_PROFILE = BASE_URL + "mentors/profile";
    public static String GET_SINGLE_MENTORS_PROFILE_BY_ID = BASE_URL + "mentors/{mentor_id}";
    public static String POST_CREATED_MENTORS_CREDENTIAL = BASE_URL + "mentors/credentials";
    public static String PUT_UPDATE_MENTORS_PROFILE = BASE_URL + "mentors";
    public static String PUT_UPDATE_MENTORS_PASSWORD = BASE_URL + "mentors/password";
    public static String DELETE_MENTORS = BASE_URL + "mentors";


    @Step("Get all list mentors")
    public void getAllListMentors() {
        SerenityRest.given();
    }

    @Step("Get list mentors with id")
    public void setGetListUsersPage(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Get all list mentors by top week")
    public void getAllListMentorsByTopweek() {
        SerenityRest.given();
    }

    @Step("Get single mentors")
    public void setGetSingleUser(){
        SerenityRest.given();
    }

    @Step("Get single mentor with valid id ")
    public void getSingleMentorByValidID(int id){
        SerenityRest.given()
                .pathParam(API_Responses.MENTOR_ID,id);
    }

    @Step("Get single mentor with invalid id ")
    public void getSingleMentorByInvalidID(String invalidid){
        SerenityRest.given()
                .pathParam("mentor_id", invalidid);
    }

    @Step("Get single mentor with blank id")
    public void getSingleCommentBlank(){
        SerenityRest.given();
    }

    @Step("Post Create Mentors Credential with valid JSON")
    public void setPostCreateMentorsCredentialValidJSON(File json) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Create Mentors Credential with invalid JSON")
    public void setPostCreateMentorsCredentialInvalidJSON(String post) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam("post", post)
                .contentType("multipart/form-data")
                .multiPart("type", "International")
                .multiPart("name", "");
    }

    @Step("Post Create Mentors Credential with valid JSON no auth")
    public void setPostCreateMentorCredentialNoAuth(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update Mentors Profile with Valid JSON")
    public void setPutUpdateMentorsProfileWithValidJson(File json) {
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update Mentors Profile with Invalid JSON")
    public void setPutUpdateMentorsProfileWithInvalidJson(String put) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam("put", put)
                .contentType("multipart/form-data")
                .multiPart("name", "Aldan Maulana Fajri")
                .multiPart("email", "aldanmaulanaf")
                .multiPart("sex", "Male")
                .multiPart("phone", "1243424")
                .multiPart("address", "Nganjuk")
                .multiPart("instagram", "")
                .multiPart("about", "senior musical teacher");
    }

    @Step("Put Update Mentors Profile with Valid JSON no Auth")
    public void setPutUpdateMentorsProfileWithValidJsonNoAuth(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update Mentors Password with Valid JSON")
    public void setPutUpdateMentorsPasswordWithValidJson(File json) {
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update Mentors Password with Invalid JSON")
    public void setPutUpdateMentorsPasswordWithInvalidJson(String put) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam("put", put)
                .contentType("multipart/form-data")
                .multiPart("name", "Aldan Maulana Fajri")
                .multiPart("email", "aldanmaulanaf")
                .multiPart("sex", "Male")
                .multiPart("phone", "1243424")
                .multiPart("address", "Nganjuk")
                .multiPart("instagram", "")
                .multiPart("about", "senior musical teacher");
    }

    @Step("Put Update Mentors Password with Valid JSON no Auth")
    public void setPutUpdateMentorsPasswordWithValidJsonNoAuth(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete mentors with auth")
    public void setDeleteCommentWithAuth(){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN);
    }

    @Step("Delete mentors with no auth")
    public void setDeleteMentorsWithNoAuth(){
        SerenityRest.given();
    }
}
