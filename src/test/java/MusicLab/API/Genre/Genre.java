package MusicLab.API.Genre;

import MusicLab.Base;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class Genre extends Base {
    public static String GET = BASE_URL + "genres";
    public static String POST = BASE_URL + "mentors/genres";
    public static String GET_MENTORS = BASE_URL + "mentors/{id}/genres";
    public static String DELETE_GENRE = BASE_URL + "mentors/genres/{id}";
    public static String DELETE_GENRE_BLANK = BASE_URL + "mentors/genres/";

    public static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODExMD" +
            "kzNjAsInJvbGUiOiJNZW50b3IiLCJ1c2VySWQiOjE5fQ.O_LZxtpsGB8JnNnDn8BGsXXyWTwliAVBSPEAUs78cFs";

    @Step("get all data genre")
    public void getAllGenre(){
        SerenityRest.given();
    }

    @Step("Post mentor genre")
    public void postGenre(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post mentor genre no authorization")
    public void postGenreNoAuth(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Data mentor genre")
    public void getMentorGenre(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Data mentor genre invalid")
    public void mentorGenre(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete mentor genre")
    public void mentorGenreDelete(int id){
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization", "Bearer " + TOKEN);
    }

    @Step("Delete mentor genre invalid")
    public void deleteGenreInvalid(String id){
        SerenityRest.given()
                .pathParam("id", id)
                .header("Authorization", "Bearer " + TOKEN);
    }

    @Step("Delete genre nlank")
    public void deleteGenreBlank(){
        SerenityRest.given().header("Authorization", "Bearer " + TOKEN);
    }
}
