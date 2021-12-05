package dpij9k;

import dpij9k.AbstractStepDef;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class NewsletterStepDef extends AbstractStepDef {

    @When("the OK button is clicked")
    public void theOKButtonIsClicked() {
        homePage.clickOkButton();
    }

    @Then("the {string} output message is shown")
    public void theMsgOutputMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getNewsError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }
}
