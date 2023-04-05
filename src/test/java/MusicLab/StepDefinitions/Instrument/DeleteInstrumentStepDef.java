package MusicLab.StepDefinitions.Instrument;

import MusicLab.API.Instrument.InstrumentAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteInstrumentStepDef {

    @Steps
    InstrumentAPI instrumentAPI;

    @Given("Delete instrument with valid ID {int}")
    public void deleteInstrumenValidId(int instrument_id) {
        instrumentAPI.setDeleteInstrumentWithAuth(instrument_id);
    }

    @Given("Delete instrument with invalid ID {string}")
    public void deleteInstrumentInvalidId(String id) {
        instrumentAPI.setDeleteInstrumentInvalidParameterWithAuth(id);
    }

    @Given("Delete instrument with valid ID {int} no auth")
    public void deleteInstrumentWithValidIdNoAuth(int id) {
        instrumentAPI.setDeleteInstrumentWithoutAuth(id);
    }

    @Given("Delete instrument with blank ID {}")
    public void deleteInstrumentWithBlankId() {
        instrumentAPI.setDeleteInstrumentBlankParameterWithAuth();
    }

    @When("Send request delete instrument")
    public void sendDeleteInstrument() {
        SerenityRest.when().delete(InstrumentAPI.DELETE_INSTRUMENT);
    }

    @When("Send request delete instrument not found")
    public void sendDeleteInstrumentNotFound() {
        SerenityRest.when().delete(InstrumentAPI.DELETE_INSTRUMENT_INVALID_ID);
    }

    @When("Send request delete instrument blank")
    public void sendDeleteInstrumentBlank() {
        SerenityRest.when().delete(InstrumentAPI.DELETE_INSTRUMENT_BLANK_ID);
    }

    @Then("Status code should be {int} Not Found -Mentors_Instruments")
    public void statusCodeShouldBeNotFound(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }
}
