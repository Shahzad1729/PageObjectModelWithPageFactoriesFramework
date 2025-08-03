package page.factories.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {

    @FindBy(css="body > app-root > div > app-login > div > div > div > div.text-center.my-4 > button")
    public WebElement signInWithGoogleBtn;

    @FindBy(css="#email")
    public WebElement username;

    @FindBy(css = "#password")
    public WebElement password;

    @FindBy(css = "body > app-root > div > app-login > div > div > div > form > div.input-group.mb-3 > input")
    public WebElement loginInBtn;

    @FindBy(css="body > app-root > div > app-login > div > div > div > div.input-group.mb-3 > p > a:nth-child(1)")
    public WebElement registerYourAccountBtn;

    @FindBy(css="body > app-root > div > app-login > div > div > div > div.input-group.mb-3 > p > a.ForgetPwd")
    public WebElement forgetPasswordBtn;

    @FindBy(css="body > app-root > div > app-login > div > div > div > div.alert.alert-danger > div")
    public WebElement errorMessageForIncorrectEmailOrPassword;
}
