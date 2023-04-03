package MusicLab.StepDefinitions.Chat;

import MusicLab.API.Chat.ChatAPIAutomation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetInboxListStepDef {
    @Steps
    ChatAPIAutomation chatAPIAutomation;
    @Given("Get inbox list chat")
    public void getInboxListChat() {
        chatAPIAutomation.setGetInboxList();
    }

    @When("Send request get inbox list")
    public void sendRequestGetInboxList() {
        SerenityRest.when().get(ChatAPIAutomation.GET_INBOX_LIST);
    }

    @Given("Get inbox list chat with invalid path")
    public void getInboxListChatInvalidPath() {
        chatAPIAutomation.setGetInboxListInvalidPath();
    }

    @When("Send request get inbox invalid path")
    public void sendRequestGetInboxInvalidPath() {
        SerenityRest.when().get(ChatAPIAutomation.GET_INBOX_LIST_INVALID_PATH);
    }
}
