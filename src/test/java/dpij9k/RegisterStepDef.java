package dpij9k;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class RegisterStepDef extends AbstractStepDef{

    @And("the Sign in is clicked")
    public void signInIsClicked(){homePage.clickSignInButton();}

    @Given("the email address is filled with {string}")
    public void theEmailAddressIsFilledWith(String arg0) {
        homePage.fillField("email_create", arg0);
    }

    @And("the Create account button is clicked")
    public void theCreateAccountButtonIsClicked() {
        homePage.clickCreateButton();
    }

    @And("the first name is filled with {string}")
    public void theFirstNameIsFilledWith(String arg0) {
        homePage.fillField("customer_firstname", arg0);
    }

    @And("the last name is filled with {string}")
    public void theLastNameIsFilledWith(String arg0) {
        homePage.fillField("customer_lastname", arg0);
    }

    @And("the password is filled with {string}")
    public void thePasswordIsFilledWith(String arg0) {
        homePage.fillField("passwd", arg0);
    }

    @And("the address is filled with {string}")
    public void theAddressIsFilledWith(String arg0) {
        homePage.fillField("address1", arg0);
    }

    @And("the city is filled with {string}")
    public void theCityIsFilledWith(String arg0) {
        homePage.fillField("city", arg0);
    }

    @And("phone number is filled with {string}")
    public void phoneNumberIsFilledWith(String arg0) {
        homePage.fillField("phone_mobile", arg0);
    }

    @When("the register button is clicked")
    public void theRegisterButtonIsClicked() {
        homePage.clickRegisterButton();
    }

    @Then("a {string} error message is shown")
    public void aErrorMessageIsShown(String arg0) {
        Optional<String> errorMessage = homePage.getRegisterError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }
}
