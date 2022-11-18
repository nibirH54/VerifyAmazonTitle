package amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngWebDriver {

    WebDriver driver;

    @BeforeMethod
    public void browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }
    @Test

    public void verifyHomePageTitle(){
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();

    }
}
