package AppAutoTest.start;

import Utils.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 */
public class StartApp {

    public	static AndroidDriver  driver;
    protected Log log = new Log(this.getClass());

    /**
     * app实例化启动封装
     * @throws MalformedURLException
     * @throws InterruptedException
     */
    @Test
    public void test(boolean a){
        Assert.assertTrue(a);
    }
    public  void start_up(String devicesname,String platformVersion,String appPackage ,String appActivity,String udid) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        try {
                    log.info("当前设备名称是:" + devicesname + "，设备的udid:" + udid);
        //			capabilities.setCapability("automationName", "Appium");//自动化引擎的选择
        //	        capabilities.setCapability("app", "E:\\apk\\controlpanel-debug.apk");//APK程序的路径，自动安装app
        //		    capabilities.setCapability("browserName", "chrome");//H5网页测试 指定打开浏览器
                    capabilities.setCapability("deviceName", devicesname);//手机设备名称
                    capabilities.setCapability("platformName", "Android");//手机设备系统平台
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);//这一步是因为android 7.0之后的版本上uiautomator定位某些元素操作无反应
                    capabilities.setCapability("platformVersion", platformVersion);//手机操作系统版本
                    capabilities.setCapability("appPackage", appPackage);//app的包名
                    capabilities.setCapability("appActivity", appActivity);    //app的入口名称打开被测app的
                    capabilities.setCapability("udid", udid);//设备的udid号，必须填对    860SDQAR3QTK
                    log.info("获取的udid为:" + udid);
                    capabilities.setCapability("unicodeKeyboard", true); //appium支持中文输入
                    capabilities.setCapability("resetKeyboard", true);//appium支持中文输入  //重置输入法到原有状态
                    capabilities.setCapability("newCommandTimeout", "40");//没有新命令的超时时间//退出
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//实例化手机驱动对象
                    Thread.sleep(3000);
                    log.info("APP已经打开了…………………………………………");
        } catch (Exception e) {
            log.error("APP打开失败,请检查连接设备参数，开发者模式是否打开，或者是否已经开启了appium");
            boolean a = false;
            test(a);
        }

    }
}

