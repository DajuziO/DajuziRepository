package WebAutoTest.pages;

import WebAutoTest.UIFramework.BasePage;
import WebAutoTest.UIFramework.WebLocator;
import org.openqa.selenium.WebDriver;

public class AddStoreheaderPage extends BasePage {
	public AddStoreheaderPage (WebDriver driver) {
		super(driver);
	}

	WebLocator Storeheader = getLocator("Storeheader");//分销商
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
	
	public void ClickStoreheader(){
		click(Storeheader);
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
	public void addStoreheader(String Phone ) throws Exception {
		ClickStoreheader();
		InputUserName("橙子草莓测试门店负责人");
		InputTelePhone(Phone);
		InputIDCar("");
		ClickSex();
		ClickNextButton();
		Thread.sleep(3000);
	}
}
	
