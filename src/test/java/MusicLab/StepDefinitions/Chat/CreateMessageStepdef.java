package MusicLab.StepDefinitions.Chat;

import MusicLab.API.Chat.ChatAPIAutomation;
import MusicLab.utilities.API_Responses;
import MusicLab.utilities.Chat.JsonSchemaChat;
import MusicLab.utilities.Chat.ReqBodyChat;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;


import java.io.File;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateMessageStepdef {
    @Steps
    ChatAPIAutomation chatAPIAutomation;

//1
    @Given("Create message with valid parameter")
    public void createMessageWithValidParameter() {
        File reqBody = new File(ReqBodyChat.RB_VALID_PAR_CHAT);
        chatAPIAutomation.setPostCreateMessage(reqBody);
    }

    @When("Send request post create message")
    public void sendRequestPostCreateMessage() {
        SerenityRest.when().post(ChatAPIAutomation.POST_CREATE_MESSAGE);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Respon body message should be {string}")
    public void responBodyMessageShouldBe(String message) {
        SerenityRest.then()
                .body(API_Responses.message,equalTo(message));
    }

    @And("Validate create messsage valid parameter with json schema")
    public void validateCreateMesssageValidParameterWithJsonSchema() {
        File jsValidator = new File(JsonSchemaChat.JS_VALID_PAR_CHAT);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));


    }
//2
    @Given("Create message with invalid parameter mentor_id")
    public void createMessageWithInvalidParameterMentor_id() {
        File reqBody = new File(ReqBodyChat.RB_INVALID_MENTOR_CHAT);
        chatAPIAutomation.setPostCreateMessage(reqBody);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Validate create messsage invalid parameter mentor_id with json schema")
    public void validateCreateMesssageInvalidParameterMentor_idWithJsonSchema() {
        File jsValidator = new File(JsonSchemaChat.JS_INVALID_MENTOR_CHAT);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));


    }
//3
    @Given("Create message with invalid parameter student_id")
    public void createMessageWithInvalidParameterStudent_id() {
        File reqBody = new File(ReqBodyChat.RB_INVALID_STUDENT_CHAT);
        chatAPIAutomation.setPostCreateMessage(reqBody);
    }

    @And("Validate create messsage invalid parameter student_id with json schema")
    public void validateCreateMesssageInvalidParameterStudent_idWithJsonSchema() {
        File jsValidator = new File(JsonSchemaChat.JS_INVALID_STUDENT_CHAT);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));

    }
//4
    @Given("Create message with blank or empty parameter")
    public void createMessageWithBlankOrEmptyParameter() {
        File reqBody = new File(ReqBodyChat.RB_BLANK_PAR_CHAT);
        chatAPIAutomation.setPostCreateMessage(reqBody);
    }
    @And("Validate create messsage blank parameter student_id with json schema")
    public void validateCreateMesssageBlankParameterStudent_idWithJsonSchema() {
        File jsValidator = new File(JsonSchemaChat.JS_BLANK_PAR_CHAT);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));
    }
//5
    @Given("Create message with extra parameter")
    public void createMessageWithExtraParameter() {
        File reqBody = new File(ReqBodyChat.RB_EXTRA_PAR_CHAT);
        chatAPIAutomation.setPostCreateMessage(reqBody);
    }

    @And("Validate create messsage extra parameter with json schema")
    public void validateCreateMesssageExtraParameterWithJsonSchema() {
        File jsValidator = new File(JsonSchemaChat.JS_EXTRA_PAR_CHAT);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));

    }
//6
    @Given("Create message with one parameter only")
    public void createMessageWithOneParameterOnly() {
        File reqBody = new File(ReqBodyChat.RB_ONE_PAR_CHAT);
        chatAPIAutomation.setPostCreateMessage(reqBody);
    }

    @And("Validate create messsage one parameter with json schema")
    public void validateCreateMesssageOneParameterWithJsonSchema() {
        File jsValidator = new File(JsonSchemaChat.JS_ONE_PAR_CHAT);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));

    }
//7
    @Given("Create messages longer than five hundred characters")
    public void createMessagesLongerThanFiveHundredCharacters() {
        File reqBody = new File(ReqBodyChat.RB_FIVE_HUNDRED_CHAT);
        chatAPIAutomation.setPostCreateMessage(reqBody);
    }

    @And("Validate create messsage five hundred with json schema")
    public void validateCreateMesssageFiveHundredWithJsonSchema() {
        File jsValidator = new File(JsonSchemaChat.JS_FIVE_HUNDRED_CHAT);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));

    }
//8
    @Given("Create message without characters")
    public void createMessageWithoutCharacters() {

    }
    @And("Validate create messsage without request body with json schema")
    public void validateCreateMesssageWithoutRequestBodyWithJsonSchema() {
        File jsValidator = new File(JsonSchemaChat.JS_WITHOUT_REQBODY_CHAT);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));
    }
//9
    @Given("Create message with invalid path")
    public void createMessageWithInvalidPath() {
        File reqBody = new File(ReqBodyChat.RB_INVALID_PATH_CHAT);
        chatAPIAutomation.setPostCreateMessageInvalidPath(reqBody);
    }

    @When("Send request post create message invalid path")
    public void sendRequestPostCreateMessageInvalidPath() {
        SerenityRest.when().post(ChatAPIAutomation.POST_CREATE_MESSAGE_INVALID_PATH);
    }
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("Validate create messsage with json schema")
    public void validateCreateMesssageWithJsonSchema() {
        File jsValidator = new File(JsonSchemaChat.JS_INVALID_PATH_CHAT);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));

    }



}
