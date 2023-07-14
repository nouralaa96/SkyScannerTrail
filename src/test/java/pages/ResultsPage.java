package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsPage {
    WebDriver driver ;
    WebDriverWait wait ;

    By NumberOfResultsLocator = By.xpath("//span[contains(text(),'results')]") ;


    public ResultsPage(WebDriver driver){
        this.driver =driver ;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public int getNumberOfResults(){
        String  NumberOfResults = wait.until(ExpectedConditions.visibilityOfElementLocated(NumberOfResultsLocator)).getText();
        return Integer.parseInt(NumberOfResults.replaceAll("[\\D]", ""));

    }
}
