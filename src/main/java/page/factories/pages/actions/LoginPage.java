package page.factories.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import page.factories.base.Page;
import page.factories.pages.locators.LoginPageLocators;
import page.factories.utilities.Utilities;

import java.io.IOException;

public class LoginPage extends Page {

    public LoginPageLocators loginPageLocators;

    public LoginPage()
    {
        this.loginPageLocators=new LoginPageLocators();
        AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this.loginPageLocators);
    }

    public HomePage doLogin(String username,String password) throws IOException {
        type(loginPageLocators.username,username);
        type(loginPageLocators.password,password);
        Utilities.captureScreenshot("Loggin with username: "+username+", password: "+password);
        click(loginPageLocators.loginInBtn);
        return new HomePage();
    }

    public void verifyErrorMsgForIncorrectEmailOrPassword(String errorMsg) throws IOException {
        Utilities.captureScreenshot("Error Message");
        Assert.assertEquals(loginPageLocators.errorMessageForIncorrectEmailOrPassword
                .getText(),errorMsg);
    }

    public RegisterAccountPage goToRegisterAccountPage() throws InterruptedException, IOException {
        click(loginPageLocators.registerYourAccountBtn);
        Thread.sleep(3000);
        Utilities.captureScreenshot("Register Account Page");
        return new RegisterAccountPage();
    }

}
