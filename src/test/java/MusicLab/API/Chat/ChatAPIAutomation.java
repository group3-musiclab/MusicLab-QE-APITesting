package MusicLab.API.Chat;

import MusicLab.Base;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ChatAPIAutomation {
    public static String POST_CREATE_MESSAGE = Base.BASE_URL+"chats";
    public static String POST_CREATE_MESSAGE_INVALID_PATH = Base.BASE_URL+"999";

    public static String GET_CHAT_MESSAGE = Base.BASE_URL+"chats?mentor={mentor}&student={student}";
    public static String GET_CHAT_MESSAGE_INVALID_PATH = Base.BASE_URL+"123?mentor={mentor}&student={student}";
    public static String GET_INBOX_LIST = Base.BASE_URL+"inbox";
    public static String GET_INBOX_LIST_INVALID_PATH = Base.BASE_URL+"456";
    public static  String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODEyNzU0MDUsInJvbGUiOiJTdHVkZW50IiwidXNlcklkIjoyMX0.2N_quXyMNLReqAiQRs9KK2Opysf2a3ER1VlU-DfnE3g";


    @Step("Post create message")
    public void setPostCreateMessage(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization","Bearer "+TOKEN);

    }
    @Step("Post create message invalid path")
    public void setPostCreateMessageInvalidPath(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization","Bearer "+TOKEN);
    }


    @Step("get chat message")
    public void setGetChatMessage(int mentor, int student){
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .pathParam("mentor",mentor)
                .pathParam("student",student);
    }
    @Step("get chat message invalid path")
    public void setGetChatMessageInvalidPath(int mentor, int student){
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .pathParam("mentor",mentor)
                .pathParam("student",student);

    }

    @Step("get inbox list")
    public void setGetInboxList(){
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN);

    }
    @Step("get inbox list invalid path")
    public void setGetInboxListInvalidPath(){
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN);
    }




}
