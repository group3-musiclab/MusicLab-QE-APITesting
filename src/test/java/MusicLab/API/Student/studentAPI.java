package MusicLab.API.Student;

import MusicLab.Base;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

import static MusicLab.Base.BASE_URL;

public class studentAPI extends Base {
    public static String GET_STUDENT_PROFILE = BASE_URL+"students/profile";
    public static String PUT_STUDENT_PROFILE = BASE_URL+"students";
    public static String DELETE_STUDENT = BASE_URL+"students";
    public static String PUT_STUDENT_PASSWORD = BASE_URL+"students/password";
    @Step("Get student profile")
    public void getStudentProfile(){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENS);
    }
    @Step("Put edit student profile")
    public void putStudentProfile(File json){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENS)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete student")
    public void deleteStudent(){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENSPD);

    }
    @Step("Put edit student password")
    public void putStudentPassword(File json){
        SerenityRest.given().headers("Authorization","Bearer "+BEARER_TOKENSP)
                .contentType(ContentType.JSON)
                .body(json);
    }

}
