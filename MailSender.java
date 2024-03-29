import java.io.IOException;
import com.amazonaws.services.simpleemail.*;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.regions.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class MailSender {

  // Replace sender@example.com with your "From" address.
  // This address must be verified with Amazon SES.
  static final String FROM = "info@programmr.com";

  // Replace recipient@example.com with a "To" address. If your account
  // is still in the sandbox, this address must be verified.
  static final String TO = "dj@programmr.com";

  // The configuration set to use for this email. If you do not want to use a
  // configuration set, comment the following variable and the 
  // .withConfigurationSetName(CONFIGSET); argument below.
  static final String CONFIGSET = "ConfigSet";

  // The subject line for the email.
  static final String SUBJECT = "Programmr Selenium Test";
  
  // The HTML body for the email.
  static final String HTMLBODY2 = "<h1>Selenium Programmr Login Test</h1>"
      + "<p>Login with Programmr test status</p>";
	  
static final String HTMLBODY = "<h1>Amazon SES test (AWS SDK for Java)</h1>"
      + "<p>This email was sent with <a href='https://aws.amazon.com/ses/'>"
      + "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>" 
      + "AWS SDK for Java</a>";	  

  // The email body for recipients with non-HTML email clients.
  //static final String TEXTBODY = "PASSED.";
 static final String TEXTBODY = "This email was sent through Amazon SES "
      + "using the AWS SDK for Java.";
  public static void main(String[] args) throws IOException {

    try {
	 
	Properties prop = new Properties();
		InputStream input = null;	
		input = new FileInputStream("/opt/SILENIUM/mailtemplate.properties");
		// load a properties file
		prop.load(input);
		String recipients_email = prop.getProperty("recipients_email");
		
      AmazonSimpleEmailService client = 
          AmazonSimpleEmailServiceClientBuilder.standard()
          // Replace US_WEST_2 with the AWS Region you're using for
          // Amazon SES.
            .withRegion(Regions.US_EAST_1).build();
      SendEmailRequest request = new SendEmailRequest()
          .withDestination(
              new Destination().withToAddresses(recipients_email))
          .withMessage(new Message()
              .withBody(new Body()
                  .withHtml(new Content()
                      .withCharset("UTF-8").withData(HTMLBODY))
                  .withText(new Content()
                      .withCharset("UTF-8").withData(TEXTBODY)))
              .withSubject(new Content()
                  .withCharset("UTF-8").withData(SUBJECT)))
          .withSource(FROM);
          // Comment or remove the next line if you are not using a
          // configuration set 
          //.withConfigurationSetName(CONFIGSET);
      client.sendEmail(request);
      System.out.println("Email sent!");
    } catch (Exception ex) {
      System.out.println("The email was not sent. Error message: " 
          + ex.getMessage());
    }
  }
  
  public static void sendMail(String subject, String emailBody){
  
       
	    
      try {
	  System.out.println("emailBody="+emailBody);
      AmazonSimpleEmailService client = 
          AmazonSimpleEmailServiceClientBuilder.standard()
          // Replace US_WEST_2 with the AWS Region you're using for
          // Amazon SES.
            .withRegion(Regions.US_EAST_1).build();
      SendEmailRequest request = new SendEmailRequest()
          .withDestination(
              new Destination().withToAddresses(TO))
          .withMessage(new Message()
              .withBody(new Body()
                  .withHtml(new Content()
                      .withCharset("UTF-8").withData(emailBody))
                  .withText(new Content()
                      .withCharset("UTF-8").withData("PASSED")))
              .withSubject(new Content()
                  .withCharset("UTF-8").withData(subject)))
          .withSource(FROM);
          // Comment or remove the next line if you are not using a
          // configuration set 
          //.withConfigurationSetName(CONFIGSET);
      client.sendEmail(request);
      System.out.println("Email sent!");
    } catch (Exception ex) {
      System.out.println("The email was not sent. Error message: " 
          + ex.getMessage());
    } 
  
  }
  
    public static void sendMail2(String subject, String emailBody, String recipient){
  
        
	    
      try {
	  System.out.println("emailBody="+emailBody);
      AmazonSimpleEmailService client = 
          AmazonSimpleEmailServiceClientBuilder.standard()
          // Replace US_WEST_2 with the AWS Region you're using for
          // Amazon SES.
            .withRegion(Regions.US_EAST_1).build();
      SendEmailRequest request = new SendEmailRequest()
          .withDestination(
              new Destination().withToAddresses(recipient))
          .withMessage(new Message()
              .withBody(new Body()
                  .withHtml(new Content()
                      .withCharset("UTF-8").withData(emailBody))
                  .withText(new Content()
                      .withCharset("UTF-8").withData("PASSED")))
              .withSubject(new Content()
                  .withCharset("UTF-8").withData(subject)))
          .withSource(FROM);
          // Comment or remove the next line if you are not using a
          // configuration set 
          //.withConfigurationSetName(CONFIGSET);
      client.sendEmail(request);
      System.out.println("Email sent!");
    } catch (Exception ex) {
      System.out.println("The email was not sent. Error message: " 
          + ex.getMessage());
    } 
  
  }
}