package Jenkins.GooglePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Google {
	
	@Test
	public void TC1(){
		System.setProperty("webdriver.chrome.driver", "src\\resources\\java\\Driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println(driver);
		String expectedTitle=driver.getTitle();
		
		if (expectedTitle.contentEquals("Google"))
		{
            System.out.println("WebPage Successfully Opened");
            WebElement SearchBox = driver.findElement(By.name("q"));
            
            SearchBox.sendKeys("Hello World Mohit is Here");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul/li[3]/div/div[2]/div")).click();
            driver.findElement(By.xpath("//h3[@class=\"LC20lb DKV0Md\"]")).click();
            
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            driver.navigate().back();
		}
	}
}
