package MusicLab.API.Instrument;

import MusicLab.Base;
import MusicLab.utilities.API_Responses;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class InstrumentAPI extends Base {
    public static  String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODIyNDc3MjksInJvbGUiOiJNZW50b3IiLCJ1c2VySWQiOjg2fQ.PoRIUubhKqqL4xdE3dIRXHS5FTvEoN-WrZcFFnDksHE";
    public static final String GET_ALL_INSTRUMENT = BASE_URL + "instruments";
    public static final String GET_LIST_SINGLE_INSTRUMENT = BASE_URL + "mentors/{mentor_id}/instruments";
    public static final String POST_MENTORS_INSTRUMENT = BASE_URL + "mentors/instruments";
    public static final String DELETE_INSTRUMENT = BASE_URL + "mentors/instruments/{instrument_id}";
    public static final String DELETE_INSTRUMENT_INVALID_ID = BASE_URL + "mentors/instruments/{string}";
    public static final String DELETE_INSTRUMENT_BLANK_ID = BASE_URL + "mentors/instruments/{}";


    @Step("Get all list instrument")
    public void setGetAllListInstrument(){
        SerenityRest.given();
    }

    @Step("Get single instrument with valid id")
    public void getSingleInstrumentValidId(int id){
        SerenityRest.given()
                .pathParam(API_Responses.MENTOR_ID,id);
    }

    @Step("Get single instrument with invalid id")
    public void getSingleInstrumentInvalidId(String invalidid){
        SerenityRest.given()
                .pathParam(API_Responses.MENTOR_ID,invalidid);
    }

    @Step("Post create mentors instrument with valid JSON")
    public void setPostMentorsInstrument(File json) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create mentors instrument invalid JSON")
    public void setPostCreateInstrumentInvalidJSON(File json) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
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
