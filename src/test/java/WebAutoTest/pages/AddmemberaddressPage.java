package pages;


import WebAutoTest.UIFramework.BasePage;
import WebAutoTest.UIFramework.WebLocator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AddmemberaddressPage extends BasePage {
	
	
	
	public AddmemberaddressPage(WebDriver driver) {
		super(driver);
	
	}

	WebLocator ProvinceChooeBox = getLocator("ProvinceChooeBox");
	WebLocator CityChooeBox = getLocator("CityChooeBox");
	WebLocator AreaChooeBox = getLocator("AreaChooeBox");
	WebLocator MailInput = getLocator("MailInput");
	WebLocator PhoneInput = getLocator("PhoneInput");
	WebLocator AddressInput = getLocator("AddressInput");
	WebLocator CommitButton = getLocator("CommitButton");
	WebLocator ReturnButton = getLocator("ReturnButton");
	WebLocator StoreNameInput = getLocator("StoreNameInput");
	WebLocator CompanyNameInput = getLocator("CompanyNameInput");

	

	
	
	public void inputMail(String Mail){
		type(MailInput,Mail);
	}
	
	public void inputStoreName(String StoreName){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String js2="document.getElementById(\"role3\").style.display='block';";//设置元素可见
		js.executeScript(js2);//执行
		type(StoreNameInput,StoreName);
		log.info(StoreNameInput.getName()+" 输入："+StoreName);
		System.out.println(StoreNameInput.getName()+" 输入："+StoreName);
	}
	public void inputCompanyName(String CompanyName){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String js2="document.getElementById(\"role2\").style.display='block';";//设置元素可见
		js.executeScript(js2);//执行
		type(CompanyNameInput,CompanyName);
		log.info(StoreNameInput.getName()+" 输入："+CompanyName);
		System.out.println(StoreNameInput.getName()+" 输入："+CompanyName);
	}
	
	public void inputPhone(String Phone){
		type(PhoneInput,Phone);
	}
	
	public void InputAddress(String Address){
		type(AddressInput,Address);
	}
	public void clickCommitButton(){
		click(CommitButton);
	}
	public void clickReturnButton(){
		click(ReturnButton);
	}
	public void clickProvinceChooeBox(){
		click(ProvinceChooeBox);
	}
	
	public void clickAreaChooeBox(){
		click(AreaChooeBox);
	}
	public void clickCityChooeBox(){
		click(CityChooeBox);
	}
	public void addChanneldealerAddress() {
		clickProvinceChooeBox();
		clickCityChooeBox();
		clickAreaChooeBox();
		InputAddress("不知道哪里");
		inputMail("1@qq.com");
		inputPhone("4996193");
		clickCommitButton();
		closeWeb();
	}
	
	public void adddistributoraddress(String CompanyName) throws Exception {
	    Thread.sleep(2000);
		inputCompanyName(CompanyName);
		clickProvinceChooeBox();
		clickCityChooeBox();
		clickAreaChooeBox();
		InputAddress("不知道哪里");
		inputMail("1@qq.com");
		inputPhone("4996193");
		Thread.sleep(3000);
		clickCommitButton();
		
	}
	
	public void addStoreheaderaddress(String StoreName) throws Exception {
	    Thread.sleep(2000);
		inputStoreName(StoreName);
		clickProvinceChooeBox();
		clickCityChooeBox();
		clickAreaChooeBox();
		InputAddress("不知道哪里");
		inputMail("1@qq.com");
		inputPhone("4996193");
		Thread.sleep(3000);
		clickCommitButton();
		
	}
}
