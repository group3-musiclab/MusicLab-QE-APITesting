package MusicLab.StepDefinitions.Mentor;

import MusicLab.API.Mentor.MentorsAPI;
import MusicLab.utilities.API_Responses;
import MusicLab.utilities.Mentor.JsonSchemaMentor;
import MusicLab.utilities.Mentor.ReqBodyMentor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PutUpdateMentorsStepDef {

    @Steps
    MentorsAPI mentorsAPI;

    @Given("Put update mentors profile with valid json")
    public void putUpdateMentorsProfileValidJson() {
        //File jsonReq = new File(ReqBodyMentor.REQ_BODY + "ValidPutUpdateMentorsProfileJsonReqBody.json");
        mentorsAPI.setPutUpdateMentorsProfileWithValidJson("mentors");
    }

    @Given("Put update mentors profile with oversize image")
    public void putUpdateMentorsProfileWithOversizeImage() {
        mentorsAPI.setPutUpdateMentorsProfileWithOverSizeImage("mentors");
    }

    @Given("Put update mentors profile with invalid json")
    public void putUpdateMentorsProfileInvalidJson() {
        File jsonReq = new File(ReqBodyMentor.REQ_BODY + "InvalidPutUpdateMentorsProfileJsonReqBody.json");
        mentorsAPI.setPutUpdateMentorsProfileWithInvalidJson(jsonReq);
    }

    @Given("Put update mentors profile with valid json no auth")
    public void putUpdateMentorsProfileValidJsonNoAuth() {
        File jsonReq = new File(ReqBodyMentor.REQ_BODY + "ValidPutUpdateMentorsProfileJsonReqBody.json");
        mentorsAPI.setPutUpdateMentorsProfileWithValidJsonNoAuth(jsonReq);
    }

    @Given("Put update mentors password with valid json")
    public void putUpdateMentorsPasswordValidJson() {
        File jsonReq = new File(ReqBodyMentor.REQ_BODY + "ValidPutUpdateMentorsPasswordJsonReqBody.json");
        mentorsAPI.setPutUpdateMentorsPasswordWithValidJson(jsonReq);
    }

    @Given("Put update mentors password with invalid json")
    public void putUpdateMentorsPasswordInvalidJson() {
        File jsonReq = new File(ReqBodyMentor.REQ_BODY + "InvalidPutUpdateMentorsPasswordJsonReqBody.json");
        mentorsAPI.setPutUpdateMentorsPasswordWithInvalidJson(jsonReq);
    }

    @Given("Put update mentors password with valid json no auth")
    public void putUpdateMentorsPasswordValidJsonNoAuth() {
        File jsonReq = new File(ReqBodyMentor.REQ_BODY + "ValidPutUpdateMentorsPasswordJsonReqBody.json");
        mentorsAPI.setPutUpdateMentorsPasswordWithValidJsonNoAuth(jsonReq);
    }

    @When("Send put update mentors Profile")
    public void sendPutUpdateMentorsProfile() {
        SerenityRest.when()
                .put(MentorsAPI.PUT_UPDATE_MENTORS_PROFILE);
    }

    @When("Send put update mentors Password")
    public void sendPutUpdateMentorsPassword() {
        SerenityRest.when()
                .put(MentorsAPI.PUT_UPDATE_MENTORS_PASSWORD);
    }

    @And("Validate update mentors profile json schema")
    public void validatePutUpdateMentorProfileJsonSchema() {
        File jsonSchema = new File(JsonSchemaMentor.SCHEMA +"PutUpdateProfileMentorsJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate update mentors password json schema")
    public void validatePutUpdateMentorPasswordJsonSchema() {
        File jsonSchema = new File(JsonSchemaMentor.SCHEMA +"PutUpdatePasswordMentorsJSONSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
