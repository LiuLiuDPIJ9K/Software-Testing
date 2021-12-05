package dpij9k;

import dpij9k.AbstractStepDef;
import io.cucumber.java.en.Given;

public class CommonStepDef extends AbstractStepDef {

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

    @Given("the {string} is filled with {string}")
    public void theFieldIsFilledWithParameter(String field, String parameter) {
        homePage.fillField(field, parameter);
    }

}
