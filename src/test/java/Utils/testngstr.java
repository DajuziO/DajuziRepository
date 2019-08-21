package Utils;
import AppAutoTest.start.Appaction;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;

public class testngstr {
	
	 public static boolean isContentAppeared(String content) {  
		 AndroidDriver  driver = Appaction.driver;
		    boolean status = false;  
		    try {  
		        driver.findElement(By.xpath("//*[contains(.,'" + content + "')]"));  
		        status = true;  
		    } catch (Exception e) {  
		        status = false;    
		    }  
		    return status;  
		}  
	 
}
