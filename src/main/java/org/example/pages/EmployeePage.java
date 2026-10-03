package org.example.pages;

import org.example.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By pimMenu = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']");
    private By addButton = By.xpath("//button[normalize-space()='Add']");
    private By firstNameInput = By.name("firstName");
    private By middleNameInput = By.name("middleName");
    private By lastNameInput = By.name("lastName");
    private By saveButton = By.xpath("//button[@type='submit']");
    private By addEmployeeTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
    private By successToast =
            By.xpath("//div[contains(@class,'oxd-toast')]");




    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME));
    }

    public void clickPIM() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
    }
    public void clickAdd() {
        wait.until(
                ExpectedConditions.elementToBeClickable(addButton)
        ).click();
    }

    public void enterFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(firstName);
    }
    public void enterMiddleName(String middleName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(middleNameInput)).sendKeys(middleName);
    }
    public void enterLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput)).sendKeys(lastName);
    }
    public void clickSave(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public void addEmployee(String firstName, String middleName, String lastName){
        enterFirstName(firstName);
        enterMiddleName(middleName);
        enterLastName(lastName);
    }

    public String getSuccessMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successToast)).getText();
    }

    public String getAddEmployeeTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addEmployeeTitle)).getText();
    }
}
