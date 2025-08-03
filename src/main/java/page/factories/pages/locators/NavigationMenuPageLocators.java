package page.factories.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationMenuPageLocators {

    @FindBy(css="#navbarSupportedContent > ul > li:nth-child(1) > a")
    public WebElement homeTab;

    @FindBy(css = "#navbarSupportedContent > ul > li.nav-item.dropdown > a")
    public WebElement categoriesTab;

    @FindBy(css = "#navbarSupportedContent > ul > li:nth-child(3) > a")
    public WebElement contactTab;

    @FindBy(css = "#navbarSupportedContent > ul > li:nth-child(4) > a")
    public WebElement signInTab;

    @FindBy(css = "#navbarSupportedContent > ul > li:nth-child(5) > a > fa-icon > svg")
    public WebElement cartTab;

    @FindBy(css="#lblCartCount")
    public WebElement itemsCountInCart;

    @FindBy(css = "#language")
    public WebElement languageSelectBtn;

}
