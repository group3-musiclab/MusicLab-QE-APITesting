package MusicLab.StepDefinitions.Transaction;

import MusicLab.API.Transaction.TransactionAPIAutomation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetMentorStepDef {
    @Steps
    TransactionAPIAutomation transactionAPIAutomation;
    @Given("Get mentor transaction with page {int} and limit {int}")
    public void getMentorTransactionWithPagePageAndLimitLimit(int page, int limit) {
        transactionAPIAutomation.setGetMentorTransaction(page,limit);
    }

    @When("Send request get mentor transaction")
    public void sendRequestGetMentorTransaction() {
        SerenityRest.when().get(TransactionAPIAutomation.GET_MENTOR_TRANSACTION);
    }



    @When("Send request get mentor transaction invalid path")
    public void sendRequestGetMentorTransactionInvalidPath() {
        SerenityRest.when().get(TransactionAPIAutomation.GET_MENTOR_TRANSACTION_INVALID_PATH);
    }
}
