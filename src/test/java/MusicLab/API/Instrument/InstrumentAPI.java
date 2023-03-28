package MusicLab.API.Instrument;

import MusicLab.Base;
import MusicLab.utilities.API_Responses;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class InstrumentAPI extends Base {
    public static  String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODEyNzk3NTgsInJvbGUiOiJNZW50b3IiLCJ1c2VySWQiOjE5fQ.DMXgj-ACiPMZqmbDeGeNTJOUz5O9-rxdftSqnWxCRJA";
    public static String GET_ALL_INSTRUMENT = BASE_URL + "instruments/";
    public static String GET_LIST_SINGLE_INSTRUMENT = BASE_URL + "mentors/{mentor_id}/instruments";
    public static String POST_MENTORS_INSTRUMENT = BASE_URL + "mentors/instruments";
    public static String DELETE_MENTORS_INSTRUMENT = BASE_URL + "mentors/instruments/{instrument_id}";


    @Step("Get all list instrument")
    public void getAllListInstrument(String instrument){
        SerenityRest.given()
                .pathParam("instrument",instrument);
    }

    @Step("Get single instrument with valid id")
    public void getSingleInstrumentValidId(int id){
        SerenityRest.given()
                .pathParam(API_Responses.MENTOR_ID,id);
    }
    @Step("Post create mentors instrument with valid JSON")
    public void setPostMentorsInstrument(File json) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create mentors instrument invalid JSON")
    public void setPostCreateInstrumentInvalidJSON(String post) {
        SerenityRest.given()
                .pathParam("post", post)
                .contentType("multipart/form-data")
                .multiPart("instrument_id","asdasf");
    }

    @Step("Post create mentors instrument valid JSON no auth")
    public void setPostCreateInstrumentNoAuth(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete instrument with auth")
    public void setDeleteInstrumentWithAuth(int id){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam(API_Responses.INSTRUMENT_ID,id);
    }

    @Step("Delete instrument invalid id with auth")
    public void setDeleteInstrumentInvalidParameterWithAuth(String id){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam("string",id);
    }

    @Step("Delete instrument without auth")
    public void setDeleteInstrumentWithoutAuth(int id){
        SerenityRest.given()
                .pathParam(API_Responses.INSTRUMENT_ID,id);
    }

    @Step("Delete instrument blank parameter with auth")
    public void setDeleteInstrumentBlankParameterWithAuth(){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN);
    }
}
