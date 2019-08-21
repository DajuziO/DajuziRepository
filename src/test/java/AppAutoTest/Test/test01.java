package AppAutoTest.Test;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import AppAutoTest.Action.daping.Heater.HeaterFixedcycle;
import AppAutoTest.Action.daping.Heater.HeaterSinglecycle;
import AppAutoTest.Action.daping.Heater.HeaterTypeChooseCheck;
import AppAutoTest.Action.daping.Heater.Heatertemper;
import AppAutoTest.Action.daping.Public.HandleGuide;
import AppAutoTest.Action.daping.Public.OpenSweeping;
import AppAutoTest.Action.daping.Sweeping.CheckPageTurning;
import AppAutoTest.start.StartApp;
import Utils.ReadExcelUtil;
import org.dom4j.DocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class test01 extends StartApp {
	/**
	 * 燃气热水器
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
			if (udid != null && classtext.equals("厨房  燃气热水器1")) {
				StartApp start = new StartApp();
				start.start_up(devicesname, platformVersion, appPackage, appActivity, udid);
				/*处理新手指引*/
				HandleGuide guide = new HandleGuide();
				guide.HandleHoempageGuide();
			}
		}
	}
//	@Test(enabled = true, invocationCount = 10,threadPoolSize=2)
	@Test(enabled = true,invocationCount = 100)
	public void testHeater() throws IOException, InterruptedException, DocumentException {
		Iterator iterator = ReadExcelUtil.getStringData();
		while (iterator.hasNext()) {
			Map<String, String> map = (Map<String, String>) iterator.next();
			String udid = map.get("udid");
			String classname = map.get("classname");
			String classtext = map.get("classtext");
			String content = map.get("content");
			if (udid != null && classtext.equals("厨房  燃气热水器1")) {
					/*滑动操作*/
				CheckPageTurning cehckpageturn = new CheckPageTurning();
					cehckpageturn.checkpageturn();
					/*打开热水器模块*/
					OpenSweeping devices = new OpenSweeping();
					devices.OpenSweeping(classname, classtext, content, 4);//传入设备控制中要定位的元素的classname
					/*燃气热水器的温度加减操作*/
					Heatertemper heater = new Heatertemper();
					heater.HeatertemperatureContor();
					/*热水器单次循环验证*/
					HeaterSinglecycle heater1 = new HeaterSinglecycle();
					heater1.Heatersinglecycle();


					log.info("热水器单次循环验证完成,下面进行滑动操作******************************************************************");
					/*热水器定时循环模式回写验证*/
					log.info("滑动操作完成，下面进行热水器定时循环模式回写验证******************************************************************");
					HeaterFixedcycle fixed = new HeaterFixedcycle();
					fixed.HeaterTypeCheck();


					log.info("热水器定时循环模式回写验证完成，下面进行滑动操作******************************************************************");
					/*热水器定时循环选择时间配置验证*/
					log.info("滑动操作完成，下面进行热水器时循环选择时间配置验证******************************************************************");
					HeaterTypeChooseCheck heater2 = new HeaterTypeChooseCheck();
					heater2.DefaultTypeCheck();
					log.info("热水器时循环选择时间配置验证完成******************************************************************");
			}
			}


	}
//	@AfterMethod
//	public void closeapp() throws DocumentException, InterruptedException {
//		Appaction close = new Appaction("设备控制");
//		close.CloseApp();
//		Thread.sleep(10000);
//	}
	}
