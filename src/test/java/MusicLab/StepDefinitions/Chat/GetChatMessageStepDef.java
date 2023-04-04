package MusicLab.StepDefinitions.Chat;

import MusicLab.API.Chat.ChatAPIAutomation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetChatMessageStepDef {
    @Steps
    ChatAPIAutomation chatAPIAutomation;
    @Given("Get chat contents mentor {int} and student {int}")
    public void getChatContentsPageAndLimit(int mentor, int student) {
        chatAPIAutomation.setGetChatMessage(mentor,student);
    }

    @When("Send request get chat message")
    public void sendRequestGetChatMessage() {
        SerenityRest.when().get(ChatAPIAutomation.GET_CHAT_MESSAGE);
    }

    @Given("Get chat contents mentor {int} and student {int} invalid path")
    public void getChatContentsMentorMentorAndStudentStudentInvalidPath(int mentor, int student) {
        chatAPIAutomation.setGetChatMessageInvalidPath(mentor,student);
    }

    @When("Send request get chat message invalid path")
    public void sendRequestGetChatMessageInvalidPath() {
        SerenityRest.when().get(ChatAPIAutomation.GET_CHAT_MESSAGE_INVALID_PATH);
    }


}
