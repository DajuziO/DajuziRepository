package AppAutoTest.Action.daping.Sweeping;
import AppAutoTest.start.Appaction;
import AppAutoTest.start.StartApp;
import Utils.Log;
import Utils.PrtScr;
import Utils.console;
import io.appium.java_client.android.AndroidElement;
import org.dom4j.DocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 首页左右滑动操作验证页面会不会崩溃
 */
public class CheckPageTurning extends StartApp {
    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();

    @Test
    public void test(boolean a){
        Assert.assertTrue(a);
    }
    public void checkpageturn(){

        try {
            Appaction SweepingRobot = new Appaction("设备控制");
//            log.info("滑动操作：左滑");
//            SweepingRobot.slide(176,1302,806,1296);
//            Thread.sleep(3000);
//            AndroidElement element = SweepingRobot.findelement("崩溃提示",0);
//            if(element != null){
//                console console1 = new console();
//                console1.cmd("echo %date%");//打印时间到文件，以便于区分两次截取日志的分隔
//                console1.cmd("adb logcat -t 50");//打印日志到log文件的末尾,20行
//                jt.takeScreenShot(driver,"滑动页面导致页面崩溃了！！！");
//                log.error("滑动页面导致页面崩溃了！！！");
//                boolean a = false;
//                test(a);
//            }
//            Thread.sleep(3000);
            log.info("滑动操作：右滑");
            SweepingRobot.slide(806,1296,176,1302);
            Thread.sleep(3000);
            AndroidElement element1 = SweepingRobot.findelement("崩溃提示",0);
            if(element1 != null){
                console console1 = new console();
                console1.cmd("echo %date%");//打印时间到文件，以便于区分两次截取日志的分隔
                console1.cmd("adb logcat -t 50");//打印日志到log文件的末尾,20行
                log.error("滑动页面导致页面崩溃了！！！");
                jt.takeScreenShot(driver,"滑动页面导致页面崩溃了！！！");
                boolean a = false;
                test(a);
            }
            Thread.sleep(500);
            SweepingRobot.slide(989,1381,236,922);
            log.info("滑动操作：右滑");
            Thread.sleep(3000);
            AndroidElement element2 = SweepingRobot.findelement("崩溃提示",0);
            if(element2 != null){
                console console1 = new console();
                console1.cmd("echo %date%");//打印时间到文件，以便于区分两次截取日志的分隔
                console1.cmd("adb logcat -t 50");//打印日志到log文件的末尾,20行
                log.error("滑动页面导致页面崩溃了！！！");
                jt.takeScreenShot(driver,"滑动页面导致页面崩溃了！！！");
                boolean a = false;
                test(a);
            }
            Thread.sleep(500);
            log.info("滑动操作：右滑");
            SweepingRobot.slide(1013,976,15,1147);
            Thread.sleep(3000);
            AndroidElement element3 = SweepingRobot.findelement("崩溃提示",0);
            if(element3 != null){
                console console1 = new console();
                console1.cmd("echo %date%");//打印时间到文件，以便于区分两次截取日志的分隔
                console1.cmd("adb logcat -t 50");//打印日志到log文件的末尾,20行
                log.error("滑动页面导致页面崩溃了！！！");
                jt.takeScreenShot(driver,"滑动页面导致页面崩溃了！！！");
                boolean a = false;
                test(a);
            }
            Thread.sleep(500);
            log.info("滑动操作：左滑");
            SweepingRobot.slide(292,1618,785,1606);
            Thread.sleep(3000);
            AndroidElement element4 = SweepingRobot.findelement("崩溃提示",0);
            if(element4 != null){
                console console1 = new console();
                console1.cmd("echo %date%");//打印时间到文件，以便于区分两次截取日志的分隔
                console1.cmd("adb logcat -t 50");//打印日志到log文件的末尾,20行
                log.error("滑动页面导致页面崩溃了！！！");
                jt.takeScreenShot(driver,"滑动页面导致页面崩溃了！！！");
                boolean a = false;
                test(a);
            }
            Thread.sleep(500);
            log.info("滑动操作：左滑");
            SweepingRobot.slide(59,963,844,937);
            Thread.sleep(3000);
            AndroidElement element5 = SweepingRobot.findelement("崩溃提示",0);
            if(element5 != null){
                console console1 = new console();
                console1.cmd("echo %date%");//打印时间到文件，以便于区分两次截取日志的分隔
                console1.cmd("adb logcat -t 50");//打印日志到log文件的末尾,20行
                log.error("滑动页面导致页面崩溃了！！！");
                jt.takeScreenShot(driver,"滑动页面导致页面崩溃了！！！");
                boolean a = false;
                test(a);
            }
            Thread.sleep(500);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
