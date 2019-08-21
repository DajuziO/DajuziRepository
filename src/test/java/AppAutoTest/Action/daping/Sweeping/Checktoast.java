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
 * 校验互斥场景下的toast弹窗内容
 */
public class Checktoast extends StartApp {
    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();

    /**
     * 连续点击电源按钮出现提示
     */

    public void PowerButton(String toasttext1) throws DocumentException, InterruptedException {
        Appaction toast = new Appaction("设备控制");
        for (int i = 1; i <= 3; i++) {
            toast.click(1017, 56);
            i++;
        }
        Thread.sleep(500);
        toast.toasttext(toasttext1);
    }

    /**
     * 规划清扫模式下点击别的模式：沿墙清扫，单间清扫，重点清扫
     */
    public void PlanToast(String toasttext2) throws InterruptedException, DocumentException {
        Appaction SweepingRobot = new Appaction("设备控制");
        log.info("********************下面开始规划清扫模式下验证********************");
        SweepingRobot.click("规划清扫");
        Thread.sleep(1000);
        log.info("下面点击启动按钮");
        SweepingRobot.click("启动暂停按钮");
        Thread.sleep(3000);
        AndroidElement element = SweepingRobot.findelement("机器状态", 1);
        SweepingRobot.Assert(element.getText(), "工作中", "扫地机状态更新不及时");
        log.info("规划清扫已启动情况下，下面点击沿墙清扫模式");
        SweepingRobot.click(740,466);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        Thread.sleep(1000);
        log.info("规划清扫已启动情况下，下面点击单间清扫模式");
        SweepingRobot.click(451,711);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        Thread.sleep(1000);
        log.info("规划清扫已启动情况下，下面点击重点清扫模式");
        SweepingRobot.click(167,462);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        log.info("********************规划清扫模式下已经验证完成，停止扫地机运行********************");
        SweepingRobot.click("启动暂停按钮");
    }

    /**
     * 规划清扫模式下点击别的模式：沿墙清扫，单间清扫，重点清扫
     */
    public void AlongwallToast(String toasttext2) throws InterruptedException, DocumentException {
        Appaction SweepingRobot = new Appaction("设备控制");
        log.info("********************下面开始沿墙清扫模式下验证********************");
        SweepingRobot.click("沿墙清扫");
        Thread.sleep(1000);
        log.info("下面点击启动按钮");
        SweepingRobot.click("启动暂停按钮");
        Thread.sleep(3000);
        AndroidElement element = SweepingRobot.findelement("机器状态", 1);
        SweepingRobot.Assert(element.getText(), "工作中", "扫地机状态更新不及时");
        log.info("沿墙清扫已启动情况下，下面点击规划清扫模式");
        SweepingRobot.click(440,219);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        Thread.sleep(1000);
        log.info("沿墙清扫已启动情况下，下面点击单间清扫模式");
        SweepingRobot.click(451,711);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        Thread.sleep(1000);
        log.info("沿墙清扫已启动情况下，下面点击重点清扫模式");
        SweepingRobot.click(167,462);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        log.info("********************沿墙清扫模式下已经验证完成，停止扫地机运行********************");
        SweepingRobot.click("启动暂停按钮");
    }

    public void RoomToast(String toasttext2) throws DocumentException, InterruptedException {
        Appaction SweepingRobot = new Appaction("设备控制");
        log.info("********************下面开始单间清扫模式下验证********************");
        SweepingRobot.click("单间清扫");
        Thread.sleep(1000);
        log.info("下面点击启动按钮");
        SweepingRobot.click("启动暂停按钮");
        Thread.sleep(3000);
        AndroidElement element = SweepingRobot.findelement("机器状态", 1);
        SweepingRobot.Assert(element.getText(), "工作中", "扫地机状态更新不及时");
        log.info("单间清扫已启动情况下，下面点击规划清扫模式");
        SweepingRobot.click(440,219);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        Thread.sleep(1000);
        log.info("单间清扫已启动情况下，下面点击沿墙清扫模式");
        SweepingRobot.click(740,466);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        Thread.sleep(1000);
        log.info("单间清扫已启动情况下，下面点击重点清扫模式");
        SweepingRobot.click(167,462);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        log.info("********************单间清扫模式下已经验证完成，停止扫地机运行********************");
        SweepingRobot.click("启动暂停按钮");
    }

    public void FocusedToast(String toasttext2) throws DocumentException, InterruptedException {

        Appaction SweepingRobot = new Appaction("设备控制");
        log.info("********************下面开始重点清扫模式下验证********************");
        SweepingRobot.click("重点清扫");
        Thread.sleep(1000);
        log.info("下面点击启动按钮");
        SweepingRobot.click("启动暂停按钮");
        Thread.sleep(3000);
        AndroidElement element = SweepingRobot.findelement("机器状态", 1);
        SweepingRobot.Assert(element.getText(), "工作中", "扫地机状态更新不及时");
        log.info("重点清扫已启动情况下，下面点击规划清扫模式");
        SweepingRobot.click(440,219);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        Thread.sleep(1000);
        log.info("重点清扫已启动情况下，下面点击沿墙清扫模式");
        SweepingRobot.click(740,466);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        Thread.sleep(1000);
        log.info("重点清扫已启动情况下，下面点击单间清扫模式");
        SweepingRobot.click(451,711);
        log.info("下面校验Toast弹出框文案");
        Thread.sleep(500);
        SweepingRobot.toasttext(toasttext2);
        log.info("********************单间清扫模式下已经验证完成，停止扫地机运行********************");
        SweepingRobot.click("启动暂停按钮");
    }
    @Test
    public void test(boolean a){
        Assert.assertTrue(a);
    }

    public void ToastCheck(String toasttext1, String toasttext2) throws InterruptedException, DocumentException {
            Appaction Robot1 = new Appaction("设备控制");
            AndroidElement element3 = Robot1.findelement("机器状态", 1);
            if(element3.getText().equals("休眠")){
                log.info("连续点击电源按钮啦~");
                PowerButton(toasttext1);
            }else if(element3.getText().equals("待机")){
                log.info("连续点击电源按钮啦~");
                PowerButton(toasttext1);
            }else{
                log.error("该状态："+ element3.getText() +",下没有电源按钮呀！！！");
                jt.takeScreenShot(driver, element3.getText() + ",下没有电源按钮呀！！！");
                boolean a = false;
                test(a);
            }
            Thread.sleep(3000);
            Appaction Robot = new Appaction("设备控制");
            AndroidElement element = Robot.findelement("机器状态", 1);
            AndroidElement element2 = Robot.findelement("状态", 1);
            if (element.getText().equals("待机")) {
                log.info("待机状态，直接操作");
                Thread.sleep(3000);
                PlanToast(toasttext2);
                AlongwallToast(toasttext2);
                RoomToast(toasttext2);
                FocusedToast(toasttext2);
            } else if (element.getText().equals("休眠")) {
                log.info("休眠状态，点击电源开关");
                Robot.click("电源开关");
                Thread.sleep(3000);
                AndroidElement element4 = Robot.findelement("机器状态", 1);
                Robot.Assert(element4.getText(), "待机", "点击电源开关后休眠状态没有在2秒之内刷新到待机状态");
                PlanToast(toasttext2);
                AlongwallToast(toasttext2);
                RoomToast(toasttext2);
                FocusedToast(toasttext2);
            } else {
                log.error("非可操作状态，不进行点击操作");
                jt.takeScreenShot(driver, element.getText() + ",下没有电源按钮呀！！！");
                boolean a = false;
                test(a);
            }
        }
}
