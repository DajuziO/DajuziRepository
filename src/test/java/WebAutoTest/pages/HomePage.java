package WebAutoTest.pages;

import WebAutoTest.UIFramework.BasePage;
import WebAutoTest.UIFramework.WebLocator;
import org.openqa.selenium.WebDriver;
/**
 * 登陆后的首页
 * @author dajuzi
 *
 */
public class HomePage extends BasePage {

public HomePage (WebDriver driver) {
			super(driver);
		}
/**
 * 团队管理
 */
	WebLocator TeamMeun = getLocator("TeamMeun");//团队管理菜单
	WebLocator MemberMeun = getLocator("MemberMeun");//成员管理菜单
	WebLocator PersonalMeun = getLocator("PersonalMeun");//个人列表菜单
	WebLocator DistributorMeun = getLocator("DistributorMeun");//配送员列表菜单
	WebLocator AccountauthorityMeun = getLocator("AccountauthorityMeun");//账号权限菜单
		
		public void clickTeamMeun(){
			click(TeamMeun);
		}
		
		public void clickMemberMeun(){
			click(MemberMeun);
		}
		public void clickAccountauthorityMeun(){
			click(AccountauthorityMeun);
		}
		public void clickPersonalMeun(){
			click(PersonalMeun);
			}
		public void clickDistributorMeun(){
			click(DistributorMeun);
			}
		public void clickMeun() throws Exception {
			clickTeamMeun();
			clickMemberMeun();
			Thread.sleep(3000);
		}

}
