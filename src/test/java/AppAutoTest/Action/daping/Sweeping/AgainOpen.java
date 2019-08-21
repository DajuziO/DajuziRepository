package AppAutoTest.Action.daping.Sweeping;

import AppAutoTest.Action.daping.Public.OpenSweeping;
import AppAutoTest.start.Appaction;
import AppAutoTest.start.StartApp;
import Utils.Log;
import Utils.PrtScr;
import io.appium.java_client.android.AndroidElement;
import org.dom4j.DocumentException;

/**
 *
 *打开被控制设备模块——>点击返回——>重新被控制设备模块
 */
public class AgainOpen extends StartApp {
    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();

   public void againopencheck(String classname ,String classtext ,String content) throws DocumentException, InterruptedException {
       Appaction SweepingRobot = new Appaction("设备控制");
       OpenSweeping devices = new OpenSweeping();
       devices.OpenSweeping(classname, classtext,content,0);//传入设备控制中要定位的元素的classname
       /*点击返回按钮回到设备控制的主页面再次进入*/
       log.info("下面点击返回按钮，返回到设备控制的默认页面");
       Thread.sleep(2000);
       SweepingRobot.click(40,60);
       log.info("再次进入被控设备页面，被控设备：" + content);
       devices.OpenSweeping(classname, classtext,content,0);//传入设备控制中要定位的元素的classname
       /*在打开的设备页面下滑动查看页面状态*/
       log.info("在打开被控设备：" + content + "的情况下滑动页面，查看页面滑动的效果");
       log.info("滑动被空设备的显示页面：");
       SweepingRobot.slide( 239,61,731,59);
       Thread.sleep(2000);
       AndroidElement element = SweepingRobot.findelement("扫地机器人顶部标题",1);
       SweepingRobot.Assert(element.getText(),content,"在打开被控设备的情况下划动页面被控设备模块，跳转页面啦！！！");
       SweepingRobot.slide( 735,56,275,93);
       Thread.sleep(2000);
       AndroidElement element1 = SweepingRobot.findelement("扫地机器人顶部标题",1);
       SweepingRobot.Assert(element1.getText(),content,"在打开被控设备的情况下划动页面被控设备模块，跳转页面啦！！！");
       SweepingRobot.slide( 648,167,275,193);
       Thread.sleep(2000);
       AndroidElement element2 = SweepingRobot.findelement("扫地机器人顶部标题",1);
       SweepingRobot.Assert(element2.getText(),content,"在打开被控设备的情况下划动页面被控设备模块，跳转页面啦！！！");
       SweepingRobot.slide( 748,306,284,273);
       Thread.sleep(2000);
       AndroidElement element3 = SweepingRobot.findelement("扫地机器人顶部标题",1);
       SweepingRobot.Assert(element3.getText(),content,"在打开被控设备的情况下划动页面被控设备模块，跳转页面啦！！！");
       SweepingRobot.slide( 1028,364,503,349);
       Thread.sleep(2000);
       AndroidElement element4 = SweepingRobot.findelement("扫地机器人顶部标题",1);
       SweepingRobot.Assert(element4.getText(),content,"在打开被控设备的情况下划动页面被控设备模块，跳转页面啦！！！");
       SweepingRobot.slide( 306,618,50,609);
       Thread.sleep(2000);
       AndroidElement element5 = SweepingRobot.findelement("扫地机器人顶部标题",1);
       SweepingRobot.Assert(element5.getText(),content,"在打开被控设备的情况下划动页面被控设备模块，跳转页面啦！！！");
       SweepingRobot.slide( 976,453,128,399);
       Thread.sleep(2000);
       AndroidElement element6 = SweepingRobot.findelement("扫地机器人顶部标题",1);
       SweepingRobot.Assert(element6.getText(),content,"在打开被控设备的情况下划动页面被控设备模块，跳转页面啦！！！");
       SweepingRobot.slide( 1047,711,247,687);
       Thread.sleep(2000);
       AndroidElement element7 = SweepingRobot.findelement("扫地机器人顶部标题",1);
       SweepingRobot.Assert(element7.getText(),content,"在打开被控设备的情况下划动页面被控设备模块，跳转页面啦！！！");
       SweepingRobot.slide( 1050,796,46,794);
       Thread.sleep(2000);
       AndroidElement element8 = SweepingRobot.findelement("扫地机器人顶部标题",1);
       SweepingRobot.Assert(element8.getText(),content,"在打开被控设备的情况下划动页面被控设备模块，跳转页面啦！！！");
       SweepingRobot.slide( 1030,143,43,759);
       Thread.sleep(2000);
       AndroidElement element9 = SweepingRobot.findelement("扫地机器人顶部标题",1);
       SweepingRobot.Assert(element9.getText(),content,"在打开被控设备的情况下划动页面被控设备模块，跳转页面啦！！！");
       log.info("滑动设备控制模块，非显示被控设备的模块");
       SweepingRobot.slide(913,870,236,872);
       Thread.sleep(3000);
       //TODO 页面返回的时候是否保持本来打开的设备控制页面
       SweepingRobot.slide(256,1251,913,1282);
       Thread.sleep(2000);
       AndroidElement element10 = SweepingRobot.findelement("扫地机器人顶部标题",1);
       SweepingRobot.Assert(element10.getText(),content,"从默认页面跳回到设备控制页面下，扫地机器人打开的状态不见啦！！！");
   }




}
