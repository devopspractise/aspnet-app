package SampleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		 String browserText=driver.findElement(By.xpath("//h2[contains(text(),'Hello World!')]")).getText();
			System.out.println(browserText);
			Assert.assertTrue(browserText.equals("Hello World!"));
			driver.close();
		
	}

}
