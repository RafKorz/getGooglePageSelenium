package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Given("a user in a gooogle.com page")
    public void preconditions() {
        driver.get("https://google.com");
        String currentURL = driver.getCurrentUrl();
        System.out.println("current URL: " + currentURL);
    }

    @When("the user types {string} in google input search")
    public void typeTextInput(String name) {
        WebElement input = driver.findElement(By.name("a"));
        input.sendKeys();
    }

    @When("the user clicks on search button")
    public void step2() {
        WebElement searchButton = driver.findElements(By.name("btnK")).get(0);
        searchButton.click();
    }

    @Then("the user should see sdacademy on search results")
    public void then() {

    }

    @After
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}
