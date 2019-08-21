package WebAutoTest.pages;

import WebAutoTest.UIFramework.BasePage;
import WebAutoTest.UIFramework.WebLocator;
import org.openqa.selenium.WebDriver;

public class AddDistributorPage extends BasePage {
	public AddDistributorPage (WebDriver driver) {
		super(driver);
	}

	WebLocator Distributor = getLocator("Distributor");//分销商
	WebLocator UserNameInput = getLocator("UserNameInput");
	WebLocator TelePhoneInput = getLocator("TelePhoneInput");
	WebLocator IDCarInput = getLocator("IDCarInput");
	WebLocator SexInput = getLocator("SexInput");
	WebLocator NextButton = getLocator("NextButton");
	WebLocator ReturnButton = getLocator("ReturnButton");
	
	public void InputUserName(String UserName){
		type(UserNameInput, UserName);
	}
	public void InputTelePhone(String TelePhone){
		type(TelePhoneInput, TelePhone);
	}
	public void ClickSex(){
		click(SexInput);
	}
	
	public void ClickDistributor(){
		click(Distributor);
	}
	
	public void InputIDCar(String IDCar){
		type(IDCarInput, IDCar);
	}
	public void ClickNextButton(){
		click(NextButton);
	}
	public void ClickReturnButton(){
		click(ReturnButton);
	}
	public void adddistributor(String Phone2) throws Exception {
		ClickDistributor();
		InputUserName("橙子草莓测试分销商");
		InputTelePhone(Phone2);
		InputIDCar("");
		ClickSex();
		ClickNextButton();
		Thread.sleep(3000);
	}
}
	
