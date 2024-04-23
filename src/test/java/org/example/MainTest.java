package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



class MainTest {
    private static final String USERID = "mngr566819";
    private static final String PASSWORD  = "ezyjUqE";
    private static final String CUSTOMERID = "14636";
    private static final String VERSION = "V2";
    public static final String BASE_URL = "https://demo.guru99.com/" + VERSION + "/index.php";
    private static final String EXPECTED_TITLE = "GTPL Bank Edit Customer Entry Page";
   private static ChromeDriver chromeDriver;
    private static WebDriverWait wait;
    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeDriver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(chromeDriver, Duration.ofMillis(100));
    }
    @Test
    void emptyAddress() throws InterruptedException {
        openEditCustomerPage(BASE_URL);
        org.openqa.selenium.WebElement searchBox;

        wait.until(ExpectedConditions.titleContains(EXPECTED_TITLE));
        searchBox = chromeDriver.findElement(By.name("addr"));
        searchBox.clear();

        searchBox = chromeDriver.findElement(By.name("sub"));
        searchBox.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = chromeDriver.switchTo().alert();
        assertEquals("Address field must not be blank", alert.getText());
        alert.accept();
    }

    private static void openEditCustomerPage(String VERSION) {
        chromeDriver.get(VERSION);

        var searchBox = chromeDriver.findElement(By.name("uid"));
        searchBox.sendKeys(USERID);
        searchBox = chromeDriver.findElement(By.name("password"));
        searchBox.sendKeys(PASSWORD);
        searchBox = chromeDriver.findElement(By.name("btnLogin"));
        searchBox.click();
        chromeDriver.get("https://demo.guru99.com/" + VERSION + "/webpages/EditCustomer.php");
        searchBox = chromeDriver.findElement(By.name("cusid"));
        searchBox.sendKeys(CUSTOMERID);
        searchBox = chromeDriver.findElement(By.name("AccSubmit"));
        searchBox.click();
    }

    @Test
    void emptyFirstCharOfAddress() throws InterruptedException {
        openEditCustomerPage(BASE_URL);
        org.openqa.selenium.WebElement searchBox;

        wait.until(ExpectedConditions.titleContains(EXPECTED_TITLE));
        searchBox = chromeDriver.findElement(By.name("addr"));
        searchBox.clear();
        searchBox.sendKeys(" address");
        searchBox = chromeDriver.findElement(By.name("sub"));
        searchBox.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = chromeDriver.switchTo().alert();
        assertEquals("First character can not have space", alert.getText());
        alert.accept();
    }
    @Test
    void specialFirstCharOfAddress() throws InterruptedException {
        openEditCustomerPage(BASE_URL);
        org.openqa.selenium.WebElement searchBox;

        wait.until(ExpectedConditions.titleContains(EXPECTED_TITLE));
        searchBox = chromeDriver.findElement(By.name("addr"));
        searchBox.clear();
        searchBox.sendKeys("!");
        searchBox = chromeDriver.findElement(By.name("sub"));
        searchBox.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = chromeDriver.switchTo().alert();
        assertEquals("Special character are not allowed ", alert.getText());
        alert.accept();
    }
    @Test
    void specialFirstCharOfCity() throws InterruptedException {
        openEditCustomerPage(BASE_URL);
        org.openqa.selenium.WebElement searchBox;

        wait.until(ExpectedConditions.titleContains(EXPECTED_TITLE));
        searchBox = chromeDriver.findElement(By.name("city"));
        searchBox.clear();
        searchBox.sendKeys("!");
        searchBox = chromeDriver.findElement(By.name("sub"));
        searchBox.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = chromeDriver.switchTo().alert();
        assertEquals("Special character are not allowed ", alert.getText());
        alert.accept();
    }
    @Test
    void emptyCity() throws InterruptedException {
        openEditCustomerPage(BASE_URL);
        org.openqa.selenium.WebElement searchBox;

        wait.until(ExpectedConditions.titleContains(EXPECTED_TITLE));
        searchBox = chromeDriver.findElement(By.name("city"));
        searchBox.clear();

        searchBox = chromeDriver.findElement(By.name("sub"));
        searchBox.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = chromeDriver.switchTo().alert();
        assertEquals("Address field must not be blank", alert.getText());
        alert.accept();
    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }
}