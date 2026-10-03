package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.constants.Constants;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By dashboardTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    private By timeAtWork = By.xpath("//p[normalize-space()='Time at Work']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME));
    }

    public String getDashboardTitle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(dashboardTitle)
        ).getText();
    }

    public String getTimeAtWorkText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(timeAtWork)).getText();
    }
}