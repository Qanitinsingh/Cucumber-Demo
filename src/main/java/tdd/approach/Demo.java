package tdd.approach;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static WebDriver driver;
	
	@Test
	public void firstMethod()
	{
WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
	}
	
}
