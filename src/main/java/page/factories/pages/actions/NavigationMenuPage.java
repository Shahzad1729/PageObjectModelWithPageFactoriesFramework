package page.factories.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import page.factories.base.Page;
import page.factories.pages.locators.NavigationMenuPageLocators;
import page.factories.utilities.Utilities;

import java.io.IOException;

public class NavigationMenuPage extends Page {

    public NavigationMenuPageLocators navigationMenu;

    public NavigationMenuPage()
    {
        this.navigationMenu=new NavigationMenuPageLocators();
        AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this.navigationMenu);
    }

    public void goToHomePage()
    {
        click(navigationMenu.homeTab);
    }

    public void goToContactPage()
    {
        click(navigationMenu.contactTab);
    }

    public void goToCartPage()
    {
        click(navigationMenu.cartTab);
    }

    public LoginPage goToLoginPage() throws IOException {
        click(navigationMenu.signInTab);
        Utilities.captureScreenshot("Login page");
        return new LoginPage();
    }


    public void selectProductCategory(String category)
    {
        selectValueFromDropdownByVisibleText(navigationMenu.categoriesTab,category);
    }
}
