package tdd.approach;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Autocomplete {
	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		driver = new ChromeDriver(cr);
		driver.get("https://demo.automationtesting.in/AutoComplete.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test(priority = 1)
	public void checkAutoComplete(String str1) throws InterruptedException {
		WebElement autoOptions = driver.findElement(By.cssSelector("input#searchbox"));
		autoOptions.sendKeys(str1);
		List<WebElement> optionsToSelect = driver.findElements(By.cssSelector("#menucontainer ul li"));
		for (WebElement option : optionsToSelect) {
			System.out.println(option);
			if (option.getText().equals(str1)) {
				System.out.println("Trying to select: " + str1);
				option.click();
				Thread.sleep(1000);
				break;
			}

		}
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
		System.out.println("Execution is completed");
	}
}
