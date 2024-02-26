import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class App {
    @SuppressWarnings("null")
    public static void main(String[] args) throws Exception {
        
        System.setProperty("webdriver.Chrome.driver",
        "C:\\Users\\Aa\\youtubeAutomation\\MiniPrj\\src\\driver\\chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");

        WebElement songName =driver.findElement(By.name("search_query"));
        songName.sendKeys("NA READY THA VARAVA SONG");
        songName.submit();
        
        WebElement clickSong= driver.findElement(By.id("video-title"));
        clickSong.click();
        try{
            TimeUnit.SECONDS.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        TakesScreenshot screenshot = (TakesScreenshot)driver;
         for (int i=1; i<=10; i++) {
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            Files.copy(sourceFile, new File("C:\\Users\\Aa\\youtubeAutomation\\MiniPrj\\src\\FILE/screenshot.png"));
            
        }
          Thread.sleep(5000);
    driver.quit();
    }

}



