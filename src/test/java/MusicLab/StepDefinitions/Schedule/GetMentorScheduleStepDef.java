package MusicLab.StepDefinitions.Schedule;

import MusicLab.API.Schedule.ScheduleAPI;
import MusicLab.utilities.API_Responses;
import MusicLab.utilities.Schedule.JsonSchemaSchedule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetMentorScheduleStepDef {

    @Steps ScheduleAPI scheduleAPI;


    @Given("Get mentor schedule with valid id {int}")
    public void getMentorScheduleWithValidIdId(int id) {scheduleAPI.setGetMentorSchedulesValidId(id);
    }

    @Given("Get mentor schedule with valid id {int} no authorization")
    public void getMentorScheduleWithValidIdIdNoAuthorization(int id) {scheduleAPI.setGetMentorSchedulesValidIdNoAuthorization(id);
    }

    @When("Send request get mentor schedule no authorization")
    public void sendRequestGetMentorScheduleNoAuthorization() {
        SerenityRest.when().get(ScheduleAPI.GET_MENTOR_SCHEDULE_VALID_ID);
    }

    @When("Send request get mentor schedule")
    public void sendRequestGetMentorSchedule() {
        SerenityRest.when().get(ScheduleAPI.GET_MENTOR_SCHEDULE_VALID_ID);
    }

    @And("Validate json schema for get mentor schedule")
    public void validateJsonSchemaForGetMentorSchedule() {
        File jsonSchema = new File(JsonSchemaSchedule.SCHEMA+"GetMentorScheduleJsonSchema.json");
    }

    @Given("Get mentor schedule with invalid id {string}")
    public void getMentorScheduleWithInvalidIdId(String id) {
        scheduleAPI.setGetMentorScheduleInvalidId(id);
    }

    @When("Send request get invalid mentor schedule")
    public void sendRequestGetInvalidMentorSchedule() {
        SerenityRest.when().get(ScheduleAPI.GET_MENTOR_SCHEDULE_INVALID_ID);
    }

    @Then("Should return status code {int} Bad Request schedule")
    public void shouldReturnStatusCodeBadRequest(int bad) {
        SerenityRest.then().statusCode(bad);
    }

    @Then("Should return status code {int} Unauthorized schedule")
    public void shouldReturnStatusCodeUnauthorized(int unauthorized) {
        SerenityRest.then().statusCode(unauthorized);
    }

    @Then("Should return status code {int} Not Found schedule")
    public void shouldReturnStatusCodeNotFound(int not_found) {
        SerenityRest.then().statusCode(not_found);
    }


}
