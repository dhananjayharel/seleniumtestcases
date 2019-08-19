import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import org.openqa.selenium.firefox.FirefoxBinary;
public class WebTest {
public static void main(String[] args) {
// Create a new instance of the Firefox driver
/*
String Xport = System.getProperty("lmportal.xvfb.id", ":1");
        final File firefoxPath = new File(System.getProperty("lmportal.deploy.firefox.path", "/usr/bin/firefox"));
        FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath);
        firefoxBinary.setEnvironmentProperty("DISPLAY", Xport);

        // Start Firefox driver
       // WebDriver driver = new FirefoxDriver(firefoxBinary, null);
	//System.setProperty("webdriver.gecko.driver", "/opt/SILENIUM/geckodriver");
	FirefoxOptions options = new FirefoxOptions();
options.setBinary(firefoxBinary);
	
	WebDriver driver = new FirefoxDriver(options);

  */
  
     System.setProperty("phantomjs.binary.path", "/opt/phantomjs2/phantomjs/bin/phantomjs");
        
		
		DesiredCapabilities DesireCaps = new DesiredCapabilities();
DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/opt/phantomjs2/phantomjs/bin/phantomjs");
WebDriver driver = new PhantomJSDriver(DesireCaps);
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
	MailSender.sendMail(true);
}
//Close the browser.
driver.close();
}
}