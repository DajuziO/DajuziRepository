package WebAutoTest.samples;

import WebAutoTest.UIFramework.BrowserFactory;
import WebAutoTest.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.AddmemberaddressPage;


public class NewTest02 {
	 String Phone1 = "18163944575";
	 String Phone2 = "18163944876";
	 String Phone3 = "18163944877";
     String username = "centling_seller";
     String password = "111111";
	 String url = "http://yscwinecms.xcook.cn:8080/cms/wine";
  @Test(priority = 0)
  public void addChanneldealer() throws Exception {
	    WebDriver driver = BrowserFactory.GetBrowser();//打开浏览器
	    Thread.sleep(2000);
		/*
		 * 登录页面
		 */
	  LoginPage lg = new LoginPage(driver);
	  lg.login(url, username, password);
		
		/*
		 * 登陆后的首页，点击团队管理——成员管理菜单
		 */
		HomePage home = new HomePage(driver);
		home.clickMeun();
		/*
		 * 成员管理页面
		 */
		MembermanagementPage membermanagement = new MembermanagementPage(driver);
		membermanagement.clickAddbutton();
		Thread.sleep(3000);
		/*
		 * 添加渠道商页面
		 */
	    AddChanneldealerPage addchannel = new AddChanneldealerPage(driver);
	    addchannel.addChanneldealer(Phone1);
		/*
		 * 添加渠道商地址信息
		 */
		AddmemberaddressPage addchanneladdress = new AddmemberaddressPage(driver);
		addchanneladdress.addChanneldealerAddress();
		
	

  }
  @Test(priority = 1)
  public void adddistributor() throws Exception {
	  WebDriver driver = BrowserFactory.GetBrowser();//打开浏览器   
	  Thread.sleep(2000);
	  /*
		 * 登录页面
		 */
	  LoginPage lg = new LoginPage(driver);
	  lg.login(url, username, password);
		
		/*
		 * 登陆后的首页，点击团队管理——成员管理菜单
		 */
		HomePage home = new HomePage(driver);
		home.clickMeun();

		/*
		 * 成员管理页面
		 */
		MembermanagementPage membermanagement = new MembermanagementPage(driver);
		Thread.sleep(1000);
		membermanagement.clickAddNextMember(Phone1);
		/*
		 * 新增角色页面：分销商
		 */
		AddDistributorPage adddistributor= new AddDistributorPage(driver);
		adddistributor.adddistributor(Phone2);

		/*
		 * 分销商地址信息
		 */
		AddmemberaddressPage adddistributoraddress = new AddmemberaddressPage(driver);
	    Thread.sleep(2000);
	    adddistributoraddress.adddistributoraddress("大橘子测试公司");
		
	  
  }
  @Test(priority = 2)
  public void addStoreheader() throws Exception {
	  WebDriver driver = BrowserFactory.GetBrowser();//打开浏览器   
	    /*
		 * 登录页面
		 */
	  LoginPage lg = new LoginPage(driver);
	  lg.login(url, username, password);
	  
		
		/*
		 * 登陆后的首页，点击团队管理——成员管理菜单
		 */
		HomePage home = new HomePage(driver);
		home.clickMeun();
			
		/*
		 * 成员管理页面
		 */
		MembermanagementPage membermanagement = new MembermanagementPage(driver);
		membermanagement.clickAddNextMember(Phone2);
		/*
		 * 新增角色页面：门店负责人
		 */
		AddStoreheaderPage addStoreheader= new AddStoreheaderPage(driver);
		addStoreheader.addStoreheader(Phone3);
	
		/*
		 * 门店负责人地址信息
		 */
		AddmemberaddressPage addStoreheaderaddress = new AddmemberaddressPage(driver);
		addStoreheaderaddress.addStoreheaderaddress("大橘子测试门店");
	  
  }
}

