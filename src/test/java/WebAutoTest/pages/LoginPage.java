package WebAutoTest.pages;

import WebAutoTest.UIFramework.BasePage;
import WebAutoTest.UIFramework.WebLocator;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	
	}

	WebLocator usernameInputbox = getLocator("usernameInputbox");
	WebLocator passwordInputbox = getLocator("passwordInputbox");
	WebLocator loginButton = getLocator("loginButton");
	WebLocator WelcomeButton = getLocator("WelcomeButton");
	WebLocator loginButton01 = getLocator("loginButton01");
	WebLocator ArgeeButton = getLocator("ArgeeButton");

	
	public void inputUsername(String username){
		type(usernameInputbox,username);
	}
	
	public void inputPassword(String password){
		type(passwordInputbox,password);
	}
	
	public void clickloginButton(){
		click(loginButton);
	}
	public void clickWelcomeButton(){
		click(WelcomeButton);
	}
	public void clickloginButton01(){
		click(loginButton01);
	}
	
	public void clickArgeeButton(){
		click(ArgeeButton);
	}
	
	public void login(String url,String username,String password) throws InterruptedException {
		openWeb(url);//输入要打开的网址
		inputUsername(username);
		inputPassword(password);
		clickArgeeButton();
		clickloginButton(); 
	    Thread.sleep(3000);
	}
}
