package page.factories.testcases;

import org.testng.annotations.Test;
import page.factories.base.Page;
import page.factories.pages.actions.NavigationMenuPage;
import page.factories.utilities.Utilities;

import java.io.IOException;
import java.util.Hashtable;

public class RegisterAccountTest extends BaseTest{

    @Test(dataProviderClass = Utilities.class,dataProvider = "getData")
    public void registerAccountTest(Hashtable<String,String> data) throws InterruptedException, IOException {
        NavigationMenuPage navigationMenuPage=new NavigationMenuPage();

        String email= data.get("email")+Page.getRandomNumber(4)+"@gmail.com";
        String firstName=data.get("firstName")+Page.getRandomNumber(3);
        String lastName=data.get("lastName")+Page.getRandomNumber(3);
        String phone= String.valueOf(Page.getRandomNumber(10));

        navigationMenuPage.goToLoginPage().
                goToRegisterAccountPage().
                enterDetailsOnRegistrationPageAndClickOnRegisterButton(
                lastName,firstName,data.get("dob"),data.get("street"),data.get("postalCode").split("\\.")[0],
                        data.get("city"),data.get("state"),data.get("country"),phone,email,data.get("password")
        ).doLogin(email,data.get("password")).
        verifyNextScreenAfterLogin(lastName+" "+firstName);
    }
}