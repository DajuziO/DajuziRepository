package WebAutoTest.samples;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import Utils.Log;
import Utils.PrtScr;
import WebAutoTest.UIFramework.BrowserFactory;
import WebAutoTest.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utils.ReadExcelUtil;


public class Logintest extends Utils.ReadExcelUtil {
	String url = "http://yscwinecms.xcook.cn:8080/cms/wine";

    Log log = new Log(this.getClass());//实例化日志对象
    PrtScr jt = new PrtScr();//实例化截图对象
//	private  ReadExcelUtil exc = new ReadExcelUtil();



	    @Test()
	    public void Login()  throws  Exception{

            try {
                Iterator iterator = ReadExcelUtil.getStringData();
//                boolean ret = false;
                while (iterator.hasNext()) {
                    Map<String, String> map = (Map<String, String>) iterator.next();
                    log.error("当前用户名:"+ map.get("username")+"  当前密码:"+ map.get("password"));
                    WebDriver driver = BrowserFactory.GetBrowser();//打开浏览器
                    Thread.sleep(2000);
                    LoginPage login = new LoginPage(driver);
                    login.login(url, map.get("username"), map.get("password"));
                    Thread.sleep(2000);
                    driver.close();
                }

            } catch (Exception e) {
               log.error("测试失败");

            }
            log.error("登录测试成功");

	    }

//	   @AfterMethod
//	    public void testEnd()   {
//		   BrowserFactory.quit(driver);
//	    }
@DataProvider(name = "loginData")
public Iterator<Object[]> prinum() throws IOException {
	        return ReadExcelUtil.getStringData();
}

    @Test()
    public void test()throws IOException{
        System.out.println(ReadExcelUtil.getStringData());
    }

}
