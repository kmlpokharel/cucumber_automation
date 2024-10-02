package com.example.login;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LoginSteps {
    // Use the class-level driver for the entire test
    private WebDriver driver;

    @Given("the application is running")
    public void the_application_is_running() {
        // Set up WebDriver once here
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);  // Assign to class-level driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.expandtesting.com/login");
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        assertEquals("Test Login Page for Automation Testing Practice", driver.getTitle());
    }

    @When("the user enters a valid username and password")
    public void the_user_enters_valid_username_and_password() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("practice");
        password.sendKeys("SuperSecretPassword!");
    }


    @When("clicks the login button")
    public void clicks_login_button() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
        loginButton.click();
    }

    @Then("the user should be redirected to the dashboard with tittle {string}")
    public void the_user_should_be_redirected_to_the_dashboard_with_tittle(String expectedTitle) {
        assertEquals(expectedTitle, driver.getTitle());
    }


    @Then("see a welcome message {string}")
    public void see_a_welcome_message(String ExpectedWelcomeMessage) {
        WebElement ActualWelcomeMessage = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        assertEquals(ExpectedWelcomeMessage, ActualWelcomeMessage.getText());
    }

}
