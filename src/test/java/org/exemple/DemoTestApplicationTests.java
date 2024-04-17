package org.exemple;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



class DemoTestApplicationTests {

    public static final String EXPECTED_POTATO_GOOGLE_SEARCH_TITLE = "Potato! - Google Search";
    public static final String EXPECTED_POTATO_FOUND_TITLE = "Potato | Definition, Plant, Origin, & Facts | Britannica";
    private static final String EXPECTED_POTATO_PARAGRAPH = "The potato is native to the Peruvian-Bolivian Andes. It was cultivated in South America by the Incas as early as 1,800 years ago. The Spaniards who colonized South America introduced potatoes into Europe during the second half of the 16th century.";
    private static ChromeDriver chromeDriver;
    private static WebDriverWait wait;
    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
    }

    @BeforeEach
    void setUp() {
        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeDriver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(chromeDriver, Duration.ofMillis(100));
    }

    @Test
    void contextLoads() {
        chromeDriver.get("https://www.google.com");
        var searchBox = chromeDriver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("Potato!");
        searchBox.submit();
        wait.until(ExpectedConditions.titleContains(EXPECTED_POTATO_GOOGLE_SEARCH_TITLE));
        var elements = chromeDriver.findElements(By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div[3]/div/div/div/div/div/div[1]/div/div/span"));
        elements.get(0).click();
        wait.until(ExpectedConditions.titleContains(EXPECTED_POTATO_FOUND_TITLE));
        chromeDriver.findElement(By.xpath("//*[@id=\"intent-accordion\"]/h3[1]")).click();

        var paragraph = chromeDriver.findElement(By.xpath("//*[@id=\"intent-accordion\"]/div[1]/div/p"));
        assertEquals(EXPECTED_POTATO_PARAGRAPH, paragraph.getText(), "Potato paragraph not equals");
    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }
}