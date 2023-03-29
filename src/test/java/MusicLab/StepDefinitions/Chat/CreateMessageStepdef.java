package MusicLab.StepDefinitions.Chat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CreateMessageStepdef {
    @Steps

    @Given("Create message with valid parameter")
    public void createMessageWithValidParameter() {
    }

    @When("Send request post create message")
    public void sendRequestPostCreateMessage() {
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int arg0) {
    }

    @And("Respon body message should be {string}")
    public void responBodyMessageShouldBe(String arg0) {
    }

    @And("Validate create messsage valid parameter with json schema")
    public void validateCreateMesssageValidParameterWithJsonSchema() {
    }

    @Given("Create message with invalid parameter mentor_id")
    public void createMessageWithInvalidParameterMentor_id() {
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int arg0) {
    }

    @And("Validate create messsage invalid parameter mentor_id with json schema")
    public void validateCreateMesssageInvalidParameterMentor_idWithJsonSchema() {
    }

    @Given("Create message with invalid parameter student_id")
    public void createMessageWithInvalidParameterStudent_id() {
    }

    @And("Validate create messsage invalid parameter student_id with json schema")
    public void validateCreateMesssageInvalidParameterStudent_idWithJsonSchema() {
    }

    @Given("Create message with blank or empty parameter")
    public void createMessageWithBlankOrEmptyParameter() {
    }

    @Given("Create message with extra parameter")
    public void createMessageWithExtraParameter() {
    }

    @And("Validate create messsage extra parameter with json schema")
    public void validateCreateMesssageExtraParameterWithJsonSchema() {
    }

    @Given("Create message with one parameter only")
    public void createMessageWithOneParameterOnly() {
    }

    @And("Validate create messsage one parameter with json schema")
    public void validateCreateMesssageOneParameterWithJsonSchema() {
    }

    @Given("Create messages longer than five hundred characters")
    public void createMessagesLongerThanFiveHundredCharacters() {
    }

    @And("Validate create messsage five hundred with json schema")
    public void validateCreateMesssageFiveHundredWithJsonSchema() {
    }

    @Given("Create message without characters")
    public void createMessageWithoutCharacters() {
    }

    @Given("Create message with invalid path")
    public void createMessageWithInvalidPath() {
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int arg0) {
    }

    @And("Validate create messsage with json schema")
    public void validateCreateMesssageWithJsonSchema() {
    }
}
