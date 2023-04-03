package MusicLab.StepDefinitions.Auth;

import MusicLab.API.Auth.Auth;
import MusicLab.utilities.Auth.ReqBodyAuth;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class LoginStudentSteps {

    @Steps
    Auth auth;

    @Given("Student auth with valid json")
    public void studentLoginWithValidJson() {
        File json = new File(ReqBodyAuth.STUDENT);
        auth.login(json);
    }


//    Invalid auth
    @Given("Student auth with invalid json")
    public void studentLoginWithInvalidJson() {
        File json = new File(ReqBodyAuth.STUDENT_INVALID);
        auth.login(json);
    }


//    Blank auth
    @Given("Student auth with blank json")
    public void studentLoginWithBlankJson() {
        File json = new File(ReqBodyAuth.STUDENT_BLANK);
        auth.login(json);
    }
}
