package MusicLab.StepDefinitions.Auth;

import MusicLab.API.Auth.Auth;
import MusicLab.utilities.Auth.ReqBodyAuth;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class RegisterStudentSteps {

    @Steps
    Auth auth;

    @Given("Student register with valid json data")
    public void studentRegisterWithValidJsonData() {
        File json = new File(ReqBodyAuth.REGIS_STUDENT);
        auth.login(json);
    }

    @Given("Student register with invalid json data")
    public void studentRegisterWithInvalidJsonData() {
        File json = new File(ReqBodyAuth.REGIS_STUDENT_INVALID);
        auth.login(json);
    }

    @Given("Student register with blank json data")
    public void studentRegisterWithBlankJsonData() {
        File json = new File(ReqBodyAuth.REGIS_STUDENT_BLANK);
        auth.login(json);
    }
}
