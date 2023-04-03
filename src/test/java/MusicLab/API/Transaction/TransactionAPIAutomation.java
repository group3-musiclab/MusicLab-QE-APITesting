package MusicLab.API.Transaction;

import MusicLab.Base;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class TransactionAPIAutomation {
    public static String POST_TRANSACTION = Base.BASE_URL+"transactions";
    public static String POST_TRANSACTION_INVALID_PATH = Base.BASE_URL+"999";
    public static String GET_MENTOR_TRANSACTION = Base.BASE_URL+"mentors/transactions?page={page}&limit={limit}";
    public static String GET_MENTOR_TRANSACTION_INVALID_PATH = Base.BASE_URL+"123/123?page={page}&limit={limit}";
    public static String GET_STUDENT_TRANSACTION = Base.BASE_URL+"students/transactions?page={page}&limit={limit}";
    public static String GET_STUDENT_TRANSACTION_INVALID_PATH = Base.BASE_URL+"456/456?page={page}&limit={limit}";
    public static  String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODEyNzU0MDUsInJvbGUiOiJTdHVkZW50IiwidXNlcklkIjoyMX0.2N_quXyMNLReqAiQRs9KK2Opysf2a3ER1VlU-DfnE3g";


    @Step("Post transaction")
    public void setPostTransaction(File json){
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }

    @Step("Post transaction invalid path")
    public void setPostTransactionInvalidPath(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .header("Authorization","Bearer "+TOKEN);
    }

    @Step("get mentor transaction")
    public void setGetMentorTransaction(int page, int limit){
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .pathParam("page",page)
                .pathParam("limit",limit);


    }
    @Step("get mentor transaction invalid path")
    public void setGetMentorTransactionInvalidPath(int page, int limit){
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .pathParam("page",page)
                .pathParam("limit",limit);

    }

    @Step("Get student transaction")
    public void setGetStudentTransaction(int page, int limit){
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .pathParam("page",page)
                .pathParam("limit",limit);

    }
    @Step("Get student transaction invalid path")
    public void setGetStudentTransactionInvalidPath(int page, int limit){
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .pathParam("page",page)
                .pathParam("limit",limit);

    }


}
