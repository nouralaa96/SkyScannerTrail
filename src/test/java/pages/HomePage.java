package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    By destinationLocator = By.id("destinationInput-input");
     By departDateLocator = By.xpath("//button[@data-testid='depart-btn']//span[contains(text(),'Add date')]");
    By searchForFlightLocator = By.xpath("//button[@data-testid='CalendarSearchButton']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setSearchForFlightOneWay(String destination, String departDate) {
        // Enter departure and destination airports
        WebElement destinationInput = wait.until(ExpectedConditions.elementToBeClickable(destinationLocator));
        destinationInput.clear();
        destinationInput.sendKeys(destination);
        destinationInput.sendKeys(Keys.RETURN);
      //  click depart date
        driver.findElement(departDateLocator).click();

        // Choose departure date
        selectDepartureDate(departDate);

        // Click the search button
        wait.until(ExpectedConditions.elementToBeClickable(searchForFlightLocator)).click();
    }

    public void selectDepartureDate(String desiredDate) {

        String xpathExpression = String.format("//button[@aria-label='%s. Select as departure date']", desiredDate);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression))).click();
    }
}