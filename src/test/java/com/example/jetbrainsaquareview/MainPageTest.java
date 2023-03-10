package com.example.jetbrainsaquareview;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainPageTest {
    /***
     * MartinR: This class was generated by Aqua itself, when setting up the project anew. It was modified during the review slightly.
     * This class handles the main execution of the WEB-UI tests in the 3 tests below.
     * It uses the jetbrains homepage for test purposes like the created code from Aqua also did.
     * Methods, which are actual tests, are identified by the Selenium Framework with the @Test annotations below.
     * The same logic applies for the @BeforeMethod annotation, which handles the setup step before each test.
     * The same logic applies for the @AfterMethod annotation, which handles the teardown steps after each test.
     ***/
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        // The stored chromedriver is version 108.0.5359.71, it compatible with Google chrome 108.* and was downloaded from here: https://chromedriver.chromium.org/downloads
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jetbrains.com/");

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        mainPage.searchButton.click();

        WebElement searchField = driver.findElement(By.cssSelector("[data-test='search-input']"));
        searchField.sendKeys("Selenium");

        WebElement submitButton = driver.findElement(By.cssSelector("button[data-test='full-search-button']"));
        submitButton.click();

        WebElement searchPageField = driver.findElement(By.cssSelector("input[data-test='search-input']"));
        assertEquals(searchPageField.getAttribute("value"), "Selenium");
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();

        WebElement menuPopup = driver.findElement(By.cssSelector("div[data-test='main-submenu']"));
        assertTrue(menuPopup.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        WebElement productsList = driver.findElement(By.id("products-page"));
        assertTrue(productsList.isDisplayed());
        assertEquals(driver.getTitle(), "All Developer Tools and Products by JetBrains");
    }
}
