package MusicLab.StepDefinitions.Transaction;

import MusicLab.API.Transaction.TransactionAPIAutomation;
import MusicLab.utilities.Transaction.JsonSchemaTransaction;
import MusicLab.utilities.Transaction.ReqBodyTransaction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class CreateTransactionStepDef {
    @Steps
    TransactionAPIAutomation transactionAPIAutomation;

//    1
    @Given("Create transaction with valid parameter")
    public void createTransactionWithValidParameter() {
        File reqBody = new File(ReqBodyTransaction.RB_VALID_PAR_TRANSACTION);
        transactionAPIAutomation.setPostTransaction(reqBody);

    }

    @When("Send request post create transaction")
    public void sendRequestPostCreateTransaction() {
        SerenityRest.when().post(TransactionAPIAutomation.POST_TRANSACTION);
    }

    @And("Validate create transaction valid parameter with json schema")
    public void validateCreateTransactionValidParameterWithJsonSchema() {
        File jsValidator = new File(JsonSchemaTransaction.JS_VALID_PAR_TRANSACTION);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));

    }
//2
    @Given("Create transaction with invalid parameter class_id")
    public void createTransactionWithInvalidParameterClass_id() {
        File reqBody = new File(ReqBodyTransaction.RB_INVALID_CLASS_TRANSACTION);
        transactionAPIAutomation.setPostTransaction(reqBody);
    }


    @And("Validate create transaction invalid parameter class_id with json schema")
    public void validateCreateTransactionInvalidParameterClass_idWithJsonSchema() {
        File jsValidator = new File(JsonSchemaTransaction.JS_INVALID_CLASS_TRANSACTION);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));

    }
//3
    @Given("Create transaction with invalid parameter schedule_id")
    public void createTransactionWithInvalidParameterSchedule_id() {
        File reqBody = new File(ReqBodyTransaction.RB_INVALID_SCHEDULE_TRANSACTION);
        transactionAPIAutomation.setPostTransaction(reqBody);
    }

    @And("Validate create transaction invalid parameter schedule_id with json schema")
    public void validateCreateTransactionInvalidParameterSchedule_idWithJsonSchema() {
        File jsValidator = new File(JsonSchemaTransaction.JS_INVALID_SCHEDULE_TRANSACTION);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));

    }
//4
    @Given("Create transaction with invalid parameter start_date")
    public void createTransactionWithInvalidParameterStart_date() {
        File reqBody = new File(ReqBodyTransaction.RB_INVALID_DATE_TRANSACTION);
        transactionAPIAutomation.setPostTransaction(reqBody);
    }

    @And("Validate create transaction invalid parameter start_date with json schema")
    public void validateCreateTransactionInvalidParameterStart_dateWithJsonSchema() {
        File jsValidator = new File(JsonSchemaTransaction.JS_INVALID_DATE_TRANSACTION);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));

    }
//5
    @Given("Create transaction with blank or empty parameter")
    public void createTransactionWithBlankOrEmptyParameter() {
        File reqBody = new File(ReqBodyTransaction.RB_BLANK_PAR_TRANSACTION);
        transactionAPIAutomation.setPostTransaction(reqBody);
    }
    @And("Validate create transaction blank parameter schedule_id with json schema")
    public void validateCreateTransactionBlankParameterSchedule_idWithJsonSchema() {
        File jsValidator = new File(JsonSchemaTransaction.JS_BLANK_PAR_TRANSACTION);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));
    }
//6
    @Given("Create transaction with extra parameter")
    public void createTransactionWithExtraParameter() {
        File reqBody = new File(ReqBodyTransaction.RB_EXTRA_PAR_TRANSACTION);
        transactionAPIAutomation.setPostTransaction(reqBody);
    }


    @And("Validate create transaction extra parameter with json schema")
    public void validateCreateTransactionExtraParameterWithJsonSchema() {
        File jsValidator = new File(JsonSchemaTransaction.JS_EXTRA_PAR_TRANSACTION);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));

    }
//7
    @Given("Create transaction with one parameter")
    public void createTransactionWithOneParameter() {
        File reqBody = new File(ReqBodyTransaction.RB_ONE_PAR_TRANSACTION);
        transactionAPIAutomation.setPostTransaction(reqBody);
    }

    @And("Validate create transaction one parameter with json schema")
    public void validateCreateTransactionOneParameterWithJsonSchema() {
        File jsValidator = new File(JsonSchemaTransaction.JS_ONE_PAR_TRANSACTION);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));

    }
//8
    @Given("Create transaction without request body")
    public void createTransactionWithoutRequestBody() {
    }
    @And("Validate create transaction without request body with json schema")
    public void validateCreateTransactionWithoutRequestBodyWithJsonSchema() {
        File jsValidator = new File(JsonSchemaTransaction.JS_WITHOUT_REQBODY_TRANSACTION);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));
    }


//9
    @Given("Create transaction with invalid path")
    public void createTransactionWithInvalidPath() {
        File reqBody = new File(ReqBodyTransaction.RB_INVALID_PATH_TRANSACTION);
        transactionAPIAutomation.setPostTransactionInvalidPath(reqBody);
    }

    @When("Send request post create transaction invalid path")
    public void sendRequestPostCreateTransactionInvalidPath() {
        SerenityRest.when().post(TransactionAPIAutomation.POST_TRANSACTION_INVALID_PATH);
    }


    @And("Validate create transaction invalid parameter with json schema")
    public void validateCreateTransactionInvalidParameterWithJsonSchema() {
        File jsValidator = new File(JsonSchemaTransaction.JS_WITHOUT_REQBODY_TRANSACTION);
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsValidator));
    }
}