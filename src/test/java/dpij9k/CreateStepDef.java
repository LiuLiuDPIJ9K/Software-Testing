package dpij9k;

import dpij9k.AbstractStepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class CreateStepDef extends AbstractStepDef {
    @And("Sign in is clicked")
    public void signInIsClicked(){
        homePage.clickSignInButton();
    }

    @When("the Create an account button is clicked")
    public void theCreateAnAccountButtonIsClicked() {
        homePage.clickCreateButton();
    }

    @Then("the {string} message is shown")
    public void theMsgMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getCreateError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }
}
