package MusicLab.API.Schedule;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

import static MusicLab.Base.BASE_URL;

public class ScheduleAPI {

    public static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODE3MTY0MTgsInJvbGUiOiJNZW50b3IiLCJ1c2VySWQiOjQ5fQ.J25otAh4Tgp7PeUqLfESbB3fYbBfgFMZNX7nzY03sno";

    public static String GET_MENTOR_SCHEDULE_VALID_ID = BASE_URL + "mentors/{id}/schedules/";

    public static String GET_MENTOR_SCHEDULE_INVALID_ID = BASE_URL + "mentors/{id}/schedules";

    public static String POST_ADD_MENTOR_SCHEDULE_VALID_JSON = BASE_URL + "mentors/schedules";

    public static String POST_ADD_MENTOR_SCHEDULE_INVALID_JSON = BASE_URL + "mentors/schedules";

    public static String POST_ADD_MENTOR_SCHEDULE_EMPTY_JSON = BASE_URL + "mentors/schedules";

    public static String POST_ADD_MENTOR_SCHEDULE_AVAILABILITY_VALID_JSON = BASE_URL + "mentors/schedules";

    public static String POST_ADD_MENTOR_SCHEDULE_AVAILABILITY_INVALID_JSON = BASE_URL + "schedules/check";

    public static String POST_ADD_MENTOR_SCHEDULE_AVAILABILITY_EMPTY_JSON = BASE_URL + "schedules/check";

    public static String DELETE_SCHEDULE_VALID_ID = BASE_URL + "schedules/{id}";

    public static String DELETE_SCHEDULE_EMPTY_ID = BASE_URL +"schedules/";



    @Step("Get mentor schedules valid id")
    public void setGetMentorSchedulesValidId(int id){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam("id",id);
    }

    @Step("Get mentor schedules invalid id")
    public void setGetMentorScheduleInvalidId(String id){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam("id",id);
    }

    @Step("Get mentor schedules valid id no authorization")
    public void setGetMentorSchedulesValidIdNoAuthorization(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }


    @Step("Post add mentor schedule valid json")
    public void setPostAddMentorScheduleValidJson(File json){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post add mentor schedule valid json no authorization")
    public void setPostAddMentorScheduleValidJsonNoAuthorization(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post add mentor schedule invalid json")
    public void setPostAddMentorScheduleInvalidJson(File json){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post add mentor schedule with empty json")
    public void setPostAddMentorScheduleEmptyJson(File json){
        SerenityRest.given().header("Authorization", "Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post add mentor schedule availability with valid json")
    public void setPostAddMentorScheduleAvailabilityValidJson(File json){
        SerenityRest.given().header("Authorization", "Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post add mentor schedule availability with valid json no authorization")
    public void setPostAddMentorScheduleAvailabilityValidJsonNoAuthorization(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post add mentor schedule availability with invalid json")
    public void setPostAddMentorScheduleAvailabilityInvalidJson(File json){
        SerenityRest.given().header("Authorization", "Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post add mentor schedule availability empty json")
    public void setPostAddMentorScheduleAvailabilityEmptyJson(File json){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete schedule valid id")
    public void setDeleteScheduleValidId(int id){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam("id", id);
    }

    @Step("Delete schedule invalid id")
    public void setDeleteScheduleInvalidId(String id){
        SerenityRest.given().header("Authorization","Bearer "+TOKEN)
                .pathParam("id", id);
    }

    @Step("Delete schedule with empty id")
    public void setDeleteScheduleEmptyId() {SerenityRest.given().header("Authorization", ":Bearer"+TOKEN);
    }

    @Step("Delete schedule valid id no authorization")
    public void setDeleteScheduleValidIdNoAuthorization(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }


}
