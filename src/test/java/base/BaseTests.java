package base;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LandingPage;
import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class BaseTests {
    private WebDriver driver;
    protected LandingPage landingPage;
    public static Properties property;
    private static String configPath = "src/main/java/configuration/config.properties";

    @BeforeClass
    public  static void beforeClass(){
        initializePropertyFile();
    }

    @BeforeMethod
    public void setup(){
        if (property.getProperty("browserName").equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(property.getProperty("browserName").equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        goToStartPage();
        landingPage = new LandingPage(driver);
    }

    @BeforeMethod(dependsOnMethods = "setup")
    public void goToStartPage(){
        driver.get(property.getProperty("appURL"));
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot , new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterMethod(dependsOnMethods = "recordFailure")
    public void down() {
        By logoutButton = By.className("ico-logout");
        var elements = driver.findElements(logoutButton);

        //if the button "Log out" exists -> click it and close the browser, otherwise close the browser directly
            if (elements.size() > 0)
                driver.findElement(logoutButton).click();
            else
                System.out.println("The logout element is not present");

        driver.quit();
    }

    public static void initializePropertyFile(){
        property = new Properties();
        try {
            InputStream getFile = new FileInputStream(configPath);
            property.load(getFile);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getValidMail(){
        return  BaseTests.property.getProperty("validMail");
    }
    public String getValidPassword(){
        return BaseTests.property.getProperty("validPassword");
    }
    public String getInvalidPassword(){
        return BaseTests.property.getProperty("invalidPassword");
    }
    public String getInvalidUser(){
        return BaseTests.property.getProperty("invalidMail");
    }
    }