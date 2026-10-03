package org.example.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Allure;
import org.example.base.BaseTest;
import org.example.utils.ReportManager;
import org.example.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileInputStream;

public class TestListener implements ITestListener {

    private static ExtentReports extent =
            ReportManager.getReportInstance();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        String browser =
                result.getTestContext()
                        .getCurrentXmlTest()
                        .getParameter("browser");

        ExtentTest extentTest =
                extent.createTest(
                        result.getName() + " - " + browser
                );

        test.set(extentTest);

        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");

        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String browser =
                result.getTestContext()
                        .getCurrentXmlTest()
                        .getParameter("browser");

        test.get().fail(result.getThrowable());

        System.out.println("Test Failed: " + result.getName());

        Object currentClass = result.getInstance();

        if (currentClass instanceof BaseTest) {

            WebDriver driver =
                    ((BaseTest) currentClass).getDriver();

            String screenshotPath =
                    ScreenshotUtils.takeScreenshot(
                            driver,
                            result.getName(),
                            browser
                    );

            if (screenshotPath != null) {

                // Extent Report
                try {
                    test.get().addScreenCaptureFromPath(
                            screenshotPath
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Allure Report
                try {
                    Allure.addAttachment(
                            "Failure Screenshot",
                            "image/png",
                            new FileInputStream(screenshotPath),
                            ".png"
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");

        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}