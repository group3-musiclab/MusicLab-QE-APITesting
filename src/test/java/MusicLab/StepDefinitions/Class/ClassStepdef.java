package MusicLab.StepDefinitions.Class;

import MusicLab.API.Class.classAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static MusicLab.Base.JSON_REQ_BODY_USER;
import static MusicLab.Base.JSON_SCHEMA_USER;

public class ClassStepdef {
    @Steps
    classAPI classAPI;

    //post create class positive
    @Given("Create a class with valid json")
    public void createClassValidJSON() {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Class/PostMakeClassValid.json");
        classAPI.postMakeClass(jsonReq);
    }
    @When("Send request post make a class")
    public void sendRequestPostMakeAClass() {
        SerenityRest.when().post(classAPI.POST_A_CLASS);
    }
    @Then("Status code should be {int} OK class")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
    @And("Validate valid post class response body")
    public void validateValidPostClassResponseBody() {
        File json = new File(JSON_SCHEMA_USER + "Class/PostMakeAClass.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //post invalid json
    @Given("Create a class with invalid json")
    public void createAClassWithInvalidJson() {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Class/PostMakeClassInvalid.json");
        classAPI.postMakeClassInvalid(jsonReq);
    }
    @Then("Status code should be {int} Bad Request class")
    public void statusCodeShouldBeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }

    @And("Validate invalid post class response body")
    public void validateInvalidPostClassResponseBody() {
        File json = new File(JSON_SCHEMA_USER + "Class/PostMakeAClass.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //post null
    @Given("Create a class with null parameter")
    public void createAClassWithInvalidPath() {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Class/PostMakeClassNull.json");
        classAPI.postMakeClassNull(jsonReq);
    }

    //get list id valid
    @Given("Get list of all class with valid or listed mentor ID {int} and page id {int}")
    public void getListOfAllClassWithInvalidOrUnlistedMentorIDId(int mentor_id, int id) {
        classAPI.getAllClassByIDMentor(mentor_id, id);
    }
    @When("Send request get list all class")
    public void sendRequestGetListAllClass() {
        SerenityRest.when().get(classAPI.GET_ALL_CLASS_BY_ID_MENTOR);
    }
    @Then("Status code should be {int} Not Found class")
    public void statusCodeShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    //get list id invalid
    @Given("Get list of all class with invalid or unlisted mentor ID {string} and page id {int}")
    public void getListOfAllClassWithValidOrListedMentorIDId(String mentor_id, int id) {
        classAPI.getAllClassByInvalidIDMentor(mentor_id, id);
    }

    @When("Send request get list all class detail")
    public void sendRequestGetListAllClassDetail() {
        SerenityRest.when().get(classAPI.GET_MENTOR_CLASS_DETAIL);
    }

    @And("Validate get list all class json schema")
    public void validateGetListAllClassJsonSchema() {
        File json = new File(JSON_SCHEMA_USER + "Class/PostMakeAClass.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // get list detail
    @Given("Get list of all class with valid or listed mentor ID {int}")
    public void getListAllClass(int class_id) {
        classAPI.getAllMentorClassDetail(class_id);
    }

    //put edit all param
    @Given("Put edit a class with valid parameters in JSON and class id {int}")
    public void putEditAClassWithValidParametersInJSON(int class_id) {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Class/PutEditClassValid.json");
        classAPI.putUpdateClass(jsonReq, class_id);
    }

    @When("Send request put edit class")
    public void sendRequestPutEditClass() {
        SerenityRest.when().put(classAPI.PUT_A_CLASS);
    }

    @Then("Status code should be {int} Created class")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Validate put update class json schema")
    public void validatePutUpdateClassJsonSchema() {
        File json = new File(JSON_SCHEMA_USER + "Class/PostMakeAClass.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //put update one param
    @Given("Put edit a class with valid one parameter in JSON and class id {int}")
    public void putEditAClassWithValidOneParameterInJSON(int class_id) {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Class/PutEditClassOneParam.json");
        classAPI.putUpdateClassOneParam(jsonReq, class_id);

    }
    @When("Send request put edit class one parameter")
    public void sendRequestPutEditClassOneParameter() {
        SerenityRest.when().put(classAPI.PUT_A_CLASS);
    }
    //put update null
    @Given("Put edit a class with null parameter in JSON body and class id {int}")
    public void putEditAClassWithNullParameterInJSONBody(int class_id) {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Class/PutEditClassNull.json");
        classAPI.putUpdateClassNullParam(jsonReq, class_id);
    }
    @When("Send request put edit class null paramter")
    public void sendRequestPutEditClassNullParamter() {
        SerenityRest.when().put(classAPI.PUT_A_CLASS);
    }
    //delete
    @Given("Delete class with token and class_id {int}")
    public void deleteClassWithToken(int class_id) {
        classAPI.deleteClass(class_id);
    }

    @When("Send request delete class")
    public void sendRequestDeleteClass() {
        SerenityRest.when().delete(classAPI.DELETE_CLASS);
    }

    @Then("Status code should be {int} No Content class")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }


}
