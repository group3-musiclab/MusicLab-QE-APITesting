package MusicLab.StepDefinitions.Transaction;

import MusicLab.API.Transaction.TransactionAPIAutomation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetStudentStepDef {
    @Steps
    TransactionAPIAutomation transactionAPIAutomation;


    @Given("Get student transaction with page {int} and limit {int}")
    public void getStudentTransactionWithPagePageAndLimitLimit(int page, int limit) {
        transactionAPIAutomation.setGetStudentTransaction(page,limit);
    }

    @When("Send request get student transaction")
    public void sendRequestGetStudentTransaction() {
        SerenityRest.when().get(TransactionAPIAutomation.GET_STUDENT_TRANSACTION);
    }

    @Given("Get student transaction with page {int} and limit {int} invalid path")
    public void getStudentTransactionWithPagePageAndLimitLimitInvalidPath(int page, int limit) {
        transactionAPIAutomation.setGetStudentTransactionInvalidPath(page,limit);
    }

    @When("Send request get student transaction invalid path")
    public void sendRequestGetStudentTransactionInvalidPath() {
        SerenityRest.when().get(TransactionAPIAutomation.GET_STUDENT_TRANSACTION_INVALID_PATH);
    }


}
