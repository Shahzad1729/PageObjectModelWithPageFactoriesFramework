package page.factories.testcases;

import org.testng.annotations.Test;
import page.factories.pages.actions.LoginPage;
import page.factories.pages.actions.NavigationMenuPage;
import page.factories.base.Page;
import page.factories.utilities.Utilities;

import java.io.IOException;
import java.util.Hashtable;

public class LoginTest extends BaseTest{

    @Test(dataProviderClass = Utilities.class,dataProvider = "getData")
    public void loginTest(Hashtable<String,String> data) throws InterruptedException, IOException {
        Page.initConfiguration();
        LoginPage loginPage=new NavigationMenuPage().goToLoginPage();
        loginPage.doLogin(data.get("email"),data.get("password"));
        Page.scrollDown(1);
        loginPage.verifyErrorMsgForIncorrectEmailOrPassword("Invalid email or password");
    }

}
