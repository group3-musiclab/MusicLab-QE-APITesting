package MusicLab.StepDefinitions.Student;

import MusicLab.API.Student.studentAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static MusicLab.Base.JSON_REQ_BODY_USER;
import static MusicLab.Base.JSON_SCHEMA_USER;

public class StudentStepDef {
    @Steps
    studentAPI studentAPI;
    @Given("Get student data")
    public void getStudentData() {
        studentAPI.getStudentProfile();
    }

    @When("Send request get student data")
    public void sendRequestGetStudentData() {
        SerenityRest.when().get(studentAPI.GET_STUDENT_PROFILE);
    }

    @And("Validate get student data json schema")
    public void validateGetStudentDataJsonSchema() {
        File json = new File(JSON_SCHEMA_USER + "Student/GetStudentJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //put student profile valid
    @Given("Put edit student profile with valid parameter in json body")
    public void putEditStudentProfileWithValidParameterInJsonBody() {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Student/PutUpdateProfileValid.json");
        studentAPI.putStudentProfile(jsonReq);

    }

    @When("Send request put edit student profile")
    public void sendRequestPutEditStudentProfile() {
        SerenityRest.when().put(studentAPI.PUT_STUDENT_PROFILE);
    }

    @And("Validate json schema message")
    public void validateJsonSchemaMessage() {
        File json = new File(JSON_SCHEMA_USER + "Student/StudentMessageJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //put student profile invalid
    @Given("Put edit student profile with invalid parameter in json body")
    public void putEditStudentProfileWithInvalidParameterInJsonBody() {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Student/PutUpdateProfileInvalid.json");
        studentAPI.putStudentProfile(jsonReq);
    }

    //put student profile null
    @Given("Put edit student profile with null parameter in JSON body")
    public void putEditStudentProfileWithNullParameterInJSONBody() {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Student/PutUpdateProfileNull.json");
        studentAPI.putStudentProfile(jsonReq);
    }

    @When("Send request put edit student profile null parameter")
    public void sendRequestPutEditStudentProfileNullParameter() {
        SerenityRest.when().put(studentAPI.PUT_STUDENT_PROFILE);
    }

    //delete student
    @Given("Delete student to deactive profile")
    public void deleteStudentToDeactiveProfile() {
        studentAPI.deleteStudent();
    }

    @When("Send request delete student")
    public void sendRequestDeleteStudent() {
        SerenityRest.when().delete(studentAPI.DELETE_STUDENT);
    }

    //put edit password
    @Given("Put edit student password with valid parameter in json body")
    public void putEditStudentPasswordWithValidParameterInJsonBody() {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Student/PutUpdatePasswordValid.json");
        studentAPI.putStudentPassword(jsonReq);
    }

    @When("Send request put edit student password")
    public void sendRequestPutEditStudentPassword() {
        SerenityRest.when().put(studentAPI.PUT_STUDENT_PASSWORD);
    }

    //put update password invalid
    @Given("Put edit student password with invalid parameter in json body")
    public void putEditStudentPasswordWithInvalidParameterInJsonBody() {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Student/PutUpdatePasswordInvalid.json");
        studentAPI.putStudentPassword(jsonReq);
    }

    //put update password null
    @Given("Put edit student password with null parameter in JSON body")
    public void putEditStudentPasswordWithNullParameterInJSONBody() {
        File jsonReq = new File(JSON_REQ_BODY_USER+"Student/PutUpdatePasswordNull.json");
        studentAPI.putStudentPassword(jsonReq);
    }

    @When("Send request put edit student password null parameter")
    public void sendRequestPutEditStudentPasswordNullParameter() {
        SerenityRest.when().put(studentAPI.PUT_STUDENT_PASSWORD);
    }
}
