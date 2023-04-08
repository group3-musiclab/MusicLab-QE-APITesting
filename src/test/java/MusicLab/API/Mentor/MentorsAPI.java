package MusicLab.API.Mentor;

import MusicLab.Base;
import MusicLab.utilities.API_Responses;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;
import io.restassured.http.ContentType;

public class MentorsAPI extends Base {

    public static File imageFile = new File("image.jpg");
    public static  String TOKEN_MENTOR = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODIyNDc3MjksInJvbGUiOiJNZW50b3IiLCJ1c2VySWQiOjg2fQ.PoRIUubhKqqL4xdE3dIRXHS5FTvEoN-WrZcFFnDksHE";
    public static  String CERTIFICATE_FILE = JSON_REQ_BODY_USER+"Mentor/download.jpg";
    public static  String AVATAR_FILE = JSON_REQ_BODY_USER+"Mentor/NormalAvatar.jpg";
    public static  String OVERSIZE_FILE = JSON_REQ_BODY_USER+"Mentor/OverSizeImage.jpg";
    public static String GET_ALL_LIST_MENTORS = BASE_URL + "mentors";
    public static String GET_ALL_LIST_MENTORS_WITH_PARAM = BASE_URL + "mentors?{parameters}";
    public static String GET_ALL_LIST_MENTORS_BY_TOPWEEK = BASE_URL + "mentors/topweek";
    public static String GET_SINGLE_MENTORS_PROFILE = BASE_URL + "mentors/profile";
    public static String GET_SINGLE_MENTORS_PROFILE_BY_ID = BASE_URL + "mentors/{mentor_id}";
    public static String GET_SINGLE_MENTORS_PROFILE_BY_INVALID_ID = BASE_URL + "mentors/{string}";
    public static String GET_SINGLE_MENTORS_PROFILE_BY_BLANK_ID = BASE_URL + "mentors/{}";
    public static String POST_CREATED_MENTORS_CREDENTIAL = BASE_URL + "mentors/credentials";
    public static String PUT_UPDATE_MENTORS_PROFILE = BASE_URL + "{mentors}";
    public static String PUT_UPDATE_MENTORS_PASSWORD = BASE_URL + "mentors/password";
    public static String DELETE_MENTORS = BASE_URL + "mentors";


    @Step("Get all list mentors")
    public void getAllListMentors() {
        SerenityRest.given();
    }

    @Step("Get all list mentors with valid parameter")
    public void setGetAllListMentorsPage(String param){
        SerenityRest.given()
                .pathParam("parameters",param);
    }

    @Step("Get all list mentors with invalid parameter")
    public void setGetAllListMentorsInvalidParam(String param){
        SerenityRest.given()
                .pathParam("parameters",param);
    }

    @Step("Get all list mentors by top week")
    public void getAllListMentorsByTopweek() {
        SerenityRest.given();
    }

    @Step("Get single mentors")
    public void setGetSingleMentorsProfile(){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN_MENTOR);
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
    public void getSingleMentorBlankId(){
        SerenityRest.given();
    }

    @Step("Post Create Mentors Credential with valid JSON")
    public void setPostCreateMentorsCredentialValidJSON() {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN_MENTOR)
                .contentType("multipart/form-data")
                .multiPart("type", "International")
                .multiPart("name", "Guitar Master")
                .multiPart("certificate_file", new File(CERTIFICATE_FILE), "image/jpeg");
    }

    @Step("Post Create Mentors Credential with over-size image/jpg")
    public void setPostCreateMentorsCredentialWithOverSizeImage() {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN_MENTOR)
                .contentType("multipart/form-data")
                .multiPart("type", "International")
                .multiPart("name", "Guitar Master")
                .multiPart("certificate_file", new File(OVERSIZE_FILE), "image/jpeg");
    }

    @Step("Post Create Mentors Credential with invalid JSON")
    public void setPostCreateMentorsCredentialInvalidJSON(File json) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN_MENTOR)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Create Mentors Credential with valid JSON no auth")
    public void setPostCreateMentorCredentialNoAuth(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update Mentors Profile with Valid JSON")
    public void setPutUpdateMentorsProfileWithValidJson(String mentors) {
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN_MENTOR)
                .pathParam("mentors", mentors)
                .contentType("multipart/form-data")
                .multiPart("name", "Aldan Maulana Fajri")
                .multiPart("email", "mafa.alfa@gmail.com")
                .multiPart("sex", "Male")
                .multiPart("phone", "081231656236")
                .multiPart("address", "Nganjuk")
                .multiPart("instagram", "@aldanmaulana")
                .multiPart("about", "Senior Musical Teacher")
                .multiPart("avatar_file", new File(AVATAR_FILE), "image/jpeg");
    }

    @Step("Put Update Mentors Profile with over-size image/jpg")
    public void setPutUpdateMentorsProfileWithOverSizeImage(String mentors) {
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN_MENTOR)
                .pathParam("mentors", mentors)
                .contentType("multipart/form-data")
                .multiPart("name", "Aldan Maulana Fajri")
                .multiPart("email", "mafa.alfa@gmail.com")
                .multiPart("sex", "Male")
                .multiPart("phone", "081231656236")
                .multiPart("address", "Nganjuk")
                .multiPart("instagram", "@aldanmaulana")
                .multiPart("about", "Senior Musical Teacher")
                .multiPart("avatar_file", new File(OVERSIZE_FILE), "image/jpeg");
    }

    @Step("Put Update Mentors Profile with Invalid JSON")
    public void setPutUpdateMentorsProfileWithInvalidJson(File json) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN_MENTOR)
                .contentType(ContentType.JSON)
                .body(json);
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
                .header("Authorization","Bearer "+TOKEN_MENTOR)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update Mentors Password with Invalid JSON")
    public void setPutUpdateMentorsPasswordWithInvalidJson(File json) {
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN_MENTOR)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update Mentors Password with Valid JSON no Auth")
    public void setPutUpdateMentorsPasswordWithValidJsonNoAuth(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete mentors with auth")
    public void setDeleteMentorsWithAuth(){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN_MENTOR);
    }

    @Step("Delete mentors with no auth")
    public void setDeleteMentorsWithNoAuth(){
        SerenityRest.given();
    }
}
