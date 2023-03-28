package MusicLab.API.Instrument;

import MusicLab.Base;
import MusicLab.utilities.API_Responses;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class InstrumentAPI extends Base {
    public static  String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODEyNzk3NTgsInJvbGUiOiJNZW50b3IiLCJ1c2VySWQiOjE5fQ.DMXgj-ACiPMZqmbDeGeNTJOUz5O9-rxdftSqnWxCRJA";
    public static final String GET_ALL_INSTRUMENT = BASE_URL + "instruments";
    public static final String GET_LIST_SINGLE_INSTRUMENT = BASE_URL + "mentors/{mentor_id}/instruments";
    public static final String POST_MENTORS_INSTRUMENT = BASE_URL + "mentors/instruments";
    public static final String DELETE_INSTRUMENT = BASE_URL + "mentors/instruments/{instrument_id}";
    public static final String DELETE_INSTRUMENT_INVALID_ID = BASE_URL + "mentors/instruments/{string}";
    public static final String DELETE_INSTRUMENT_BLANK_ID = BASE_URL + "mentors/instruments/{}";


    @Step("Get all list instrument")
    public static void setGetAllListInstrument(){
        SerenityRest.given();
    }

    @Step("Get single instrument with valid id")
    public static void getSingleInstrumentValidId(int id){
        SerenityRest.given()
                .pathParam(API_Responses.MENTOR_ID,id);
    }

    @Step("Get single instrument with invalid id")
    public static void getSingleInstrumentInvalidId(String invalidid){
        SerenityRest.given()
                .pathParam(API_Responses.MENTOR_ID,invalidid);
    }

    @Step("Post create mentors instrument with valid JSON")
    public static void setPostMentorsInstrument(File json) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create mentors instrument invalid JSON")
    public static void setPostCreateInstrumentInvalidJSON(File json) {
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create mentors instrument valid JSON no auth")
    public static void setPostCreateInstrumentNoAuth(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete instrument with auth")
    public static void setDeleteInstrumentWithAuth(int id){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam(API_Responses.INSTRUMENT_ID,id);
    }

    @Step("Delete instrument invalid id with auth")
    public static void setDeleteInstrumentInvalidParameterWithAuth(String id){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam("string",id);
    }

    @Step("Delete instrument without auth")
    public static void setDeleteInstrumentWithoutAuth(int id){
        SerenityRest.given()
                .pathParam(API_Responses.INSTRUMENT_ID,id);
    }

    @Step("Delete instrument blank parameter with auth")
    public static void setDeleteInstrumentBlankParameterWithAuth(){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN);
    }
}
