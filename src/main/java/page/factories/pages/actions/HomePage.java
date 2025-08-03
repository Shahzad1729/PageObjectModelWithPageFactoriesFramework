package page.factories.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import page.factories.base.Page;
import page.factories.pages.locators.HomePageLocators;
import page.factories.utilities.Utilities;

import java.io.IOException;

public class HomePage extends Page {
    public HomePageLocators homePageLocators;

    public HomePage() {
        this.homePageLocators = new HomePageLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this.homePageLocators);
    }

    public void verifyNextScreenAfterLogin(String username) throws IOException {
        Utilities.captureScreenshot("Checking logged in user");
        Assert.assertEquals(homePageLocators.loggedInUserName.getText(),username);
    }

    public LoginPage signOut()
    {
        click(homePageLocators.signOutBtn);
        return new LoginPage();
    }
}
