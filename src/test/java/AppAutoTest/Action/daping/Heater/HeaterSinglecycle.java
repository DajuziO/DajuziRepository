package AppAutoTest.Action.daping.Heater;

import AppAutoTest.start.Appaction;
import AppAutoTest.start.StartApp;
import Utils.Log;
import Utils.PrtScr;
import Utils.console;
import io.appium.java_client.android.AndroidElement;
import org.dom4j.DocumentException;
import java.io.IOException;

/**
 * 热水器的单次循环模式验证，验证点，点击单次循环的时候，定时循环模式下不应该有模式显示，小火花颜色变红
 */
public class HeaterSinglecycle extends StartApp {
    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();
    public void Heatersinglecycle() throws DocumentException, InterruptedException, IOException {
        Appaction Heater = new Appaction("热水器设备控制");
        log.info("下面点击定时循环");
        Heater.click("定时循环按钮");
        Thread.sleep(3000);
        AndroidElement element3 = Heater.findelement("定时循环页面下的选择模式",1);
        if(element3 != null){
            log.info("定时循环点击确定按钮");
            Heater.click("定时循环页面确定按钮");
            Thread.sleep(3000);
            AndroidElement element=  Heater.findelement("热水器控制页面的模式",1);
            if(element.getText().equals(null) || element.getText().equals("")){
                console console1 = new console();
                console1.cmd("echo %date%");//打印时间到文件，以便于区分两次截取日志的分隔
                console1.cmd("adb logcat -t 50");//打印日志到log文件的末尾,20行
                jt.takeScreenShot(driver,"点击定时循环循环，定时循环下面没有模式显示呢");
                log.error("点击定时循环循环，定时循环下面没有模式显示呢！！！");
                boolean a = false;
                test(a);
            }else{
                log.info("点击定时循环，定时循环下模式显示为：" +element.getText());
            }
            log.info("下面点击单次循环");
            Heater.click("热水器单次循环");
            Thread.sleep(3000);
            AndroidElement element1=  Heater.findelement("热水器控制页面的模式",0);

            String resourceid = "com.haiersmart.controlpanel:id/iv_falme";//组装resource-id
            System.out.println(resourceid);
            log.info("调用元素截图方法进行元素截图。");
            String resourceidpath = Heater.elementScreenshot(resourceid);

//TODO 小火花色值取数
            //读取图片文件
//            File file = new File(resourceidpath);
//            BufferedImage bi = null;
//            try {
//                bi = ImageIO.read(file);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            int pixel = bi.getRGB(971, 512);
//            String colorvalue1 = String.format("%08x",pixel);
//            String colorvalue = colorvalue1.substring(2);
//            log.info("实际色值为（已去除透明度）：" + colorvalue+ ",预期色值为：ff8d00.");
//            Heater.Assert(colorvalue, "ff8d00", "识别的色值与预期色值不符。");



            System.out.println(element1.getText());
            if(element1.getText() != null && !element1.getText().equals("") ){
                console console1 = new console();
                console1.cmd("echo %date%");//打印时间到文件，以便于区分两次截取日志的分隔
                console1.cmd("adb logcat -t 50");//打印日志到log文件的末尾,20行
                jt.takeScreenShot(driver,"点击单次循环，定时循环下面还有模式显示呢");
                log.error("点击单次循环，定时循环下面还有模式显示呢！！！");
                boolean a = false;
                test(a);
            }else{
                log.info("点击单次循环，定时循环下不应该有模式显示。");
            }
        }else{
            jt.takeScreenShot(driver,"进入定时循环页面失败！");
            log.error("进入定时循环页面失败！");
        }
    }
}
