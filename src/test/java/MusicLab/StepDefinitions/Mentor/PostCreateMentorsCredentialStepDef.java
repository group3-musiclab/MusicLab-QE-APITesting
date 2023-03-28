package MusicLab.StepDefinitions.Mentor;

import MusicLab.API.Instrument.InstrumentAPI;
import MusicLab.API.Mentor.MentorsAPI;
import MusicLab.utilities.API_Responses;
import MusicLab.utilities.Instrument.JsonSchemaInstrument;
import MusicLab.utilities.Instrument.ReqBodyInstrument;
import MusicLab.utilities.Mentor.JsonSchemaMentor;
import MusicLab.utilities.Mentor.ReqBodyMentor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostCreateMentorsCredentialStepDef {

    @Steps
    MentorsAPI mentorsAPI;

    @Given("Post create mentor credential with valid JSON")
    public void postCreateMentorCredentialWithValidJson() {
        File jsonReq = new File(ReqBodyMentor.REQ_BODY + "ValidPostCreateMentorCredentialJsonReqBody.json");
        mentorsAPI.setPostCreateMentorsCredentialValidJSON(jsonReq);
    }

    @Given("Post create mentor credential with invalid JSON")
    public void postCreateMentorCredentialWithInvalidJson(String post) {
        mentorsAPI.setPostCreateMentorsCredentialInvalidJSON(post);
    }

    @Given("Post create mentor credential with valid JSON no Auth")
    public void postCreateMentorCredentialWithValidJsonNoAuth() {
        File jsonReq = new File(ReqBodyInstrument.REQ_BODY + "ValidPostCreateMentorCredentialJsonReqBody.json");
        mentorsAPI.setPostCreateMentorCredentialNoAuth(jsonReq);
    }

    @When("Send post create mentor credential")
    public void sendPostCreateCredential() {
        SerenityRest.when().post(MentorsAPI.POST_CREATED_MENTORS_CREDENTIAL);
    }

    @And("Validate post create mentor credential json schema")
    public void validatePostCreateCommentResourcesJsonSchema() {
        File jsonSchema = new File(JsonSchemaMentor.SCHEMA +"PostCreateMentorsCredentialJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
