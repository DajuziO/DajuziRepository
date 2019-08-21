package AppAutoTest.Action.daping.AirConditioner;

import AppAutoTest.start.Appaction;
import AppAutoTest.start.StartApp;
import Utils.Log;
import Utils.PrtScr;
import io.appium.java_client.android.AndroidElement;
import org.dom4j.DocumentException;

import java.io.IOException;

/**
 * 空调互斥关系验证
 */
public class ExclusionRelation extends StartApp {

    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();
    /**
     * 静眠与送风的互斥关系
     */
    public void QuietSleepAndAirSupply() throws DocumentException, InterruptedException, IOException {
        Appaction AirConditioner = new Appaction("空调设备控制");
        log.info("判断空调状态");
        AndroidElement AirConditionerStatus = AirConditioner.findelement("空调状态", 1);
        String Status = AirConditionerStatus.getText();
        log.info("空调状态是：" + Status);
        if (Status.equals("关机")) {
            log.info("空调关机状态，下面点击开关按钮。");
            AirConditioner.click("空调开关");
            Thread.sleep(3000);
            log.info("判断空调状态。");
            AndroidElement AirConditionerStatus1 = AirConditioner.findelement("空调状态", 1);
            AirConditioner.Assert(AirConditionerStatus1.getText(),"工作中","关机状态下点击开关，3秒内没有变为工作中状态");
            log.info("选择除湿模式");
            AirConditioner.click("空调除湿模式");
            Thread.sleep(3000);
            log.info("下面点击静眠");
            AirConditioner.click("空调静眠");
            Thread.sleep(3000);
            log.info("下面调用截图的方法对静眠按钮进行截图识别色值。");
            log.info("调用元素截图方法进行元素截图。");
            String resourceid2 = "com.haiersmart.controlpanel:id/tv_mode_silence";
            String resourceidpath2 = AirConditioner.elementScreenshot(resourceid2);
            log.info("调用元素是被方法进行元素背景色值识别。");
            String colorvalue2 = AirConditioner.getImagePixel(resourceidpath2,106,16);
            log.info("自动按钮被选中之后固定坐标的色值为：" + colorvalue2 + ",预期色值为：ffffff");
            AirConditioner.Assert(colorvalue2,"ffffff","自动按钮被选中之后固定坐标的色值与预期色值不符");


            log.info("点击自动档位风速");
            AirConditioner.click("自动风速");
            Thread.sleep(3000);
            log.info("下面调用截图的方法对自动风速按钮进行截图识别色值。");
            log.info("调用元素截图方法进行元素截图。");
            String resourceid = "com.haiersmart.controlpanel:id/level_0";
            String resourceidpath = AirConditioner.elementScreenshot(resourceid);
            log.info("调用元素是被方法进行元素背景色值识别。");
            String colorvalue = AirConditioner.getImagePixel(resourceidpath,45,11);
            log.info("自动按钮被选中之后固定坐标的色值为：" + colorvalue + ",预期色值为：5660d8");
            AirConditioner.Assert(colorvalue,"5660d8","自动按钮被选中之后固定坐标的色值与预期色值不符");

            log.info("下面点击送风");
            AirConditioner.click("空调送风模式");
            log.info("下面调用截图的方法对送风模式进行截图识别色值。");
            log.info("调用元素截图方法进行元素截图。");
            String resourceid1 = "com.haiersmart.controlpanel:id/view_5";
            String resourceidpath1 = AirConditioner.elementScreenshot(resourceid1);
            log.info("调用元素是被方法进行元素背景色值识别。");
            String colorvalue1 = AirConditioner.getImagePixel(resourceidpath1,265,297);
            log.info("自动按钮被选中之后固定坐标的色值为：" + colorvalue1 + ",预期色值为：74aa3b");
            AirConditioner.Assert(colorvalue1,"74aa3b","自动按钮被选中之后固定坐标的色值与预期色值不符");

            log.info("下面校验送风模式下的静眠和自动档位风速");
            AndroidElement element1 =  AirConditioner.findelement("空调静眠", 0);
            if(element1.getText() != null && ! element1.getText().equals("") ){
                jt.takeScreenShot(driver,"在送风模式下静眠按钮还在");
                log.error("在送风模式下静眠按钮还在");
                boolean a =false;
                test(a);
            }
            AndroidElement element2 =  AirConditioner.findelement("自动风速", 0);
            if(element2.getText() != null && ! element2.getText().equals("") ){
                jt.takeScreenShot(driver,"在送风模式下自动风速按钮还在");
                log.error("在送风模式下自动风速按钮还在");
                boolean a =false;
                test(a);
            }
            log.info("下面选择制冷模式检查静眠和自动按钮刷新");
            log.info("下面选择制冷模式");
            AirConditioner.click("空调制冷模式");
            Thread.sleep(3000);
            log.info("从送风模式切换到制冷模式下校验静眠和自动按钮的刷新。");
            AndroidElement element3 =  AirConditioner.findelement("空调静眠", 1);
            AirConditioner.Assert(element3.getText(),"静眠","从送风模式切换到制冷模式下静眠按钮3秒没有刷新出来");
            AndroidElement element4 =  AirConditioner.findelement("自动风速", 1);
            AirConditioner.Assert(element4.getText(),"静眠","从送风模式切换到制冷模式下自动风速按钮3秒没有刷新出来");
            log.info("校验静眠和自动可选择");
            //TODO 校验被选中
            AirConditioner.click("自动风速");
            Thread.sleep(3000);
            log.info("下面调用截图的方法对自动风速按钮进行截图识别色值。");
            log.info("调用元素截图方法进行元素截图。");
            String resourceid5 = "com.haiersmart.controlpanel:id/level_0";
            String resourceidpath5 = AirConditioner.elementScreenshot(resourceid5);
            log.info("调用元素是被方法进行元素背景色值识别。");
            String colorvalue5 = AirConditioner.getImagePixel(resourceidpath5,45,11);
            log.info("自动按钮被选中之后固定坐标的色值为：" + colorvalue5 + ",预期色值为：5660d8");
            AirConditioner.Assert(colorvalue5,"5660d8","自动按钮被选中之后固定坐标的色值与预期色值不符");

            AirConditioner.click("空调静眠");
            Thread.sleep(3000);
            log.info("下面调用截图的方法对静眠按钮进行截图识别色值。");
            log.info("调用元素截图方法进行元素截图。");
            String resourceid4 = "com.haiersmart.controlpanel:id/tv_mode_silence";
            String resourceidpath4 = AirConditioner.elementScreenshot(resourceid4);
            log.info("调用元素是被方法进行元素背景色值识别。");
            String colorvalue4 = AirConditioner.getImagePixel(resourceidpath4,106,16);
            log.info("自动按钮被选中之后固定坐标的色值为：" + colorvalue4 + ",预期色值为：ffffff");
            AirConditioner.Assert(colorvalue4,"ffffff","自动按钮被选中之后固定坐标的色值与预期色值不符");

        }else if(Status.equals("工作中")){

        }else{
            jt.takeScreenShot(driver,"空调不在可操作状态");
            log.error("空调不在可操作状态。");
        }
    }
}
