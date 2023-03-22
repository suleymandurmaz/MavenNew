package TestNgImplements.Question3;

import org.openqa.selenium.By;

public class ProgressBarLocators {

    String url="https://demoqa.com/progress-bar";

    By lstartButton=By.xpath("//button[@id='startStopButton' and text()='Start']");
    By lProgressBar=By.cssSelector("div[role='progressbar']");
    By lResetButton=By.xpath("//button[@id='resetButton' and text()='Reset']");
    By lButton = By.cssSelector("#progressBarContainer button");






}
