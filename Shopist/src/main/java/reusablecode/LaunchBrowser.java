package reusablecode;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LaunchBrowser {
     public static WebDriver driver;
     protected static WebDriverWait wait;
   public static void launchUrl() throws IOException {
       File file = new File("src/main/resources/configuration/frameworkconfig.properties");
       FileInputStream fis = new FileInputStream(file);
       Properties prop = new Properties();
       prop.load(fis);

       switch (prop.getProperty("browser").toLowerCase()) {
           case "edge" -> driver = new EdgeDriver();
           case "chrome" -> driver = new ChromeDriver();
           case "safari" -> driver = new SafariDriver();
           default -> throw new InvalidArgumentException("enter the valid browser name");
       }

//        if (prop.getProperty("browser").equals("chrome")){
//            driver = new ChromeDriver();
//        }
//        else if (prop.getProperty("browser").equals("edge")) {
//            driver = new EdgeDriver();
//
//        }
//        else if (prop.getProperty("browser").equals("safari")) {
//            driver = new SafariDriver();
//        }
//        else {
//            throw new InvalidArgumentException("enter the valid browser name");
//        }

       wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       driver.get( prop.getProperty("url"));


   }
}
