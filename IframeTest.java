
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;	
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IframeTest {
public static void main(String[] args) {
	
try {
		Properties prop = new Properties();
		InputStream input = null;	
		input = new FileInputStream("/opt/SILENIUM/mailtemplate.properties");
		// load a properties file
		prop.load(input);
		// Create a new instance of the Firefox driver
		System.setProperty("phantomjs.binary.path", "/opt/phantomjs2/phantomjs/bin/phantomjs");        
		//PEARSON TEST
		DesiredCapabilities DesireCaps = new DesiredCapabilities();
		DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/opt/phantomjs2/phantomjs/bin/phantomjs");
		WebDriver driver = new PhantomJSDriver(DesireCaps);

		System.out.println("GETTING STATUS");	
		int pageStatus = verifyURLStatus("https://pearson.programmr.com/embed.php?action=tf&path=pearson/files/ProgrammingInC4E/ch03/program0302.c");
		if(pageStatus!=200){
			String emailText = prop.getProperty("pageerror");	
			MailSender.sendMail2("URGENT!!!! PEARSON SERVER DOWN",emailText+" RESPOSE CODE ="+pageStatus,"dj@programmr.com");
			MailSender.sendMail2("URGENT!!!! PEARSON SERVER DOWN",emailText+" RESPOSE CODE ="+pageStatus,"rajesh@programmr.com");
			MailSender.sendMail2("URGENT!!!! PEARSON SERVER DOWN",emailText+" RESPOSE CODE ="+pageStatus,"info@programmr.com");
		}
		else{
				System.out.println("`````````````````````````````````");
				driver.get("https://pearson.programmr.com/embed.php?action=tf&path=pearson/files/Listing12_1");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				WebElement iframe = driver.findElement(By.xpath("//*[@id='ifrm1']"));
				driver.switchTo().frame(iframe);
				//System.out.println("after wait done"+driver.getPageSource());
				System.out.println("waIT bEFORE");
				Thread.sleep(10000);
				System.out.println("waIT aFTER");
				WebElement body = driver.findElement(By.tagName("body"));
				body.click();
				System.out.println("###"+driver.findElement(By.xpath("//*[@id='tools']")).getText());
				String status = prop.getProperty("failed");
				if(driver.findElement(By.xpath("//*[@id='tools']")).getText().equals("View Project Download Project")){
					System.out.println("testcase passed");
					status = prop.getProperty("passed");
				}
				String emailText = prop.getProperty("pearson");
				MailSender.sendMail("Selenium Pearson test",emailText+status);
				//Close the browser.
				driver.close();
		}
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

 }



public static int verifyURLStatus(String URL) {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(request);
			// verifying response code and The HttpStatus should be 200 if not,
			// increment invalid link count
			////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
			System.out.println("STATUS CODE for"+URL+" = "+response.getStatusLine().getStatusCode());
			return response.getStatusLine().getStatusCode();
			
		} catch (Exception e) {
			e.printStackTrace();
			return -99;
		}
	}
}