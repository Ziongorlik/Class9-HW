import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Testing {
    WebDriver driver;

    // Exercise-1.a
    @Test
    public void openSiteInChrome() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.walla.co.il");
    }

    // Exercise-1.b
    @Test
    public void openSiteInFirefox() {
        System.setProperty("webdriver.gecko.driver", "D:\\Computers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.ynet.co.il");
    }

    // Exercise-8
    @Test
    public void writeInGoogleTranslate() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://translate.google.com");
        WebElement translationBox = driver.findElement(By.cssSelector("textarea[class='er8xn'][autocomplete='off']"));
        translationBox.sendKeys("כל דבר");
    }

    // Exercise-12
    @Test
    public void Calculator() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/WebCalculator/");
        System.out.println("Button '7' dimensions : " + driver.findElement(By.id("seven")).getSize());
        System.out.println("Button '6' appears : " + driver.findElement(By.id("six")).isDisplayed());
        String number = "123";
        // input the number 100
        driver.findElement(By.id("one")).click();
        driver.findElement(By.id("zero")).click();
        driver.findElement(By.id("zero")).click();
        driver.findElement(By.id("add")).click();
        // input the number 20
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("zero")).click();
        driver.findElement(By.id("add")).click();
        // input the number 3
        driver.findElement(By.id("three")).click();
        driver.findElement(By.id("equal")).click();
        Assert.assertEquals(number, driver.findElement(By.id("screen")).getText());
    }

    // Exercise-13
    @Test
    public void Calculator2() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/WebCalculator/");
        System.out.println("Button '2' height : " + driver.findElement(By.id("two")).getSize().height);
        System.out.println("Button '6' width : " + driver.findElement(By.id("six")).getSize().width);
    }

    @AfterTest
    public void closeConnections() {
        driver.quit();
    }
}
