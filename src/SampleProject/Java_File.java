package SampleProject;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Java_File {
	public WebDriver driver;
	public String urlN="http://ec2-52-14-14-57.us-east-2.compute.amazonaws.com:8080/java-tomcat-maven-example/";
	@BeforeTest
	public void before() throws MalformedURLException
	{
		/*DesiredCapabilities dc = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		 driver = new RemoteWebDriver(new URL("http://10.30.28.192:4444/wd/hub"),dc);
		    driver.get("http://ec2-3-15-210-187.us-east-2.compute.amazonaws.com:8080/java-tomcat-maven-example/");
		    driver.quit();*/
		
		
		
		/*DesiredCapabilities dc = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		String host = "35.230.246.81";
        driver = new RemoteWebDriver(new URL("http://" + host + ":4444/grid/register"), dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://ec2-3-15-210-187.us-east-2.compute.amazonaws.com:8080/java-tomcat-maven-example/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test 
	public void m1()
	{
		
		driver.get(urlN);
		WebElement el=driver.findElement(By.xpath("//h2[contains(text(),'Hello World!')]"));
		String browserText=el.getText();
		System.out.println(browserText);
		Assert.assertTrue(browserText.equals("Hello World!"));
		driver.close();
	}
	@Test
	public void m2()
	{
		  try {
			  
			  URL link = new URL(urlN);
			  HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
			  httpConn.setConnectTimeout(2000);
			  httpConn.connect();
			  if(httpConn.getResponseCode()== 200) { 
			  System.out.println(link+" - "+httpConn.getResponseMessage());
			  }
			  if(httpConn.getResponseCode()== 404) {
			  System.out.println(link+" - "+httpConn.getResponseMessage());
			  }
			  }
			  //getResponseCode method returns = IOException - if an error occurred connecting to the server. 
			  catch (Exception e) {
			  //e.printStackTrace();
			  }
		  driver.quit();
	}

}

