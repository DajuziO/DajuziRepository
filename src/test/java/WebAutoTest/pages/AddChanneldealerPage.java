package WebAutoTest.pages;

import WebAutoTest.UIFramework.BasePage;
import WebAutoTest.UIFramework.WebLocator;
import org.openqa.selenium.WebDriver;

import static jdk.nashorn.internal.objects.NativeJava.type;

/**
 * 新增角色页面
 * @author dajuzi
 *
 */
public class AddChanneldealerPage extends BasePage {

public AddChanneldealerPage (WebDriver driver) {
			super(driver);
		}


		WebLocator Channeldealer = getLocator("Channeldealer");//渠道商
		WebLocator Distributor = getLocator("Distributor");//分销商
		WebLocator Storeheader = getLocator("Storeheader"); //门店负责人
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
		public void ClickChanneldealer(){
			click(Channeldealer);
		}
		public void ClickDistributor(){
			click(Distributor);
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
		public void addChanneldealer(String Phone1 ) {
			ClickChanneldealer();
			InputUserName("橙子草莓测试");
			InputTelePhone(Phone1);
			InputIDCar("371326199807069876");
			ClickSex();
			ClickNextButton();
		}
}
