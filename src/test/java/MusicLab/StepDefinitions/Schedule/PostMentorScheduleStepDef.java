package MusicLab.StepDefinitions.Schedule;

import MusicLab.API.Schedule.ScheduleAPI;
import MusicLab.utilities.API_Responses;
import MusicLab.utilities.Schedule.JsonSchemaSchedule;
import MusicLab.utilities.Schedule.ReqBodySchedule;
import com.github.fge.jsonschema.main.JsonSchema;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class PostMentorScheduleStepDef {
    @Steps
    ScheduleAPI scheduleAPI;

    @Given("Post add mentor schedule with valid json")
    public void postAddMentorScheduleWithValidJson() {
        File jsonReq = new File(ReqBodySchedule.REQ_BODY + "PostAddMentorScheduleWithValidJsonReqBody.json");
            scheduleAPI.setPostAddMentorScheduleValidJson(jsonReq);
    }


    @Given("Post add mentor schedule Availability with valid json no authorization")
    public void postAddMentorScheduleAvailabilityWithValidJsonNoAuthorization() {
        File jsonReq = new File(ReqBodySchedule.REQ_BODY + "PostAddMentorScheduleAvailabilityWithValidJsonNoAuthorizationJsonReqBody.json");
        scheduleAPI.setPostAddMentorScheduleAvailabilityValidJsonNoAuthorization(jsonReq);
    }


    @Given("Post add mentor schedule with valid json no authorization")
    public void postAddMentorScheduleWithValidJsonNoAuthorization() {
        File jsonReq = new File(ReqBodySchedule.REQ_BODY + "PostAddMentorScheduleWithValidJsonNoAuthorizationJsonReqBody.json");
        scheduleAPI.setPostAddMentorScheduleValidJsonNoAuthorization(jsonReq);

    }


    @When("Send request post add mentor Availability schedule no authorization")
    public void sendRequestPostAddMentorAvailabilityScheduleNoAuthorization() {
        SerenityRest.when().post(ScheduleAPI.POST_ADD_MENTOR_SCHEDULE_AVAILABILITY_VALID_JSON);
    }


    @When("Send request post add mentor schedule")
    public void sendRequestPostAddMentorSchedule() {
        SerenityRest.when().post(ScheduleAPI.POST_ADD_MENTOR_SCHEDULE_VALID_JSON);
    }

    @Then("Should return status code {int} Created schedule")
    public void shouldReturnStatusCodeCreated(int created) {
        SerenityRest.then().statusCode(created);

    }

    @And("Response body should contain message {string}")
    public void responseBodyShouldContainMessage(String message) {
        SerenityRest.then()
                .body(API_Responses.message, equalTo(message));
    }

    @And("Validate json schema for post add mentor schedule with valid json")
    public void validateJsonSchemaForPostAddMentorScheduleWithValidJson() {
        File jsonSchema = new File(JsonSchemaSchedule.SCHEMA+"DeleteScheduleValidIdJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post add mentor schedule with invalid json")
    public void postAddMentorScheduleWithInvalidJson() {
        File jsonReq = new File(ReqBodySchedule.REQ_BODY + "PostAddMentorScheduleWithInvalidJsonReqBody.json");
        scheduleAPI.setPostAddMentorScheduleInvalidJson(jsonReq);
    }

    @When("Send request post add mentor schedule invalid")
    public void sendRequestPostAddMentorScheduleInvalid() {
        SerenityRest.when().post(ScheduleAPI.POST_ADD_MENTOR_SCHEDULE_INVALID_JSON);
    }

    @When("Send request post add mentor schedule no authorization")
    public void sendRequestPostAddMentorScheduleNoAuthorization() {
        SerenityRest.when().post(ScheduleAPI.POST_ADD_MENTOR_SCHEDULE_VALID_JSON);
    }

    @And("Validate json schema for post add mentor schedule with invalid json")
    public void validateJsonSchemaForPostAddMentorScheduleWithInvalidJson() {
        File jsonSchema = new File(JsonSchemaSchedule.SCHEMA + "PostAddMentorScheduleWithInvalidJsonJsonSchema.json");
    }

    @Given("Post add mentor schedule with empty json")
    public void postAddMentorScheduleWithEmptyJson() {
        File jsonReq = new File(ReqBodySchedule.REQ_BODY + "PostAddMentorScheduleWithEmptyJsonJsonReqBody.json");
        scheduleAPI.setPostAddMentorScheduleEmptyJson(jsonReq);
    }

    @When("Send request post add mentor schedule empty json")
    public void sendRequestPostAddMentorScheduleEmptyJson() {
        SerenityRest.when().post(ScheduleAPI.POST_ADD_MENTOR_SCHEDULE_INVALID_JSON);
    }


    @Then("Should return status code {int} Internal Server")
    public void shouldReturnStatusCodeInternalServer(int code) {
        SerenityRest.then().statusCode(code);
    }
}
