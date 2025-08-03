package page.factories.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import page.factories.utilities.ExcelReader;
import page.factories.utilities.ExtentManager;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class Page {

    public static WebDriver driver;
    public static FileInputStream fileInputStream;
    public static Properties config = new Properties();
    public static Properties locators = new Properties();
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static ExcelReader excel = new ExcelReader(
            System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx"
    );
    public static WebDriverWait wait;
    public static ExtentReports extentReports = ExtentManager.getInstance();
    public static ExtentTest extentTest;
    public static String browser;


    public static void initConfiguration()
    {
        // Jenkin Parameter
        if (System.getenv("browser") != null && !System.getenv().isEmpty()) {
            browser = System.getenv("browser");
        }
        // Or set from config file
        else {
            browser = Constants.browser;
        }

        if(browser.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options=new ChromeOptions();

            // Add common Chrome arguments
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");

            // Set Chrome preferences
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("profile.password_manager_leak_detection", false);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            log.debug("Chrome driver is created");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            log.debug("Firefox driver is created");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            log.debug("Edge driver is created");
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
            log.debug("IE driver is created");
        } else {
            System.out.println("Incorrect browser name!!!!!");
        }

        driver.get(Constants.testSiteUrl);
        driver.manage().window().maximize();
    }


    public void selectValueFromDropdownByVisibleText(WebElement element,String value)
    {
        extentTest.log(Status.INFO,"Selecting "+value+" from the dropdown");
        Select dropdown=new Select(element);
        dropdown.selectByVisibleText(value);
    }

    public void selectValueFromDropdownByValue(WebElement element,String value)
    {
        extentTest.log(Status.INFO,"Selecting "+value+" from the dropdown");
        Select dropdown=new Select(element);
        dropdown.selectByValue(value);
    }


    public static void scrollDown(int scrollCount) throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 0; i < scrollCount; i++) {
            try {
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);");
                extentTest.log(Status.INFO,"Scroll #" + (i + 1) + " performed.");
                Thread.sleep(1000);  // wait 500ms between scrolls
            } catch (InterruptedException e) {
                extentTest.log(Status.INFO,"Scroll interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                extentTest.log(Status.INFO,"Error during scroll: " + e.getMessage());
            }
        }
        extentTest.log(Status.INFO,"Finished " + scrollCount + " scroll attempts.");

    }

    public static int getRandomNumber(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }

        Random random = new Random();

        int min = (int) Math.pow(10, length - 1);
        int max = (int) Math.pow(10, length) - 1;

        return random.nextInt((max - min) + 1) + min;
    }


    public static void quiteBrowser() throws InterruptedException {
        driver.quit();
        log.debug("Test execution completed..");
        Thread.sleep(2000);
    }

    public void click(WebElement element)
    {
        element.click();

        extentTest.log(Status.INFO,"Clicking on element: "+element);
        log.info("Clicking on element: "+element);
    }

    public void type(WebElement element,String value)
    {
        element.sendKeys(value);

        extentTest.log(Status.INFO,"Typing in element: "+element+", value: "+value);
        log.info("Typing in element: "+element+", value: "+value);
    }
}

