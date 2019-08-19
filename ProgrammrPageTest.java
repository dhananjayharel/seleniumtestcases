import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;	
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
public class ProgrammrPageTest {
public static void main(String[] args) throws Exception{
// Create a new instance of the Firefox driver
	System.setProperty("phantomjs.binary.path", "/opt/phantomjs2/phantomjs/bin/phantomjs");        
		//PROGRAMMR TEST
		DesiredCapabilities DesireCaps = new DesiredCapabilities();
		DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/opt/phantomjs2/phantomjs/bin/phantomjs");
		WebDriver driver = new PhantomJSDriver(DesireCaps);
		Properties prop = new Properties();
      try{
	
		InputStream input = null;	
		input = new FileInputStream("/opt/SILENIUM/mailtemplate.properties");
		// load a properties file
		prop.load(input);
		// Create a new instance of the Firefox driver
	
		
	//System.setProperty("webdriver.gecko.driver", "E:\\SELENIUM\\geckodriver.exe");
	//FirefoxOptions options = new FirefoxOptions();
	  // options.addArguments("window-size=1200x600");
	//options.addArguments("--headless");
	//WebDriver driver = new FirefoxDriver(options);



//  Wait For Page To Load
// Put a Implicit wait, this means that any search for elements on the page
//could take the time the implicit wait is set for before throwing exception 
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// Navigate to URL
	
driver.get("http://www.programmr.com/user/sign-in?op=login");
// Maximize the window.
//driver.manage().window().maximize(); 
//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
// Enter UserName
driver.findElement(By.xpath("//*[@id='edit-name']")).sendKeys("djkoder");
// Enter Password
driver.findElement(By.id("edit-pass")).sendKeys("djkoder");
// Wait For Page To Load

// Click on 'Sign In' button
driver.findElement(By.id("edit-submit")).click();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//Click on Compose Mail.
//driver.findElement(By.xpath("//div[@class='z0']/div")).click();
// Click on the image icon present in the top right navigational Bar
String text = driver.findElement(By.xpath("//*[@id='contentid']/table/tbody/tr/td[2]/h3")).getText();
//Click on 'Logout' Button
System.out.println("after login text="+text);
if(text.equals("About Dhanajay harel")){
	System.out.println("login with programmr testcase passed");
	driver.get("http://www.programmr.com/instance-variable");
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
}

//driver.get("http://www.programmr.com/embed.php?action=createTempFile&path=Atir/files/Roomreservation");

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//driver.switchTo().defaultContent();
//WebDriverWait wait = new WebDriverWait(driver, 30);
//wait.until(ExpectedConditions.visibilityOfElementLocated((By
               // .id("compileProject"))));
//*[@id="node-2915"]/div[2]/p/iframe

List<WebElement> wb = driver.findElements(By.tagName("iframe"));
int index = 0;
for(WebElement w: wb){
	
	System.out.println("INDEX="+(index)+"#################"+w.getAttribute("src"));
	if(w.getAttribute("src").contains("embed.php?action=tf")){
	  System.out.println("FOUND IFRAME AT"+index);
	  break;
	}
	index++;
}
System.out.println("OUTOFLOOP index="+index);


WebElement iframe1 = driver.findElements(By.tagName("iframe")).get(index);

//driver.switchTo().frame(iframe1);
driver.get("http://www.programmr.com/embed.php?action=tf&path=renuraman26/files/e_1360270875/Example/Example.java");
System.out.println("Driver is switched");
try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
WebElement body = driver.findElement(By.tagName("body"));
body.click();
//System.out.println("first frame@@@@@@@@@@@@@@"+driver.getPageSource());
WebElement iframe2 = driver.findElement(By.xpath("//*[@id='ifrm1']"));
driver.switchTo().frame(iframe2);
//System.out.println("after wait done"+driver.getPageSource());
System.out.println("waIT bEFORE");
try {
	Thread.sleep(10000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("waIT aFTER");
WebElement body2 = driver.findElement(By.tagName("body"));
body2.click();
System.out.println("###"+driver.findElement(By.xpath("//*[@id='tools']")).getText());
//Close the browser.
			String emailText = prop.getProperty("programmrPage");	
  
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("launch")));
		//driver.findElement(By.xpath("//*[@id='tools']")).click();
		//driver.findElement(By.xpath("//*[@id='launch']")).click();
		button.click();
		System.out.println("clicked on run button");

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("output"), "Welcome"));

		String output = driver.findElement(By.xpath("//*[@id='output']")).getText();
		//output = output.trim().replaceAll("\r\n", "");
		output = output.trim().replaceAll("[\t\n\r]", "");
		System.out.println("###"+driver.findElement(By.xpath("//*[@id='output']")).getText());
		System.out.println("OUTPUT="+output);

		if(output.equals("Welcome :1Done.")){
		  System.out.println("PASSED");

					MailSender.sendMail("Programmr Page Test: PASSED",emailText);
		}
		else
			MailSender.sendMail("Programmr Page Test: FAILED",emailText);
		//*[@id="output"]
    }
	catch(org.openqa.selenium.TimeoutException te){
	     System.out.println("Timeout exception");
		 String emailText = prop.getProperty("programmrCourse");	
		 MailSender.sendMail("Programmr Page Test: FAILED",emailText+"!! PAGE TIMEOUT");
	}

driver.close();
}
}