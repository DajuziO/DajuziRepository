package WebAutoTest.pages;

import WebAutoTest.UIFramework.BasePage;
import WebAutoTest.UIFramework.WebLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 成员管理 页面
 * @author dajuzi
 *
 */
public class MembermanagementPage extends BasePage {
	public MembermanagementPage (WebDriver driver) {
		super(driver);
	}
	WebLocator SelectButton = getLocator("SelectButton");
	WebLocator ExportAllResultsButton = getLocator("ExportAllResultsButton");
	WebLocator ExportPartResultsButton = getLocator("ExportPartResultsButton");
	WebLocator Addbutton = getLocator("Addbutton");
	WebLocator SelectPhone = getLocator("SelectPhone");
	WebLocator SelectInput = getLocator("SelectInput");
	WebLocator StatusInput = getLocator("StatusInput");
	WebLocator AddNextMemberButton = getLocator("AddNextMemberButton");

	 		
	
	public void clickSelectButton(){
//		 WebElement iframe = driver.findElement(By.name("right"));
//	     driver.switchTo().frame(iframe);
		click(SelectButton);
	}
	public void clickSelectPhone(){
		 WebElement iframe = driver.findElement(By.name("right"));
	     driver.switchTo().frame(iframe);
		click(SelectPhone);
	}
	public void clickStatusInput(){
//		 WebElement iframe = driver.findElement(By.name("right"));
//	     driver.switchTo().frame(iframe);
		click(StatusInput);
	}

	public void clickExportAllResultsButton(){
       click(ExportAllResultsButton);
	}
	public void clickExportPartResultsButton(){
	       click(ExportPartResultsButton);
	}
	public void clickAddbutton(){
		 WebElement iframe = driver.findElement(By.name("right"));
	     driver.switchTo().frame(iframe);
	       click(Addbutton);
	}
	
	public void inputSelect(String phone){
		type(SelectInput,phone);
	}
	
	public void clickAddNextMemberButton(){
//		 WebElement iframe = driver.findElement(By.name("right"));
//	     driver.switchTo().frame(iframe);
		click(AddNextMemberButton);
	
	}
	public void clickAddNextMember(String Phone) throws Exception   {
		clickSelectPhone();
		inputSelect(Phone);
		Thread.sleep(3000);
		clickStatusInput();
		clickSelectButton();
		clickAddNextMemberButton();
	}
}
