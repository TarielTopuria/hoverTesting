import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverTesting extends TestData{
    WebDriver chromeDriver;
    WebDriver edgeDriver;
    WebDriver mozillaDriver;

    @Before
    public void driverUpdater(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
        WebDriverManager.edgedriver().setup();
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void chromeTest(){
        chromeDriver = new ChromeDriver();
        chromeDriver.get(baseURL);
        WebElement img1 = chromeDriver.findElement(By.xpath(img1Xpath));
        Actions actionHover = new Actions(chromeDriver);
        actionHover.moveToElement(img1).perform();
        WebElement textToDisplay = chromeDriver.findElement(By.xpath(textXpath));
        Assert.assertTrue("text is displayed", textToDisplay.isDisplayed());
        chromeDriver.quit();
    }

    @Test
    public void edgeTest(){
        edgeDriver = new EdgeDriver();
        edgeDriver.get(baseURL);
        WebElement img1 = edgeDriver.findElement(By.xpath(img1Xpath));
        Actions actionHover = new Actions(edgeDriver);
        actionHover.moveToElement(img1).perform();
        WebElement textToDisplay = edgeDriver.findElement(By.xpath(textXpath));
        Assert.assertTrue("text is displayed", textToDisplay.isDisplayed());
        edgeDriver.quit();
    }

    @Test
    public void mozillaTest(){
        mozillaDriver = new FirefoxDriver();
        mozillaDriver.get(baseURL);
        WebElement img1 = mozillaDriver.findElement(By.xpath(img1Xpath));
        Actions actionHover = new Actions(mozillaDriver);
        actionHover.moveToElement(img1).perform();
        WebElement textToDisplay = mozillaDriver.findElement(By.xpath(textXpath));
        Assert.assertTrue("text is displayed", textToDisplay.isDisplayed());
        mozillaDriver.quit();
    }
}
