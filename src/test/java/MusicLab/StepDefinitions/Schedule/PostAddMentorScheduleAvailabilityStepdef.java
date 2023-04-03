package MusicLab.StepDefinitions.Schedule;

import MusicLab.API.Schedule.ScheduleAPI;
import MusicLab.utilities.API_Responses;
import MusicLab.utilities.Schedule.JsonSchemaSchedule;
import MusicLab.utilities.Schedule.ReqBodySchedule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class PostAddMentorScheduleAvailabilityStepdef {

    @Steps
    ScheduleAPI scheduleAPI;

    @Given("Post add mentor schedule Availability with valid json")
    public void postAddMentorScheduleAvailabilityWithValidJson() {
        File jsonReq = new File(ReqBodySchedule.REQ_BODY + "PostAddMentorScheduleAvailabilityValidJsonReqBody.json");
            scheduleAPI.setPostAddMentorScheduleAvailabilityValidJson(jsonReq);
    }

    @When("Send request post add mentor Availability schedule")
    public void sendRequestPostAddMentorAvailabilitySchedule() {
        SerenityRest.when().post(ScheduleAPI.POST_ADD_MENTOR_SCHEDULE_AVAILABILITY_VALID_JSON);
    }

    @And("Response body should contain {string}")
    public void responseBodyShouldContainMessageSuccess(String message) {
        SerenityRest.then()
                .body(API_Responses.message,equalTo(message));
    }

    @And("Validate json schema for post add mentor schedule Availability with valid json")
    public void validateJsonSchemaForPostAddMentorScheduleAvailabilityWithValidJson() {
        File jsonSchema = new File(JsonSchemaSchedule.SCHEMA + "PostAddMentorScheduleAvailabilityJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post add mentor schedule availability with empty json")
    public void postAddMentorScheduleAvailabilityWithEmptyJson() {
        File jsonReq = new File(ReqBodySchedule.REQ_BODY + "PostAddMentorScheduleAvailabilityWithEmptyJsonJsonReqBody.json");
        scheduleAPI.setPostAddMentorScheduleAvailabilityEmptyJson(jsonReq);
    }

    @When("Send request post add mentor Availability schedule empty json")
    public void sendRequestPostAddMentorAvailabilityScheduleEmptyJson() {
        SerenityRest.when().post(ScheduleAPI.POST_ADD_MENTOR_SCHEDULE_AVAILABILITY_EMPTY_JSON);
    }

    @Given("Post add mentor schedule availability with invalid json")
    public void postAddMentorScheduleAvailabilityWithInvalidJson() {
        File jsonReq = new File(ReqBodySchedule.REQ_BODY + "PostAddMentorScheduleAvailabilityWithInvalidJsonJsonReqBody.json");
        scheduleAPI.setPostAddMentorScheduleAvailabilityInvalidJson(jsonReq);
    }

    @When("Send request post add mentor Availability schedule invalid")
    public void sendRequestPostAddMentorAvailabilityScheduleInvalid() {
        SerenityRest.when().post(ScheduleAPI.POST_ADD_MENTOR_SCHEDULE_AVAILABILITY_INVALID_JSON);
    }
}
