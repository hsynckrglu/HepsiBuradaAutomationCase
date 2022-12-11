package TestComponent;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pageObject.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseTest {

    WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "//src//main//resources//GlobalData.properties");

        properties.load(fis);
        String browserName = properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        return driver;

    }

    @BeforeMethod(alwaysRun = true)
    public MainPage baslatma() throws IOException {
        driver = initializeDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.goToURL(driver);
                return mainPage;
    }

    @AfterMethod(alwaysRun = true)
    public void kapatma(){
        driver.quit();
    }





}
