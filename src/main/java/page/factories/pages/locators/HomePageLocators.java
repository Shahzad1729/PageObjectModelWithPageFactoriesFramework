package page.factories.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

    @FindBy(css="#filters > form:nth-child(3) > div > select")
    public WebElement sortByDropdown;

    @FindBy(css = "#search-query")
    public WebElement searchField;

    @FindBy(css="#filters > form.ng-pristine.ng-invalid.ng-touched > div > button.btn.btn-secondary")
    public WebElement searchBtn;

    @FindBy(css="#menu")
    public WebElement loggedInUserName;

    @FindBy(css="#navbarSupportedContent > ul > li:nth-child(4) > ul > li:nth-child(7) > a")
    public WebElement signOutBtn;

}
