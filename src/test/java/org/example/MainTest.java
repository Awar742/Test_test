package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



class MainTest {
    public static final String USERID = "mngr566819";
    public static final String PASSWORD  = "ezyjUqE";
    public static final String CUSTOMERID = "14636";
    public static final String VERSION = "V2";
    public static final String EXPECTED_TITLE = "GTPL Bank Edit Customer Entry Page";
   private static ChromeDriver chromeDriver;
    private static WebDriverWait wait;
    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        var chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeDriver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(chromeDriver, Duration.ofMillis(100));
    }
    @Test
    void EmptyAddress() throws InterruptedException {
        chromeDriver.get("https://demo.guru99.com/"+VERSION+"/index.php");

        var searchBox = chromeDriver.findElement(By.name("uid"));
        searchBox.sendKeys(USERID);
        searchBox = chromeDriver.findElement(By.name("password"));
        searchBox.sendKeys(PASSWORD);
        searchBox = chromeDriver.findElement(By.name("btnLogin"));
        searchBox.click();
        chromeDriver.get("https://demo.guru99.com/"+VERSION+"/webpages/EditCustomer.php");
        searchBox = chromeDriver.findElement(By.name("cusid"));
        searchBox.sendKeys(CUSTOMERID);
        searchBox = chromeDriver.findElement(By.name("AccSubmit"));
        searchBox.click();

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
    @Test
    void EmptyFirstCharOfAddress() throws InterruptedException {
        chromeDriver.get("https://demo.guru99.com/"+VERSION+"/index.php");

        var searchBox = chromeDriver.findElement(By.name("uid"));
        searchBox.sendKeys(USERID);
        searchBox = chromeDriver.findElement(By.name("password"));
        searchBox.sendKeys(PASSWORD);
        searchBox = chromeDriver.findElement(By.name("btnLogin"));
        searchBox.click();
        chromeDriver.get("https://demo.guru99.com/"+VERSION+"/webpages/EditCustomer.php");
        searchBox = chromeDriver.findElement(By.name("cusid"));
        searchBox.sendKeys(CUSTOMERID);
        searchBox = chromeDriver.findElement(By.name("AccSubmit"));
        searchBox.click();

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
    void SpecialFirstCharOfAddress() throws InterruptedException {
        chromeDriver.get("https://demo.guru99.com/"+VERSION+"/index.php");

        var searchBox = chromeDriver.findElement(By.name("uid"));
        searchBox.sendKeys(USERID);
        searchBox = chromeDriver.findElement(By.name("password"));
        searchBox.sendKeys(PASSWORD);
        searchBox = chromeDriver.findElement(By.name("btnLogin"));
        searchBox.click();
        chromeDriver.get("https://demo.guru99.com/"+VERSION+"/webpages/EditCustomer.php");
        searchBox = chromeDriver.findElement(By.name("cusid"));
        searchBox.sendKeys(CUSTOMERID);
        searchBox = chromeDriver.findElement(By.name("AccSubmit"));
        searchBox.click();

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
    void SpecialFirstCharOfCity() throws InterruptedException {
        chromeDriver.get("https://demo.guru99.com/"+VERSION+"/index.php");

        var searchBox = chromeDriver.findElement(By.name("uid"));
        searchBox.sendKeys(USERID);
        searchBox = chromeDriver.findElement(By.name("password"));
        searchBox.sendKeys(PASSWORD);
        searchBox = chromeDriver.findElement(By.name("btnLogin"));
        searchBox.click();
        chromeDriver.get("https://demo.guru99.com/"+VERSION+"/webpages/EditCustomer.php");
        searchBox = chromeDriver.findElement(By.name("cusid"));
        searchBox.sendKeys(CUSTOMERID);
        searchBox = chromeDriver.findElement(By.name("AccSubmit"));
        searchBox.click();

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
    void EmptyCity() throws InterruptedException {
        chromeDriver.get("https://demo.guru99.com/"+VERSION+"/index.php");

        var searchBox = chromeDriver.findElement(By.name("uid"));
        searchBox.sendKeys(USERID);
        searchBox = chromeDriver.findElement(By.name("password"));
        searchBox.sendKeys(PASSWORD);
        searchBox = chromeDriver.findElement(By.name("btnLogin"));
        searchBox.click();
        chromeDriver.get("https://demo.guru99.com/"+VERSION+"/webpages/EditCustomer.php");
        searchBox = chromeDriver.findElement(By.name("cusid"));
        searchBox.sendKeys(CUSTOMERID);
        searchBox = chromeDriver.findElement(By.name("AccSubmit"));
        searchBox.click();

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