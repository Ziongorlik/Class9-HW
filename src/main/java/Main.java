import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Main {

    static WebDriver driver;

    public static void main(String[] args) {
        assertSiteTitle();
        assertSiteURL();
        printWebElement();
        printYoutubeButton();
        printSearchBox();
        searchInAmazon();
        searchYoutube();
        selectRadioButton();
        loginToFacebook();
        disableExtension();
        clickWithJavaScript();
        closeConnections();

        // Exercise-16
        // Running tests on multiple browsers in parallel is possible.
        // There are many tools that can do it: TestComplete, LambdaTest, Browserling and more...
    }

    // Exercise-2
    public static void assertSiteTitle() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.walla.co.il");
        String siteTitleName = driver.getTitle();
        driver.navigate().refresh();
        Assert.assertEquals(siteTitleName, driver.getTitle());
    }

    // Exercise-3
    public static void assertSiteURL() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        String siteURL = driver.getCurrentUrl();
        driver.navigate().refresh();
        Assert.assertEquals(siteURL, driver.getCurrentUrl());
    }

    // Exercise-4
    public static void printWebElement() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://translate.google.com");
        WebElement translationBox = driver.findElement(By.cssSelector("textarea[class='er8xn'][autocomplete='off']"));
        System.out.println("Web Element : " + translationBox);
    }

    // Exercise-5
    public static void printYoutubeButton() {
        System.setProperty("webdriver.gecko.driver", "D:\\Computers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("https://www.youtube.com");
        WebElement youtubeButton = driver.findElement(By.id("logo-icon"));
        System.out.println("Web Element : " + youtubeButton);
    }

    // Exercise-6
    public static void printSearchBox() {
        System.setProperty("webdriver.gecko.driver", "D:\\Computers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("http://www.seleniumhq.org/");
        WebElement searchBox = driver.findElement(By.name("search"));
        System.out.println("Web Element : " + searchBox);
        searchBox.sendKeys("selenium");
    }

    // Exercise-7
    public static void searchInAmazon() {
        String title = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        Assert.assertEquals(title, driver.getTitle());
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Leather shoes");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.submit();
    }

    // Exercise-9
    public static void searchYoutube() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("be our guest");
        WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
        searchButton.submit();
    }

    // Exercise-10
    public static void selectRadioButton() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/Controllers/");
        WebElement cheeseRadio = driver.findElement(By.cssSelector("input[value='Cheese']"));
        cheeseRadio.click();
        Select selectDrop = new Select(driver.findElement(By.tagName("select")));
        selectDrop.selectByIndex(1);
        List<WebElement> selectOptions = selectDrop.getOptions();
        for (WebElement element : selectOptions) {
            System.out.println(element.getText());
        }
    }

    // Exercise-11
    public static void loginToFacebook() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebElement userNameTxtBox = driver.findElement(By.id("email"));
        WebElement passwordTxtBox = driver.findElement(By.id("pass"));
        WebElement btnLogin = driver.findElement(By.cssSelector("button[name='login']"));
        userNameTxtBox.sendKeys("myemail@gmail.com");
        passwordTxtBox.sendKeys("mypassword");
        btnLogin.submit();
    }

    // Exercise-14
    public static void disableExtension() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable--extensions");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
    }

    // Exercise-15
    public static void clickWithJavaScript() {
        System.setProperty("webdriver.chrome.driver", "D:\\Computers\\ChromeDriver-V89-Win32\\ChromeDriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
        WebElement txtboxSearch = driver.findElement(By.id("search"));
        txtboxSearch.sendKeys("doctor who theme song");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementById('search-icon-legacy').click();");
    }

    public static void closeConnections() {
        driver.quit();
    }
}