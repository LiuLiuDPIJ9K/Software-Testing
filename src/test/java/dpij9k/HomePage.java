package dpij9k;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private static final String PAGE_URL = "http://automationpractice.com/";

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }
//-------------------------------------------------------------------------------------------------
    @FindBy(id = "contact-link")
    private WebElement contactButton;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;
//-----
    @FindBy(className = "login")
    private WebElement signInButton;

    @FindBy(id = "SubmitCreate")
    private WebElement createButton;
//-----
    @FindBy(name = "submitNewsletter")
    private WebElement okButton;
//-----
    @FindBy(id = "submitAccount")
    private WebElement registerButton;
//-------------------------------------------------------------------------------------------------
    public void fillField(String field, String value) {
        getField(By.id(field)).sendKeys(value);
    }

    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }
//-------------------------------------------------------------------------------------------------
    public void clickContactButton() {
        contactButton.click();
    }

    public void clickSendButton(){
        sendButton.click();
    }
//-----
    public void clickSignInButton(){signInButton.click();}

    public void clickCreateButton(){createButton.click();}
//-----
    public void clickOkButton(){okButton.click();}
//-----
    public void clickRegisterButton(){registerButton.click();}
//-------------------------------------------------------------------------------------------------
    private static final By Contact_ERROR = By.xpath("//*[@id=\"center_column\"]/div/ol/li");

    private static final By Create_ERROR = By.xpath("//*[@id=\"create_account_error\"]/ol/li");

    private static final By News_ERROR = By.xpath("//*[@id=\"columns\"]/p/text()");

    private static final By Register_ERROR = By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]");

    public Optional<String> getContactError() {
        return getErrorMessage(Contact_ERROR);
    }

    public Optional<String> getCreateError() {
        return getErrorMessage(Create_ERROR);
    }

    public Optional<String> getNewsError() {
        return getErrorMessage(News_ERROR);
    }

    public Optional<String> getRegisterError() {
        return getErrorMessage(Register_ERROR);
    }

    private Optional<String> getErrorMessage(By errorLocator) {
        Optional<WebElement> error = getError(errorLocator);
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> getError(By errorLocator) {
        List<WebElement> elements = driver.findElements(errorLocator);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }
}
