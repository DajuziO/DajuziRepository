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
 * 扫地机器人风机模块测试
 */

public class SweepingFanTest extends StartApp {

    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();

    /**
     * 扫地机器人模式动作封装，规划清扫，默认风机模式
     * 尝试按元素位置进行定位，appium desktop1.8 客户端模式模拟定位，xpath绝对路径
     */
    public void Plan() {
        try {
            Appaction SweepingRobot = new Appaction("设备控制");
            log.info("下面点击规划清扫");
            SweepingRobot.click("规划清扫");
            log.info("下面点击启动按钮");
            SweepingRobot.click("启动暂停按钮");
            Thread.sleep(3000);
            AndroidElement element = SweepingRobot.findelement("机器状态",1);
            SweepingRobot.Assert(element.getText(), "工作中", "扫地机状态更新不及时：3秒内没有从工待机到工作中");
            /*下面校验风速模式*/
            log.info("下面测试风机模式调节");
            AdjustFan("风速选择强力模式");
            AdjustFan("风速选择正常模式");
            Thread.sleep(3000);
            log.info("下面点击暂停按钮");
            SweepingRobot.click("启动暂停按钮");
            Thread.sleep(3000);
            AndroidElement element1 = SweepingRobot.findelement("机器状态",1);
            SweepingRobot.Assert(element1.getText(), "待机", "扫地机状态更新不及时：3秒内没有从工作中到待机");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 扫地机器人模式动作封装，沿墙清扫，默认风机模式
     * 尝试按元素位置进行定位，appium desktop1.8 客户端模式模拟定位，xpath绝对路径
     */
    public void Alongwall() {
        try {
            Appaction SweepingRobot = new Appaction("设备控制");
            log.info("下面点击沿墙清扫");
            SweepingRobot.click("沿墙清扫");
            log.info("下面点击启动按钮");
            SweepingRobot.click("启动暂停按钮");
            Thread.sleep(3000);
            AndroidElement element = SweepingRobot.findelement("机器状态",1);
            SweepingRobot.Assert(element.getText(), "工作中", "扫地机状态更新不及时：3秒内没有从工待机到工作中");
            /*下面校验风速模式*/
            log.info("下面测试风机模式调节");
            AdjustFan("风速选择强力模式");
            AdjustFan("风速选择正常模式");
            Thread.sleep(3000);
            log.info("下面点击暂停按钮");
            SweepingRobot.click("启动暂停按钮");
            Thread.sleep(3000);
            AndroidElement element1 = SweepingRobot.findelement("机器状态",1);
            SweepingRobot.Assert(element1.getText(), "待机", "扫地机状态更新不及时：3秒内没有从工作中到待机");
            Thread.sleep(3000);
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
    public void Room() {
        try {
            Appaction SweepingRobot = new Appaction("设备控制");
            log.info("下面点击单间清扫");
            SweepingRobot.click("单间清扫");
            log.info("下面点击启动按钮");
            SweepingRobot.click("启动暂停按钮");
            Thread.sleep(3000);
            AndroidElement element = SweepingRobot.findelement("机器状态",1);
            SweepingRobot.Assert(element.getText(), "工作中", "扫地机状态更新不及时：3秒内没有从工待机到工作中");
            /*下面校验风速模式*/
            log.info("下面测试风机模式调节");
            AdjustFan("风速选择强力模式");
            AdjustFan("风速选择正常模式");
            Thread.sleep(3000);
            log.info("下面点击暂停按钮");
            SweepingRobot.click("启动暂停按钮");
            Thread.sleep(3000);
            AndroidElement element1 = SweepingRobot.findelement("机器状态",1);
            SweepingRobot.Assert(element1.getText(), "待机", "扫地机状态更新不及时：3秒内没有从工作中到待机");
            Thread.sleep(3000);
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

    public void Focused() {
        try {
            Appaction SweepingRobot = new Appaction("设备控制");
            log.info("下面点击重点清扫");
            SweepingRobot.click("重点清扫");
            log.info("下面点击启动按钮");
            SweepingRobot.click("启动暂停按钮");
            Thread.sleep(3000);
            AndroidElement element = SweepingRobot.findelement("机器状态",1);
            SweepingRobot.Assert(element.getText(), "工作中", "扫地机状态更新不及时：3秒内没有从工待机到工作中");
            /*下面校验风速模式*/
            log.info("下面测试风机模式调节");
            AdjustFan("风速选择强力模式");
            Thread.sleep(3000);
            System.out.println("正常模式了");
            AdjustFan("风速选择正常模式");
            Thread.sleep(3000);
            log.info("下面点击暂停按钮");
            SweepingRobot.click("启动暂停按钮");
            Thread.sleep(3000);
            AndroidElement element1 = SweepingRobot.findelement("机器状态",1);
            SweepingRobot.Assert(element1.getText(), "待机", "扫地机状态更新不及时：3秒内没有从工作中到待机");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();



        }
    }

    /**
     * 风机模式调节
     */
    public void AdjustFan(String windspeed){
        try {
            Appaction SweepingRobot = new Appaction("设备控制");
            log.info("下面点击风机图标");
//            SweepingRobot.click("风机模式图标");
            SweepingRobot.click(937,351);
            Thread.sleep(3000);
            AndroidElement element1 = SweepingRobot.findelement(windspeed,1);
            String choicewindspeed = element1.getText();
            SweepingRobot.click(windspeed);
            Thread.sleep(3000);
            AndroidElement element = SweepingRobot.findelement("风速",1);
            String returnwindspeed = element.getText();
            SweepingRobot.Assert(returnwindspeed,choicewindspeed,"选择风速和实际返回风速不一致," + choicewindspeed + "返回风速为：" + returnwindspeed);
            Thread.sleep(3000);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(boolean a){
        Assert.assertTrue(a);
    }
    /**
     * 状态&操作
     */
    public void operation() {
        try {
            Appaction Robot = new Appaction("设备控制");
            AndroidElement element = Robot.findelement("机器状态",1);
            AndroidElement element2 = Robot.findelement("状态",1);
            if (element.getText().equals("待机")) {
                log.info("待机状态");
                Thread.sleep(3000);
                /*按xpath绝对路径定位*/
                Plan(); //规划清扫，xpath定位
                Alongwall();//沿墙清扫，xpath定位
                Room();//单间清扫，xpath定位
                Focused();//重点清扫，xpath定位
            } else if (element.getText().equals("休眠")) {
                log.info("休眠状态，点击电源开关");
                Robot.click("电源开关");
                Thread.sleep(3000);
                AndroidElement element3 = Robot.findelement("机器状态",1);
                Robot.Assert(element3.getText(),"待机","点击电源开关后休眠状态没有在3秒之内刷新到待机状态");
                Plan(); //规划清扫，xpath定位
                Alongwall();//沿墙清扫，xpath定位
                Room();//单间清扫，xpath定位
                Focused();//重点清扫，xpath定位
            } else if (element.getText().equals("工作中")) {
                log.error("扫地机器人正在工作中先点击开关按钮暂停工作");
//                jt.takeScreenShot(driver, "非可操作状态，扫地机器人正在工作中，请人工处理");
                Robot.click("电源开关");
                Thread.sleep(3000);
                AndroidElement element4 = Robot.findelement("机器状态",1);
                Robot.Assert(element4.getText(),"休眠","点击电源开关后休眠状态没有在3秒之内刷新到休眠状态");
                Robot.click("电源开关");
                AndroidElement element5 = Robot.findelement("机器状态",1);
                Robot.Assert(element5.getText(),"待机","点击电源开关后待机状态没有在3秒之内刷新到休眠状态");
                Thread.sleep(3000);
                Plan(); //规划清扫，xpath定位
                Alongwall();//沿墙清扫，xpath定位
                Room();//单间清扫，xpath定位
                Focused();//重点清扫，xpath定位
            } else if (element.getText().equals("充电")) {
                jt.takeScreenShot(driver, "非可操作状态，扫地机器人正在充电中，请人工处理");
                log.error("非可操作状态，扫地机器人正在充电中，请人工处理");
                boolean a = false;
                test(a);
            } else if (element2.getText().equals("充电")) {
                jt.takeScreenShot(driver, "非可操作状态，扫地机器人正在充电中，请人工处理");
                log.error("非可操作状态，扫地机器人正在充电中，请人工处理");
                boolean a = false;
                test(a);
            }
            else if (element.getText().equals("设备已离线，请检查网络")) {
                Robot.Assert(element.getText(),"设备已离线，请检查网络","扫地机器人离线了");
                jt.takeScreenShot(driver, "非可操作状态，扫地机器人已离线，请人工处理");
                log.error("非可操作状态，扫地机器人已离线，请人工处理");
                boolean a = false;
                test(a);
            }
            else if (element.getText().equals("充电完成")) {
                Robot.Assert(element.getText(),"充电完成","充电完成状态");
                jt.takeScreenShot(driver, "非可操作状态，扫地机器人充电完成，请确认是否连接电源线");
                log.error("非可操作状态，扫地机器人充电完成，请确认是否连接电源线");
                boolean a = false;
                test(a);
            }
            else if (element.getText().equals("回充")) {
                Robot.Assert(element.getText(),"回充","回充状态");
                jt.takeScreenShot(driver, "非可操作状态，扫地机器人正在回充");
                log.error("非可操作状态，扫地机器人正在回充");
                boolean a = false;
                test(a);
            }
            else{
                jt.takeScreenShot(driver, "扫地机器人状态不在可操作状态中");
                log.error("扫地机器人状态不在可操作状态中");
                boolean a = false;
                test(a);
            }
            Robot.click("电源开关");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
