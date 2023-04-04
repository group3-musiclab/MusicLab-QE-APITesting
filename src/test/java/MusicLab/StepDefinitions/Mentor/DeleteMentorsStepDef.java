package MusicLab.StepDefinitions.Mentor;

import MusicLab.API.Mentor.MentorsAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class DeleteMentorsStepDef {

    @Steps
    MentorsAPI mentorsAPI;

    @Given("Delete mentors with auth")
    public void deleteMentorsWithAuth() {
        mentorsAPI.setDeleteMentorsWithAuth();
    }

    @Given("Delete mentors without auth")
    public void deleteMentorsWithoutAuth() {
        mentorsAPI.setDeleteMentorsWithNoAuth();
    }

    @When("Send request delete mentor")
    public void sendRequestDeleteMentors() {
        SerenityRest.when().delete(MentorsAPI.DELETE_MENTORS);
    }
}
