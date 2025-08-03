package page.factories.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPageLocators {

    @FindBy(css="#first_name")
    public WebElement firstName;

    @FindBy(css="#last_name")
    public WebElement lastName;

    @FindBy(css="#dob")
    public WebElement dateOfBirth; // YYYY-MM-DD

    @FindBy(css="#street")
    public WebElement streetName;

    @FindBy(css="#postal_code")
    public WebElement postalCode;

    @FindBy(css="#city")
    public WebElement cityName;

    @FindBy(css="#state")
    public WebElement stateName;

    @FindBy(css="#country")
    public WebElement selectCountryDropdown;

    @FindBy(css="#phone")
    public WebElement phoneNumber;

    @FindBy(css="#email")
    public WebElement email;

    @FindBy(css="#password")
    public WebElement password;

    @FindBy(css="[data-test='register-submit']")
    public WebElement registerBtn;
}
