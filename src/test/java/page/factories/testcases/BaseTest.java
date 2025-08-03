package page.factories.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.google.common.base.Throwables;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import page.factories.base.Page;

import java.lang.reflect.Method;
import java.util.Arrays;

public class BaseTest extends Page {


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestResult testResult, Method method) {
        try {
            String strMethodName = testResult.getMethod().getMethodName();
            ExtentReports localReports = extentReports;
            extentTest=localReports.createTest(strMethodName);
            extentTest.assignCategory(method.getDeclaringClass().getName());
        } catch (Exception e) {
            log.info("Exception occurred in beforeMethod due to : " + e.getMessage());
            e.printStackTrace();
            throw new SkipException("Skipped in BeforeMethod");
        }
        log.info("Before Method completed ----------------------------------------------------");
    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult testResult, Method method) {
        try {
            if (testResult.getStatus() != ITestResult.SUCCESS) {
                String ex = Throwables.getStackTraceAsString(testResult.getThrowable());
                log.info("StackTrace: " + ex);
                log.info("StackTrace done ");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Object[] parameters = testResult.getParameters();
            log.info("DataProvider Value:" + Arrays.toString(parameters));
            extentTest.getModel().setDescription(testResult.getMethod().getDescription());
            extentTest.getModel().setName(method.getName() + Arrays.toString(parameters));

        } catch (Exception e) {
            e.printStackTrace();
            String ex = Throwables.getStackTraceAsString(testResult.getThrowable());
            log.info("StackTrace: " + ex);
            log.info("StackTrace done ");
            log.info("Exception occurred in aftermethod due to : " + e.getMessage());
        } finally {
            extentReports.flush();
            log.debug("Report flushed..");
        }
    }


    @AfterSuite
    public void tearDown() throws InterruptedException {
        quiteBrowser();
    }

}
