package MusicLab.API.Class;

import MusicLab.Base;
import MusicLab.utilities.API_Responses;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class classAPI extends Base {
    public static String POST_A_CLASS = BASE_URL+"mentors/classes";
    public static String GET_ALL_CLASS_BY_ID_MENTOR = BASE_URL+"mentors/{mentor_id}/class?page={id}";
    public static String GET_MENTOR_CLASS_DETAIL = BASE_URL+"class/{class_id}";
    public static String IMAGE_FILE = JSON_REQ_BODY_USER+"/Class/fotobw.png";
    public static String PUT_A_CLASS = BASE_URL+"class/{class_id}";
    public static String DELETE_CLASS = BASE_URL+"class/{class_id}";
    @Step("Post to make a class valid parameter")
    public void postMakeClass(File json){
      SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENM)
              .contentType("multipart/form-data")
              .multiPart("image_file", new File(IMAGE_FILE), "image/png")
              .multiPart("name", "Guitar Class")
              .multiPart("level", "basic")
              .multiPart("description", "Best Guitar Course")
              .multiPart("syllabus", "In here we will master the guitar class under 3 month")
              .multiPart("for_whom", "Newbie")
              .multiPart("requirement", "Have a Guitar")
              .multiPart("price", "325000")
              .multiPart("duration", "3");
    }
    @Step("Post to make a class invalid parameter")
    public void postMakeClassInvalid(File json){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENM)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post to make a class null parameter")
    public void postMakeClassNull(File json){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENM)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get all class by id mentor")
    public void getAllClassByIDMentor(int mentor_id, int id){
      SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENM)
              .pathParam(API_Responses.MENTOR_ID,id)
              .pathParam("id",id)
              .pathParam("mentor_id",mentor_id);
    }
    @Step("Get all class by invalid id mentor")
    public void getAllClassByInvalidIDMentor(String mentor_id, int id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENM)
                .pathParam(API_Responses.MENTOR_ID,id)
                .pathParam("id",id)
                .pathParam("mentor_id",mentor_id);
    }
    @Step("Get mentor class detail")
    public void getAllMentorClassDetail(int class_id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENM)
            .pathParam("class_id",class_id);
    }
    @Step("Put update class all parameters")
    public void putUpdateClass(File json, int class_id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENM)
                .contentType("multipart/form-data")
                .multiPart("image_file", new File(IMAGE_FILE), "image/png")
                .multiPart("name", "Piano Class")
                .multiPart("level", "Intermediate")
                .multiPart("description", "Best Piano Course")
                .multiPart("syllabus", "In here we will master the piano class less than 3 months")
                .multiPart("for_whom", "Newbie")
                .multiPart("requirement", "Have your own, piano will be served")
                .multiPart("price", "350000")
                .multiPart("duration", "1")
                .pathParam("class_id",class_id);
    }
    @Step("Put update one parameter")
    public void putUpdateClassOneParam(File json, int class_id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENM)
                .contentType(ContentType.JSON)
                .body(json)
                .pathParam(API_Responses.CLASS_ID, class_id);

//                .contentType("multipart/form-data")
//                .multiPart("image_file", new File(IMAGE_FILE), "")
//                .multiPart("name", "")
//                .multiPart("level", "Advance")
//                .multiPart("description", "")
//                .multiPart("syllabus", "")
//                .multiPart("for_whom", "")
//                .multiPart("requirement", "")
//                .multiPart("price", "")
//                .multiPart("duration", "")
//                .pathParam(API_Responses.CLASS_ID, class_id);
    }
    @Step("Put update null parameter")
    public void putUpdateClassNullParam(File json, int class_id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENM)
                .contentType(ContentType.JSON)
                .body(json)
                .pathParam(API_Responses.CLASS_ID, class_id);
    }

    @Step("Delete class")
    public void deleteClass(int class_id){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENSPDC)
        .pathParam("class_id", class_id);
    }
}
