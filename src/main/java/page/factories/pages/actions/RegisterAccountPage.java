package page.factories.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import page.factories.base.Page;
import page.factories.pages.locators.RegisterAccountPageLocators;

public class RegisterAccountPage extends Page {

    public RegisterAccountPageLocators registerAccountPageLocators;

    public RegisterAccountPage()
    {
        this.registerAccountPageLocators=new RegisterAccountPageLocators();
        AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this.registerAccountPageLocators);
    }

    public LoginPage enterDetailsOnRegistrationPageAndClickOnRegisterButton(String firstName, String lastName, String dob, String street,
                                                                            String postalCode, String city, String state, String country, String phoneNumber,
                                                                            String email, String password) throws InterruptedException {
        type(registerAccountPageLocators.firstName,firstName);
        type(registerAccountPageLocators.lastName,lastName);
        type(registerAccountPageLocators.dateOfBirth,dob);
        type(registerAccountPageLocators.streetName,street);
        type(registerAccountPageLocators.postalCode,postalCode);
        type(registerAccountPageLocators.cityName,city);

        scrollDown(2);

        type(registerAccountPageLocators.stateName,state);
        selectValueFromDropdownByValue(registerAccountPageLocators.selectCountryDropdown,country);

        type(registerAccountPageLocators.phoneNumber,phoneNumber);
        type(registerAccountPageLocators.email,email);
        type(registerAccountPageLocators.password,password);

        scrollDown(1);
        click(registerAccountPageLocators.registerBtn);
        Thread.sleep(3000);

        return new LoginPage();
    }
}
