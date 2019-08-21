package AppAutoTest.Action.daping.Sweeping;

import AppAutoTest.start.Appaction;
import AppAutoTest.start.StartApp;
import Utils.Log;
import Utils.PrtScr;
import io.appium.java_client.android.AndroidElement;
import org.dom4j.DocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
  * 测试扫地机器人点击关机按钮之后的状态变化
  * */
public class CloseCheck extends StartApp {
    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();


    @Test
    public void test(boolean a){
        Assert.assertTrue(a);
    }
    public void closecheck() throws DocumentException, InterruptedException {
        Appaction SweepingRobot = new Appaction("设备控制");
        log.info("下面校验扫地机器人的状态。");
        AndroidElement element = SweepingRobot.findelement("机器状态", 1);
        AndroidElement element2 = SweepingRobot.findelement("状态", 1);
        if (element.getText().equals("待机")) {
            log.info("待机状态，点击关机按钮");
            Thread.sleep(3000);
            SweepingRobot.click("电源开关");
            Thread.sleep(3000);
            AndroidElement element3 = SweepingRobot.findelement("状态", 1);
            SweepingRobot.Assert(element3.getText(),"休眠","待机状态点击电源开关，休眠状态3秒内回写不及时");
            log.info("休眠状态，点击开机按钮");
            SweepingRobot.click("电源开关");
            Thread.sleep(3000);
            AndroidElement element4 = SweepingRobot.findelement("状态", 1);
            SweepingRobot.Assert(element4.getText(),"待机","休眠状态点击电源开关，待机状态3秒内回写不及时");
            /*规划清扫模式下直接点击关机按钮*/
            planclose();
            /*沿墙清扫模式下直接点击关机按钮*/
            Alongwallclose();
            /*单间清扫模式下直接点击关机按钮*/
            Roomclose();
            /*重点清扫模式下直接点击关机按钮*/
            Focusedclose();
        } else if (element.getText().equals("休眠")) {
            log.info("休眠状态，点击电源开关");
            SweepingRobot.click("电源开关");
            Thread.sleep(3000);
            AndroidElement element3 = SweepingRobot.findelement("状态", 1);
            SweepingRobot.Assert(element3.getText(),"待机","休眠状态点击电源开关，待机状态3秒内回写不及时");
            Thread.sleep(3000);
            log.info("待机状态，点击电源开关");
            SweepingRobot.click("电源开关");
            Thread.sleep(3000);
            AndroidElement element4 = SweepingRobot.findelement("状态", 1);
            SweepingRobot.Assert(element4.getText(),"休眠","待机状态点击电源开关，休眠状态3秒内回写不及时");
            log.info("休眠状态，点击电源开关");
            SweepingRobot.click("电源开关");
            Thread.sleep(3000);
            AndroidElement element5 = SweepingRobot.findelement("状态", 1);
            SweepingRobot.Assert(element4.getText(),"待机","休眠状态点击电源开关，待机状态3秒内回写不及时");
            /*规划清扫模式下直接点击关机按钮*/
            planclose();
            /*沿墙清扫模式下直接点击关机按钮*/
            Alongwallclose();
            /*单间清扫模式下直接点击关机按钮*/
            Roomclose();
            /*重点清扫模式下直接点击关机按钮*/
            Focusedclose();
        }else{
            jt.takeScreenShot(driver,"非休眠和待机状态，不做电源关闭和开启的点击操作");
            log.error("非休眠和待机状态，不做电源关闭和开启的点击操作");
            boolean a = false;
            test(a);
        }
    }
    /*
    *规划清扫模式下直接点击关机按钮
    */
    public void planclose() throws DocumentException, InterruptedException {
        Appaction SweepingRobot = new Appaction("设备控制");
        log.info("下面点击规划清扫");
        SweepingRobot.click("规划清扫");
        Thread.sleep(1000);
        log.info("下面点击启动按钮");
        SweepingRobot.click("启动暂停按钮");
        Thread.sleep(3000);
        AndroidElement element5 = SweepingRobot.findelement("机器状态",1);
        SweepingRobot.Assert(element5.getText(), "工作中", "扫地机状态更新不及时");
        log.info("下面点击电源开关按钮");
        SweepingRobot.click("电源开关");
        Thread.sleep(3000);
        AndroidElement element6 = SweepingRobot.findelement("状态",1);
        SweepingRobot.Assert(element6.getText(),"休眠","工作中状态点击电源开关，休眠状态3秒内回写不及时");
        log.info("下面点击电源开关按钮");
        SweepingRobot.click("电源开关");
        Thread.sleep(3000);
        SweepingRobot.Assert(element6.getText(),"待机","休眠状态点击电源开关，待机状态3秒内回写不及时");
    }


    public void Alongwallclose() {
        try {
            Appaction SweepingRobot = new Appaction("设备控制");
            log.info("下面点击沿墙清扫");
            SweepingRobot.click("沿墙清扫");
            Thread.sleep(1000);
            log.info("下面点击启动按钮");
            SweepingRobot.click("启动暂停按钮");
            Thread.sleep(3000);
            AndroidElement element = SweepingRobot.findelement("机器状态",1);
            SweepingRobot.Assert(element.getText(), "工作中", "扫地机状态更新不及时");
            log.info("下面点击电源开关按钮");
            SweepingRobot.click("电源开关");
            Thread.sleep(3000);
            AndroidElement element6 = SweepingRobot.findelement("状态",1);
            SweepingRobot.Assert(element6.getText(),"休眠","工作中状态点击电源开关，休眠状态3秒内回写不及时");
            log.info("下面点击电源开关按钮");
            SweepingRobot.click("电源开关");
            Thread.sleep(3000);
            SweepingRobot.Assert(element6.getText(),"待机","休眠状态点击电源开关，待机状态3秒内回写不及时");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    /**
     * 扫地机器人模式动作封装，单间清扫，默认风机模式
     * 尝试按元素位置进行定位，appium desktop1.8 客户端模式模拟定位，xpath绝对路径
     */
    public void Roomclose() {
        try {
            Appaction SweepingRobot = new Appaction("设备控制");
            log.info("下面点击单间清扫");
            SweepingRobot.click("单间清扫");
            Thread.sleep(1000);
            log.info("下面点击启动按钮");
            SweepingRobot.click("启动暂停按钮");
            Thread.sleep(3000);
            AndroidElement element = SweepingRobot.findelement("机器状态",1);
            SweepingRobot.Assert(element.getText(), "工作中", "扫地机状态更新不及时");
            log.info("下面点击电源开关按钮");
            SweepingRobot.click("电源开关");
            Thread.sleep(3000);
            AndroidElement element6 = SweepingRobot.findelement("状态",1);
            SweepingRobot.Assert(element6.getText(),"休眠","工作中状态点击电源开关，休眠状态3秒内回写不及时");
            log.info("下面点击电源开关按钮");
            SweepingRobot.click("电源开关");
            Thread.sleep(3000);
            SweepingRobot.Assert(element6.getText(),"待机","休眠状态点击电源开关，待机状态3秒内回写不及时");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 扫地机器人模式动作封装，重点清扫，默认风机模式
     * 尝试按元素位置进行定位，appium desktop1.8 客户端模式模拟定位，xpath绝对路径
     */

    public void Focusedclose() {
        try {
            Appaction SweepingRobot = new Appaction("设备控制");
            log.info("下面点击重点清扫");
            SweepingRobot.click("重点清扫");
            Thread.sleep(1000);
            log.info("下面点击启动按钮");
            SweepingRobot.click("启动暂停按钮");
            Thread.sleep(3000);
            AndroidElement element = SweepingRobot.findelement("机器状态",1);
            SweepingRobot.Assert(element.getText(), "工作中", "扫地机状态更新不及时");
            log.info("下面点击电源开关按钮");
            SweepingRobot.click("电源开关");
            Thread.sleep(3000);
            AndroidElement element6 = SweepingRobot.findelement("状态",1);
            SweepingRobot.Assert(element6.getText(),"休眠","工作中状态点击电源开关，休眠状态3秒内回写不及时");
            log.info("下面点击电源开关按钮");
            SweepingRobot.click("电源开关");
            Thread.sleep(3000);
            SweepingRobot.Assert(element6.getText(),"待机","休眠状态点击电源开关，待机状态3秒内回写不及时");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
