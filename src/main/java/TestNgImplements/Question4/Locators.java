package TestNgImplements.Question4;

import org.openqa.selenium.By;

public interface Locators {

    String url="https://Admin:admin123@opensource-demo.orangehrmlive.com/";

    By lUsername= By.xpath("//input[@name='username']");
    By lPassword= By.xpath("//input[@name='password']");
    By lSubmit= By.xpath("//button[@type='submit']");
    By lMainMenuAdmin=By.xpath("//div[@class='oxd-sidepanel-body']//span[text()='Admin']");
    By lAddButton=By.xpath("//div[@class='orangehrm-header-container']/button");
    By lmenuUserRoleAdmin=By.xpath("    //div[@role='option']/span[text()='Admin']");
    By lmenuStateEnabled=By.xpath("    //div[@role='option']/span[text()='Enabled']");
    By lEmployeeName1=By.xpath("    //div[@role='option' and .//*[contains(.,'Peter')]]");
    By lEmployeeName=By.xpath("//input[@placeholder='Type for hints...']");
    By lUsernameButton=By.xpath("(//div//input[@class='oxd-input oxd-input--active'])[2]");
    By lPasswordButton=By.xpath("(//div[contains(@class,'oxd-form-row')]//input[@type])[1]");
    By lConfirmPasswordButton=By.xpath("(//div[contains(@class,'oxd-form-row')]//input[@type])[2]");
    By lSaveButton=By.xpath("//button[@type='submit']");
    By systemUsersUsername=By.xpath("//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']");








}
