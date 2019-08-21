package WebAutoTest.UIFramework;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import Utils.ConfigUtils;
import Utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
public class BrowserFactory {
	
	private static String chromedriver;
	private static String firefox;
	private static Properties p = null;
	private static String IEDriverServer;
	private static int driverType;
	private static WebDriver driver;
	private static String config = System.getProperty("user.dir")
			+ "\\local.properties";
	static Log logger = new Log(BasePage.class);
	
	public static WebDriver GetBrowser(){
		Runtime runtime = Runtime.getRuntime();
		try {
			//如果有运行状态的浏览器，直接关闭
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");  
	        Runtime.getRuntime().exec("taskkill /F /IM iexplorer.exe");  
	        Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");  
	        Runtime.getRuntime().exec("taskkill /F /IM safari.exe");  
	        Runtime.getRuntime().exec("taskkill /F /IM opera.exe"); 
        }catch (IOException e){
            System.out.println("关闭程序异常");
            logger.error("关闭程序异常");
        }
		try {
			// 获取配置文件的路径
			p = ConfigUtils.getProperties(config);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		if (p != null) {
			// 获取配置文件的浏览器编号
			driverType = Integer.valueOf(p.getProperty("driverType"));
		}
		setUpDriver(driverType);
		return driver;
	}
	
	private static void setUpDriver(int driverType){
		switch (driverType){
        case 1:
            setUpChrome();
            break;
        case 2:
            setUpFirefox();
            break;
        case 3:
            setUpIe();
            break;
        case 4:
            setUpFirefox_Profile();
            break;
		}
	}
	/**
	 *  启动浏览器
	 */
	private static void setUpChrome(){
		chromedriver = System.getProperty("user.dir")+p.getProperty("ChromeDriver");
		System.setProperty("webdriver.chrome.driver",chromedriver);
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches",
				Arrays.asList("--start-maximized"));
		options.addArguments("--test-type", "--start-maximized");
		driver = new ChromeDriver(options);//这一步就是已经启动了浏览器了
		logger.info("启动Chrome浏览器");
	}
	
	private static void setUpFirefox(){
		firefox = System.getProperty("user.dir")+p.getProperty("FirefoxDriver");
		
		
	}
	
	private static void setUpIe(){
		
	}
	
	private static void setUpFirefox_Profile(){
		firefox = System.getProperty("user.dir")+p.getProperty("FirefoxDriver");
        org.openqa.selenium.firefox.internal.ProfilesIni allProfiles = new org.openqa.selenium.firefox.internal.ProfilesIni();
        org.openqa.selenium.firefox.FirefoxProfile profile = allProfiles.getProfile("default");
        System.setProperty("webdriver.gecko.driver", firefox);
        driver = new org.openqa.selenium.firefox.FirefoxDriver(profile);
        System.out.println("启动默认配置Firefox浏览器");
	}
}
