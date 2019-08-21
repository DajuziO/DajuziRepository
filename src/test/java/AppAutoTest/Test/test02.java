package AppAutoTest.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import AppAutoTest.Action.daping.Public.HandleGuide;
import AppAutoTest.Action.daping.Public.OpenSweeping;
import AppAutoTest.start.Appaction;
import AppAutoTest.start.StartApp;
import Utils.ReadExcelUtil;

import org.dom4j.DocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test02 extends StartApp {
/**
 * 空调
 */
	@BeforeClass
	public void beforclass() throws IOException, InterruptedException, DocumentException {
		/*启动APP*/
		Iterator iterator = ReadExcelUtil.getStringData();
		while (iterator.hasNext()) {
			Map<String, String> map = (Map<String, String>) iterator.next();
			String udid = map.get("udid");
			String devicesname = map.get("devicesname");
			String platformVersion = map.get("platformVersion");
			String appPackage = map.get("appPackage");
			String appActivity = map.get("appActivity");
			String classtext = map.get("classtext");
			if (udid != null && classtext.equals("卧室  挂机空调")) {
				StartApp start = new StartApp();
				start.start_up(devicesname, platformVersion, appPackage, appActivity, udid);
				/*处理新手指引*/
				HandleGuide guide = new HandleGuide();
				guide.HandleHoempageGuide();
			}
		}
	}
	@Test()
	public void test() throws DocumentException, IOException {

		Iterator iterator = ReadExcelUtil.getStringData();
		while (iterator.hasNext()) {
			Map<String, String> map = (Map<String, String>) iterator.next();
			String udid = map.get("udid");
			String classname = map.get("classname");
			String classtext = map.get("classtext");
			String content = map.get("content");
			if (udid != null && classtext.equals("卧室  挂机空调")) {
				OpenSweeping devices = new OpenSweeping();
				devices.OpenSweeping(classname, classtext, content, 4);//传入设备控制中要定位的元素的classname

				Appaction AirConditioner = new Appaction("空调设备控制");
				String[] modelArray = {"com.haiersmart.controlpanel:id/tv_mode_silence"};
				for (int i = 0; i < modelArray.length; i++) {
					String resourceid = modelArray[i];
					;//组装resource-id
					System.out.println(resourceid);
					log.info("调用元素截图方法进行元素截图。");
					String resourceidpath = AirConditioner.elementScreenshot(resourceid);
					System.out.println(resourceidpath);
				}

			}
		}
	}
	@Test()
	public void test1() throws DocumentException, IOException {
		Appaction AirConditioner = new Appaction("空调设备控制");
		log.info("调用元素是被方法进行元素背景色值识别。");
//		String colorvalue = AirConditioner.getImagePixel("E:\\workspace\\app.test\\app.ui\\截图\\20190330_144119.jpg",43,14);
//		String colorvalue1 = AirConditioner.getImagePixel("E:\\workspace\\app.test\\app.ui\\截图\\20190329_161438.jpg",43,14);
//		String colorvalue2 = AirConditioner.getImagePixel("E:\\workspace\\app.test\\app.ui\\截图\\20190329_161438.jpg",106,16);
//		String colorvalue3 = AirConditioner.getImagePixel("E:\\workspace\\app.test\\app.ui\\截图\\20190329_155352.jpg",171,32);
//		String colorvalue4 = AirConditioner.getImagePixel("E:\\workspace\\app.test\\app.ui\\截图\\20190329_155352.jpg",300,131);
		String colorvalue5 = AirConditioner.getImagePixel("E:\\workspace\\app.test\\app.ui\\截图\\20190330_144813.jpg",106,16);
//		System.out.println(colorvalue);
//		System.out.println(colorvalue1);
//		System.out.println(colorvalue2);
//		System.out.println(colorvalue3);
//		System.out.println(colorvalue4);
		System.out.println(colorvalue5);
	}
}
