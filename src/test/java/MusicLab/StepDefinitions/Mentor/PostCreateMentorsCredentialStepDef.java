package MusicLab.StepDefinitions.Mentor;

import MusicLab.API.Mentor.MentorsAPI;
import MusicLab.utilities.Mentor.JsonSchemaMentor;
import MusicLab.utilities.Mentor.ReqBodyMentor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class PostCreateMentorsCredentialStepDef {

    @Steps
    MentorsAPI mentorsAPI;

    @Given("Post create mentor credential with valid JSON")
    public void postCreateMentorCredentialWithValidJson() {
        //File jsonReq = new File(ReqBodyMentor.REQ_BODY + "ValidPostCreateMentorsCredentialJsonReqBody.json");
        //File imageFile = new File(ReqBodyMentor.REQ_BODY + "pngtree-islamic-graduation-certificate-template-png-image_3600814.jpg");
        mentorsAPI.setPostCreateMentorsCredentialValidJSON("credentials");
    }

    @Given("Post create mentor credential with invalid JSON")
    public void postCreateMentorCredentialWithInvalidJson() {
        File jsonReq = new File(ReqBodyMentor.REQ_BODY + "InvalidPostCreateMentorsCredentialJsonReqBody.json");
        mentorsAPI.setPostCreateMentorsCredentialInvalidJSON(jsonReq);
    }

    @Given("Post create mentor credential with valid JSON no Auth")
    public void postCreateMentorCredentialWithValidJsonNoAuth() {
        File jsonReq = new File(ReqBodyMentor.REQ_BODY + "ValidPostCreateMentorsCredentialJsonReqBody.json");
        mentorsAPI.setPostCreateMentorCredentialNoAuth(jsonReq);
    }

    @When("Send post create mentor credential")
    public void sendPostCreateCredential() {
        SerenityRest.when().post(MentorsAPI.POST_CREATED_MENTORS_CREDENTIAL);
    }

    @Then("Status code should be {int} Internal server error")
    public void statusCodeShouldBeServerError(int error) {
        SerenityRest.then().statusCode(error);
    }

    @And("Validate post create mentor credential json schema")
    public void validatePostCreateCommentResourcesJsonSchema() {
        File jsonSchema = new File(JsonSchemaMentor.SCHEMA +"PostCreateMentorsCredentialJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
