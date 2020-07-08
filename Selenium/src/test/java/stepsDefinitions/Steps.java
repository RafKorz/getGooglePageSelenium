package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Steps {

    WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Given("a user in a gooogle.com page")
    public void userIsOnGoogle() {
        driver.get("https://google.com");
        String currentURL = driver.getCurrentUrl();
        System.out.println("current URL: " + currentURL);
    }

    @When("the user types {string} in google input search")
    public void typeTextInput(String text) {
        input.sendKeys(text);
        driver.findElement(By.id("hplogo")).click();
    }

    @When("the user clicks on search button")
    public void uderClickOnSearch()
    {
        List<WebElement> searchButtons = driver.findElements(By.name("btnK"));
        for(WebElement searchButton : searchButtons)
        {
            if(searchButton.isDisplayed())
            {
                searchButton.click();
                break;
            }
        }

    }

    @Then("the user should see {string} on search results")
    public void assertSearchResult(String text)
    {
        String newXpath = "//*[contains(text(), '" + text + "')]";
        List<WebElement> searchResults = driver.findElements(By.xpath(newXpath));

        Assert.assertTrue("Searched text is not visible on page", searchResults.size() > 0);
    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}
