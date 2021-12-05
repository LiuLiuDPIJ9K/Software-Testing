package dpij9k;

import dpij9k.AbstractStepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class ContactUsStepDef extends AbstractStepDef {

    @And("Contact us is clicked")
    public void contactUsIsClicked() {
        homePage.clickContactButton();
    }

    @When("the Send button is clicked")
    public void theSendButtonIsClicked() {
        homePage.clickSendButton();
    }

    @Then("the {string} error message is shown")
    public void theMsgErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getContactError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }
}
