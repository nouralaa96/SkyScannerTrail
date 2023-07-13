package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultsPage;

public class SearchForFlight {
    private WebDriver driver;
    public HomePage homePage;
    public  ResultsPage resultsPage;

    @BeforeMethod
    public void setUp() {
        // Set up web driver
        driver = new ChromeDriver();
        // Navigate to the website
        driver.get("https://www.skyscanner.ae");
        driver.manage().window().maximize();
        // Create an instance of HomePage
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver) ;
    }

    @Test
    public void validateSearchForFlight() {
        // Set destination and departure date
        String destination = "Dubai (DXB)";
        String departureDate = "Sunday, August 6, 2023";
        // Perform the search
        homePage.setSearchForFlightOneWay(destination, departureDate);
        Assert.assertNotEquals(resultsPage.getNumberOfResults(), 0, "Number of Results should not be zero");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
