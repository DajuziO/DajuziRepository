package AppAutoTest.start;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import Utils.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Appaction extends StartApp {
	/**
	 * 基本动作类
	 */
	protected Log log = new Log(this.getClass());
	PrtScr jt = new PrtScr();
	HashMap<String, Locator> locatorMap;

	/**
	 * 选择 page页面,用于存放页面元素
	 * @param pagename
	 * @throws DocumentException
	 */
	public Appaction(String pagename) throws DocumentException {
		locatorMap = Xml.setxml(pagename);
	}

	/**
	 * 定位元素并设置等待时间
	 * @param loc
	 * @return  AndroidElement
	 * @throws InterruptedException
	 */
	public AndroidElement xpath(Locator loc) throws InterruptedException {
		AndroidElement thisdriver = null;
		try {
			//TODO 休眠时间修改
//			Thread.sleep(loc.getTimeout()*1000);
//			System.out.println(By.xpath(loc.getElement()) + "====");
			thisdriver = (AndroidElement) driver.findElement(By.xpath(loc.getElement()));
			log.info(loc.getName() + "：定位成功");
		} catch (Exception e) {
			//TODO catch
			try {
				log.info("没有找到"+loc.getName()+"元素：继续等待"+(loc.getTimeout()+4)+"秒");     //第一次没有找到元素，继续等待i+4秒
				Thread.sleep(loc.getTimeout()*1000+4000);
				thisdriver = (AndroidElement) driver.findElement(By.xpath(loc.getElement()));
				log.info(loc.getName() + "：定位成功");
			} catch (Exception e2) {
				jt.takeScreenShot(driver,loc.getName() + "：定位失败");
				log.error(loc.getName()+"定位失败");
				boolean a = false;
				test(a);
			}
		}
		return thisdriver;
	}

	/**
	 * 查找元素
	 * @param name
	 * @param i :用来区别日志打印级别，0表示不需要定位到该元素，1表示需要定位到该元素
	 * @return
	 */
	public AndroidElement findelement(String name,int i) {
		    Locator loc = locatorMap.get(name);
			AndroidElement element = null;
			try{
				element = (AndroidElement) driver.findElement(By.xpath(loc.getElement()));
//				System.out.println(element.getText());
				}catch (Exception e){
					if(i == 0) {
						log.info("没有定位到元素：" + name);
						}
					else if(i ==1){
					log.error("没有定位到元素：" + name);
					jt.takeScreenShot(driver,"没有定位到元素：" + name);
					boolean a = false;
					test(a);
					}
					else{
						log.error("参数错误");
						boolean a = false;
						test(a);
						}
				 }
//		    System.out.println(element.getText());//调试使用
		return element;
	}
		/**
		 * 点击元素
		 */

		public void click (String name) throws InterruptedException {
			Locator loc = locatorMap.get(name);
			try {
				AndroidElement driver = xpath(loc);
				driver.click();
				Thread.sleep(loc.getTimeout());
				log.info(loc.getName() + "：点击成功");
			} catch (Exception e) {
				jt.takeScreenShot(driver,loc.getName() + "点击失败");
				log.error(loc.getName() + "：点击失败");
				boolean a = false;
				test(a);
			}
		}

	/**
		 * 在文本框中输入
		 * @param name
		 * @param str
		 * @throws InterruptedException
		 */
		public void sendKeys(String name, String str) throws InterruptedException {
			Locator loc = locatorMap.get(name);
			try {
				AndroidElement driver = xpath(loc);
				driver.sendKeys(str);
				Thread.sleep(loc.getTimeout());
				log.info("在" + loc.getName() + "输入框中输入" + str + "：输入成功");
			} catch (Exception e) {
				log.error("在" + loc.getName() + "输入框中输入" + str + "：输入失败");
				jt.takeScreenShot(driver,"在\" + loc.getName() + \"输入框中输入\" + str + \"：输入失败");
				boolean a = false;
				test(a);
			}
	}

	/**
	 *按坐标点击
	 * @param x
	 * @param y
	 * @throws InterruptedException
	 */
	public void click(int x, int y) throws InterruptedException {
		try {
			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(x, y)).release().perform();
//			action.longPress(x, y).release().perform();//java-client升级点击方法更换
			log.info("点击坐标" + x + ":" + y + "：成功");
		} catch (Exception e) {
			jt.takeScreenShot(driver, "点击坐标");
			log.error("点击坐标" + x + ":" + y + "：失败");
			boolean a = false;
			test(a);
		}
	}

	public boolean be(String name) {
		Locator loc = locatorMap.get(name);
		boolean status = false;
		try {
			driver.findElement(By.xpath(loc.getElement()));
			status = true;
		} catch (Exception e) {
			jt.takeScreenShot(driver,"元素不存在");
			log.error(loc.getName() + "元素不存在");
			boolean a = false;
			test(a);
		}
		return status;
	}

	/**
	 * 滑动操作，按坐标滑动
	 * @param x
	 * @param y
	 * @param xj
	 * @param yj
	 * @throws InterruptedException
	 */
	public void slide(int x, int y, int xj, int yj) throws InterruptedException {
		try {
			TouchAction action = new TouchAction(driver);
			//TODO
			action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(xj, yj)).release().perform();
			log.info("从" + x + "--" + y + "滑动到" + xj + "--" + yj + "成功");
		} catch (Exception e) {
			jt.takeScreenShot(driver, "滑动失败");
			log.error("从" + x + "--" + y + "滑动到" + xj + "--" + yj + "失败");
			boolean a = false;
			test(a);
		}
	}
	/**
	 * 清屏
	 * @param name
	 * @throws InterruptedException
	 */
	public void cls(String name) throws InterruptedException {
		try {
			click(name);
			String text = text(name);
			driver.pressKeyCode(123); // 移动到文本最后
			for (int i = 0; i < text.length(); i++) { // a 代表输入的字符串
				driver.pressKeyCode(67); // 删除
			}
			log.info("文本框中的内容成功清空");
		} catch (Exception e) {
			log.error("文本框中的内容没有清空");
			jt.takeScreenShot(driver,"文本框中的内容没有清空");
			boolean a = false;
			test(a);
		}
	}

	/**
	 * 操作键盘
	 * @param i
	 */
	public void button(int i) {
		try {
			driver.pressKeyCode(i);
			log.info("点击按钮成功");
		} catch (Exception e) {
		log.error("点击按钮失败");
			jt.takeScreenShot(driver,"点击按钮失败");
			boolean a = false;
			test(a);
		}
		
	}

	/**
	 * 返回控件文本
	 * @param name
	 * @return
	 * @throws InterruptedException
	 */
	public String text(String name) throws InterruptedException {
		Locator loc = locatorMap.get(name);
		AndroidElement driver = xpath(loc);
		String str = driver.getText();
		return str;
	}


	/**
	 * 切换上下文
	 */
	public void Context_to() {
		try {
			if (driver.getContext().equals("NATIVE_APP")) {
				driver.context("WEBVIEW_com.zhongqian.zq");
			} else if (driver.getContext().equals("WEBVIEW_com.zhongqian.zq")) {
				driver.context("NATIVE_APP");
			}
			log.info("成功切换上下文");
		} catch (Exception e) {
			log.error("切换上下文失败");
			jt.takeScreenShot(driver,"切换上下文失败");
			boolean a = false;
			test(a);
		}
	}

	public void stp(int t) throws InterruptedException {   
		log.info("等待" + t + "秒");
		Thread.sleep(t * 1000);
	}

	/**
	 * 关闭 APP
	 */
	public void quit() {
		log.info("关闭APP");
		driver.quit();

	}

	/**
	 * xpath按元素ID点击
	 * @param id
	 */
	public void clickbyid(String id) {
		driver.findElement(new By.ById(id)).click();

	}

	/**
	 * 点击文本
	 * @param text
	 * 这个方法在appium desktop 1.8 上没有实现
	 */
	public AndroidElement findbytext(String text) {
		AndroidElement element  =(AndroidElement) driver.findElement(By.linkText(text));
		return element;
	}

	/**
	 * String ，String ，String 断言类型封装,异常不报错继续跑
	 */
//	public void Assert(String expect , String content,String msg){
//		try{
//			Assert.assertEquals(expect,content,msg);
//		}
//		catch(Error e ){
//		log.error(msg);
//		/*截取日志到文件*/
//		console console1 = new console();
////		console1.cmd("adb shell \"logcat | grep \"IrobotFragment\"\" >>E:\\workspace\\app.test\\app.ui\\logs\\log.text");//打印日志到log文件的末尾
//		console1.cmd("echo %date%");//打印时间到文件，以便于区分两次截取日志的分隔
//		console1.cmd("adb logcat -t 10");//打印日志到log文件的末尾,300行
//		jt.takeScreenShot(driver,msg);
//		}
//	}

	/**
	 * 为了让解决失败截图和截取日志，进行断言封装
	 *
	 */
	@Test
	public void test(boolean a){
		Assert.assertTrue(a);
	}
	public void Assert(String expect , String content, String msg){
		boolean a=false;
		if(expect.equals(content)) {
			a=true;
			log.info("执行成功," + expect );
		} else {
			log.error("执行失败,"+ expect + msg);
			/*截取日志到文件*/
			console console1 = new console();
   //		console1.cmd("adb shell \"logcat | grep \"IrobotFragment\"\" >>E:\\workspace\\app.test\\app.ui\\logs\\log.text");//打印日志到log文件的末尾
			console1.cmd("echo %date%");//打印时间到文件，以便于区分两次截取日志的分隔
			console1.cmd("adb logcat -t 100");//打印日志到log文件的末尾,20行
			jt.takeScreenShot(driver,msg);
		}
		test(a);
	}

	/**
	 * 在指定的classname里面查找指定的文本匹配
	 * @param    classname
	 * @param    text
	 * 为了循环语句需要，指定到循环次数之后报错截图
	 * @return  AndroidElement   element
	 */


	public AndroidElement findelementbyclass(String classname ,String text,int i){
		AndroidElement element = null;
		try{
			String path = ""+classname+"[@text='"+ text+"']";
			element  = (AndroidElement) driver.findElementByXPath(path);
		}
		catch (Exception  e){
			log.info("第" + i +"次本页没有找到需要的元素，" + text + "请翻页或下滑");
			if(i == 8){
				jt.takeScreenShot(driver,"第"+ i + "次本页没有找到需要的元素："+ text);
				log.error("第" + i +"次本页没有找到需要的元素，请翻页或下滑");
				boolean a = false;
				test(a);
			}
		}
		return element;
}
/**
 * 获取安卓原生toast弹窗元素
 */
public void toasttext(String toastcontent) {
	log.info("开始获取Toast弹出框的元素啦：" + toastcontent + "!!!");
	AndroidElement element = (AndroidElement) driver.findElementByXPath("//*[@class=\"android.widget.Toast\"]");
	if (element == null) {
		log.info("xpath元素定位按照：class定位失败，改换定位弹出框文案模糊匹配");
		final WebDriverWait wait = new WebDriverWait(driver, 1);
		AndroidElement element1 = (AndroidElement) wait.until(presenceOfElementLocated(By.xpath(".//*[contains(@text,'" + toastcontent + "')]")));
		Assert(element1.getText(), toastcontent, "弹窗内容：" + element1.getText() + "与预期：" + toastcontent + "不一致");
	}
	Assert(element.getText(), toastcontent, "弹窗内容：" + element.getText() + "与预期：" + toastcontent + "不一致");
}
		public void CloseApp(){
			try{
				driver.closeApp();
			}catch (Exception e){
				log.error("关闭APP失败，请检查app是否已经成功打开");
				boolean a = false;
				test(a);
			}

			}




    /**
     * 元素截图
     * @param resourceid
     * @return
     */
    public String elementScreenshot(String resourceid){
        String currentPath= System.getProperty("user.dir")+"\\截图\\";
        String  date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());// 设置日期格式
        String path= date+ ".jpg";
        String elementscreenshotpath = currentPath + path;
//		AndroidElement element =  (AndroidElement)driver.findElement(By.id("com.haiersmart.controlpanel:id/box_week_5"));
        AndroidElement element =  (AndroidElement)driver.findElement(By.id(resourceid));
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        File picFile = new File(currentPath + path);
        try {
            FileUtils.copyFile(scrFile, picFile);
            log.info("元素截图成功");
            log.info("元素保存的路径为:" + currentPath + path);
        } catch (IOException e) {
            log.error("元素截图失败");
            e.printStackTrace();
        }
        log.screenShotLog("截图：" + scrFile, picFile);
        return elementscreenshotpath;
    }

    /**
     * 是被图片上制定坐标的背景颜色的值
     * @param elementscreenshotpath
     * @return
     * @throws IOException
     */
    public String  getImagePixel(String elementscreenshotpath) throws IOException {
        int width = 0;
        int height = 0;
        StringBuffer sb = new StringBuffer();
        //读取图片文件
        File file = new File(elementscreenshotpath);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //得到图片像su的宽和高
        width = bi.getWidth();
        height = bi.getHeight();
        int pixel = bi.getRGB(3*width/5, height/2);
        String colorvalue1 = String.format("%08x",pixel);
        String colorvalue = colorvalue1.substring(2);
        return colorvalue;
    }


	public String  getImagePixel(String elementscreenshotpath,int x,int y) throws IOException {
		int width = 0;
		int height = 0;
		StringBuffer sb = new StringBuffer();
		//读取图片文件
		File file = new File(elementscreenshotpath);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//得到图片像su的宽和高
		width = bi.getWidth();
		height = bi.getHeight();
		int pixel = bi.getRGB(x, y);
		String colorvalue1 = String.format("%08x",pixel);
		String colorvalue = colorvalue1.substring(2);
		return colorvalue;
	}
}
