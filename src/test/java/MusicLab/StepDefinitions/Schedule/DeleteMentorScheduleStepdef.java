package MusicLab.StepDefinitions.Schedule;

import MusicLab.API.Schedule.ScheduleAPI;
import MusicLab.utilities.Schedule.JsonSchemaSchedule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class DeleteMentorScheduleStepdef {
    @Steps
    ScheduleAPI scheduleAPI;

    @Given("Delete schedule with valid id {int}")
    public void deleteScheduleWithValidIdId(int id) {
        scheduleAPI.setDeleteScheduleValidId(id);
    }

    @When("Send request Delete schedule")
    public void sendRequestDeleteSchedule() {
        SerenityRest.when().delete(ScheduleAPI.DELETE_SCHEDULE_VALID_ID);
    }

    @Given("Delete schedule with invalid id {string}")
    public void deleteScheduleWithInvalidIdId(String id) {
        scheduleAPI.setDeleteScheduleInvalidId(id);
    }

   @And("Validate json schema for delete schedule valid id")
    public void validateJsonSchemaForDeleteScheduleValidId() {
       File jsonSchema = new File(JsonSchemaSchedule.SCHEMA+ "DeleteScheduleValidIdJsonSchema.json");
       SerenityRest.then().assertThat()
               .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Delete schedule with empty id")
    public void deleteScheduleWithEmptyIdId() {scheduleAPI.setDeleteScheduleEmptyId();
    }



    @Given("Delete schedule with valid id {int} no authorization")
    public void deleteScheduleWithValidIdIdNoAuthorization(int id) {
        scheduleAPI.setDeleteScheduleValidIdNoAuthorization(id);
    }

    @And("Validate json schema for delete schedule no authorization")
    public void validateJsonSchemaForDeleteScheduleNoAuthorization() {
        File jsonSchema = new File(JsonSchemaSchedule.SCHEMA + "DeleteScheduleNoAuthorizationJsonSchema.json");
    SerenityRest.then().assertThat()
            .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Send request Delete schedule empty id")
    public void sendRequestDeleteScheduleEmptyId() {
        SerenityRest.when().delete(ScheduleAPI.DELETE_SCHEDULE_EMPTY_ID);
    }

    @Then("Should return status code {int} OK schedule")
    public void shouldReturnStatusCodeOK(int code) {
        SerenityRest.then().statusCode(code);
    }
}
