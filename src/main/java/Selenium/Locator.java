package Selenium;

import org.openqa.selenium.By;

public interface Locator {

    String url="/https://opensource-demo.orangehrmlive.com";
    String username="Admin";
    String password="admin123";
    By luserName=By.xpath("//input[@name='username']");
    By lPassword=By.xpath("//input[@name='password']");
    By lloginButton=By.xpath("//button[@type='submit']");

    By lMenuAdmin=By.xpath("(//ul[@class='oxd-main-menu']//li)[1]");

    By lUserRoleSelect=By.xpath("(//div[@class='oxd-select-text-input' and @tabindex='0'])[1]");

    By lsearchButton=By.xpath("//div[@class='oxd-form-actions']//button[@type='submit']");

    By lOptionAdmin = By.xpath(".//div[@role='option' and .='Admin']");


    By lUserRoleAdmin=By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell'][3]");



}
