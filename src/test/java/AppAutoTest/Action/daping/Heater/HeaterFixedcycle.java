package AppAutoTest.Action.daping.Heater;

import AppAutoTest.start.Appaction;
import AppAutoTest.start.StartApp;
import Utils.Log;
import Utils.PrtScr;
import io.appium.java_client.android.AndroidElement;
import org.dom4j.DocumentException;

/**
 * 热水器的定时循环页面选择模式回写到控制页面验证
 */
public class HeaterFixedcycle extends StartApp {

    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();

    /**
     * 在单次循环模式下进入定时循环页面下选择模式直接点返回按钮，选择的模式不回写
     */
    public void SinglecycleReturnCheck() throws DocumentException, InterruptedException {
        Appaction Heater = new Appaction("热水器设备控制");
        log.info("判断热水器状态");
        AndroidElement Heaterstatus = Heater.findelement("热水器状态", 1);
        String heaterstatus = Heaterstatus.getText();
        log.info("热水器状态是：" + heaterstatus);
        if (heaterstatus.equals("工作中")) {
            log.info("下面点击单次循环");
            Heater.click("热水器单次循环");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("定时循环页面下的选择模式", 0);
            if (element == null) {
                log.info("单次循环模式下点击定时循环。");
                /*点击定时循环进去直接点击返回按钮*/
                Heater.click("定时循环按钮");
                Thread.sleep(3000);
                AndroidElement element1 = Heater.findelement("定时循环页面下的选择模式", 1);
                String type1 = element1.getText();
                if (type1 != null && ! type1.equals("")) {
                    log.info("进入定时循环模式成功，下面点击返回按钮。");
                    Heater.click(40, 60);
                    Thread.sleep(2000);
                    log.info("下面校验设备控制页面的设备模式。");
                    AndroidElement element2 = Heater.findelement("热水器控制页面的模式", 0);
                    if (element2.getText() != null && ! element2.getText().equals("")) {
                        jt.takeScreenShot(driver, "模式回写到设备控制页面啦！");
                        log.error("模式回写到设备控制页面啦！");
                        boolean a = false;
                        test(a);
                    } else {
                        log.info("返回正常，没有将模式回写到设备控制页面。");
                    }
                    /*点击定时循环，选择朝九晚五，点击返回按钮*/
                    log.info("再次进入定时循环页面下，选择早九晚五模式，直接点击返回");
                    Heater.click("定时循环按钮");
                    Thread.sleep(2000);
                    AndroidElement element3 = Heater.findelement("定时循环页面下的选择模式", 1);
                    String type3 = element3.getText();
                    if (type3 != null && ! type3.equals("")) {
                        log.info("进入定时循环模式成功，下面点击选择模式。");
                        Heater.click("定时循环页面下的选择模式");
                        Thread.sleep(3000);
                        log.info("下面选择朝九晚五模式。");
                        Heater.click("定时循环朝九晚五");
                        Thread.sleep(3000);
                        log.info("下面点击返回按钮。");
                        Heater.click(40, 60);
                        Thread.sleep(2000);
                        log.info("下面校验设备控制页面的设备模式。");
                        AndroidElement element4 = Heater.findelement("热水器控制页面的模式", 0);
                        if (element4.getText() != null && ! element4.getText().equals("")) {
                            jt.takeScreenShot(driver, "模式回写到设备控制页面啦！");
                            log.error("模式回写到设备控制页面啦！");
                            boolean a = false;
                            test(a);
                        } else {
                            log.info("返回正常，没有将模式回写到设备控制页面。");
                        }
                        /*点击定时循环，选择家有老幼，点击返回按钮*/
                        log.info("再次进入定时循环页面下，选择家有老幼模式，直接点击返回");
                        Heater.click("定时循环按钮");
                        Thread.sleep(2000);
                        AndroidElement element5 = Heater.findelement("定时循环页面下的选择模式", 1);
                        String type5 = element5.getText();
                        if (type5 != null && ! type5.equals("")) {
                            log.info("进入定时循环模式成功，下面点击选择模式。");
                            Heater.click("定时循环页面下的选择模式");
                            Thread.sleep(3000);
                            log.info("下面选择家有老幼模式。");
                            Heater.click("定时循环家有老幼");
                            Thread.sleep(3000);
                            log.info("下面点击返回按钮。");
                            Heater.click(40, 60);
                            Thread.sleep(2000);
                            log.info("下面校验设备控制页面的设备模式。");
                            AndroidElement element6 = Heater.findelement("热水器控制页面的模式", 0);
                            if (element6.getText() != null && ! element6.getText().equals("")) {
                                jt.takeScreenShot(driver, "模式回写到设备控制页面啦。");
                                log.error("模式回写到设备控制页面啦！");
                                boolean a = false;
                                test(a);
                            } else {
                                log.info("返回正常，没有将模式回写到设备控制页面。");
                            }

                            /*点击定时循环，选择舒适畅享，点击返回按钮*/
                            log.info("再次进入定时循环页面下，选择舒适畅享模式，直接点击返回");
                            Heater.click("定时循环按钮");
                            Thread.sleep(2000);
                            AndroidElement element7 = Heater.findelement("定时循环页面下的选择模式", 1);
                            String type7 = element7.getText();
                            if (type7 != null && ! type7.equals("")) {
                                log.info("进入定时循环模式成功，下面点击选择模式。");
                                Heater.click("定时循环页面下的选择模式");
                                Thread.sleep(3000);
                                log.info("下面选择舒适畅享模式。");
                                Heater.click("定时循环舒适畅享");
                                Thread.sleep(3000);
                                log.info("下面点击返回按钮。");
                                Heater.click(40, 60);
                                Thread.sleep(2000);
                                log.info("下面校验设备控制页面的设备模式。");
                                AndroidElement element8 = Heater.findelement("热水器控制页面的模式", 0);
                                if (element8.getText() != null && ! element8.getText().equals("")) {
                                    jt.takeScreenShot(driver, "模式回写到设备控制页面啦！");
                                    log.error("模式回写到设备控制页面啦！");
                                    boolean a = false;
                                    test(a);
                                } else {
                                    log.info("返回正常，没有将模式回写到设备控制页面。");
                                }
                            } else {
                                jt.takeScreenShot(driver, "进入定时循环页面失败。");
                                log.error("进入定时循环页面失败。");
                                boolean a = false;
                                test(a);
                            }
                        }
                    }
                }
            }
        }else if (heaterstatus.equals("关机")) {
            log.info("热水器关机状态，下面点击开关电源。");
            Heater.click("热水器开关");
            AndroidElement anelement = Heater.findelement("热水器状态", 1);
            Heater.Assert(anelement.getText(), "工作中", "热水器关机状态点击开关，3秒内没有回写到工作中状态。");
            log.info("下面点击单次循环");
            Heater.click("热水器单次循环");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("定时循环页面下的选择模式", 0);
            if (element == null) {
                log.info("单次循环模式下点击定时循环。");
                /*点击定时循环进去直接点击返回按钮*/
                Heater.click("定时循环按钮");
                Thread.sleep(3000);
                AndroidElement element1 = Heater.findelement("定时循环页面下的选择模式", 1);
                String type1 = element1.getText();
                if (type1 != null && ! type1.equals("")) {
                    log.info("进入定时循环模式成功，下面点击返回按钮。");
                    Heater.click(40, 60);
                    Thread.sleep(2000);
                    log.info("下面校验设备控制页面的设备模式。");
                    AndroidElement element2 = Heater.findelement("热水器控制页面的模式", 0);
                    if (element2.getText() != null && ! element2.getText().equals("")) {
                        jt.takeScreenShot(driver, "模式回写到设备控制页面啦！");
                        log.error("模式回写到设备控制页面啦！");
                        boolean a = false;
                        test(a);
                    } else {
                        log.info("返回正常，没有将模式回写到设备控制页面。");
                    }
                    /*点击定时循环，选择朝九晚五，点击返回按钮*/
                    log.info("再次进入定时循环页面下，选择朝九晚五模式，直接点击返回");
                    Heater.click("定时循环按钮");
                    Thread.sleep(2000);
                    AndroidElement element3 = Heater.findelement("定时循环页面下的选择模式", 1);
                    String type3 = element3.getText();
                    if (type3 != null && ! type3.equals("")) {
                        log.info("进入定时循环模式成功，下面点击选择模式。");
                        Heater.click("定时循环页面下的选择模式");
                        Thread.sleep(3000);
                        log.info("下面选择朝九晚五模式。");
                        Heater.click("定时循环朝九晚五");
                        Thread.sleep(3000);
                        log.info("下面点击返回按钮。");
                        Heater.click(40, 60);
                        Thread.sleep(2000);
                        log.info("下面校验设备控制页面的设备模式。");
                        AndroidElement element4 = Heater.findelement("热水器控制页面的模式", 0);
                        if (element4.getText() != null && ! element4.getText().equals("")) {
                            jt.takeScreenShot(driver, "模式回写到设备控制页面啦！");
                            log.error("模式回写到设备控制页面啦！");
                            boolean a = false;
                            test(a);
                        } else {
                            log.info("返回正常，没有将模式回写到设备控制页面。");
                        }
                        /*点击定时循环，选择家有老幼，点击返回按钮*/
                        log.info("再次进入定时循环页面下，选择家有老幼模式，直接点击返回");
                        Heater.click("定时循环按钮");
                        Thread.sleep(2000);
                        AndroidElement element5 = Heater.findelement("定时循环页面下的选择模式", 1);
                        String type5 = element5.getText();
                        if (type5 != null && ! type5.equals("")) {
                            log.info("进入定时循环模式成功，下面点击选择模式。");
                            Heater.click("定时循环页面下的选择模式");
                            Thread.sleep(3000);
                            log.info("下面选择家有老幼模式。");
                            Heater.click("定时循环家有老幼");
                            Thread.sleep(3000);
                            log.info("下面点击返回按钮。");
                            Heater.click(40, 60);
                            Thread.sleep(2000);
                            log.info("下面校验设备控制页面的设备模式。");
                            AndroidElement element6 = Heater.findelement("热水器控制页面的模式", 0);
                            if (element6.getText() != null && ! element6.getText().equals("")) {
                                jt.takeScreenShot(driver, "模式回写到设备控制页面啦！");
                                log.error("模式回写到设备控制页面啦！");
                                boolean a = false;
                                test(a);
                            } else {
                                log.info("返回正常，没有将模式回写到设备控制页面。");
                            }

                            /*点击定时循环，选择舒适畅享，点击返回按钮*/
                            log.info("再次进入定时循环页面下，选择舒适畅享模式，直接点击返回");
                            Heater.click("定时循环按钮");
                            Thread.sleep(2000);
                            AndroidElement element7 = Heater.findelement("定时循环页面下的选择模式", 1);
                            String type7 = element7.getText();
                            if (type7 != null && ! type7.equals("") ) {
                                log.info("进入定时循环模式成功，下面点击选择模式。");
                                Heater.click("定时循环页面下的选择模式");
                                Thread.sleep(3000);
                                log.info("下面选择舒适畅享模式。");
                                Heater.click("定时循环舒适畅享");
                                Thread.sleep(3000);
                                log.info("下面点击返回按钮。");
                                Heater.click(40, 60);
                                Thread.sleep(2000);
                                log.info("下面校验设备控制页面的设备模式。");
                                AndroidElement element8 = Heater.findelement("热水器控制页面的模式", 0);
                                if (element8.getText() != null && !element8.getText().equals("")) {
                                    jt.takeScreenShot(driver, "模式回写到设备控制页面啦！");
                                    log.error("模式回写到设备控制页面啦！");
                                    boolean a = false;
                                    test(a);
                                } else {
                                    log.info("返回正常，没有将模式回写到设备控制页面。");
                                }
                            } else {
                                jt.takeScreenShot(driver, "进入定时循环页面失败。");
                                log.error("进入定时循环页面失败。");
                                boolean a = false;
                                test(a);
                            }
                        }
                    }
                }
            }
        }else {
            jt.takeScreenShot(driver,"热水器不在可操作状态。");
            log.error("热水器不在可操作状态。");
            boolean a = false;
            test(a);
        }
    }
    /**
     * 进入定时循环页面后直接点击确定返回设备控制页面
     */
    public void DirectreturnTypeCheck() throws DocumentException, InterruptedException {
        Appaction Heater = new Appaction("热水器设备控制");
        log.info("判断热水器状态");
        AndroidElement Heaterstatus = Heater.findelement("热水器状态", 1);
        String heaterstatus = Heaterstatus.getText();
        log.info("热水器状态是：" + heaterstatus);
        if (heaterstatus.equals("工作中")) {
            log.info("下面点击定时循环");
            Heater.click("定时循环按钮");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("定时循环页面下的选择模式",1);
            String type = element.getText();
            if(element.getText() != null && ! element.getText().equals("")){
                log.info("当前热水器的模式是：" + type );
                log.info("点击确认按钮，返回设备控制页面检查模式回写。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(2000);
               AndroidElement element1 =  Heater.findelement("热水器状态",1);//通过热水器顶部的状态判定是不是返回控制也成功。
                if(element1.getText().equals("工作中")){
                    log.info("已经返回到热水器的控制页面啦。下面校验热水器的回写模式。");
                   AndroidElement element2 =  Heater.findelement("热水器控制页面的模式",1);
                   String type1 = element2.getText();
                   log.info("控制页面获取到的热水器模式为：" + type1 );
                   Heater.Assert(type1,type,"定时循环页面选择的模式与控制页面回写的模式不一致。");
                }else{
                    jt.takeScreenShot(driver,"返回热水器控制页面失败，或者热水器状态异常");
                    log.error("返回热水器控制页面失败，或者热水器状态异常");
                    boolean a = false;
                    test(a);
                }

            }else{
                jt.takeScreenShot(driver,"进入热水器的定时循环模式失败");
                log.error("进入热水器的定时循环模式失败。");
                boolean a = false;
                test(a);
            }
        }else if (heaterstatus.equals("关机")){
            log.info("点击热水器开关按钮");
            Heater.click("热水器开关");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("热水器状态",1);
            Heater.Assert(element.getText(),"工作中","热水器关机状态下点击电源按钮3秒内没有变为工作中状态");
            log.info("下面点击定时循环");
            Heater.click("定时循环按钮");
            Thread.sleep(3000);
            AndroidElement element4 = Heater.findelement("定时循环页面下的选择模式",1);
            String type4 = element4.getText();
            if(element.getText() != null && ! element.getText().equals("")){
                log.info("当前热水器的模式是：" + type4 );
                log.info("点击确认按钮，返回设备控制页面检查模式回写。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(2000);
                AndroidElement element1 =  Heater.findelement("热水器状态",1);//通过热水器顶部的状态判定是不是返回控制也成功。
                if(element1.getText().equals("工作中")){
                    log.info("已经返回到热水器的控制页面啦。下面校验热水器的回写模式。");
                    AndroidElement element2 =  Heater.findelement("热水器控制页面的模式",1);
                    String type1 = element2.getText();
                    log.info("控制页面获取到的热水器模式为：" + type1 );
                    Heater.Assert(type1,type4,"定时循环页面选择的模式与控制页面回写的模式不一致。");
                }else{
                    jt.takeScreenShot(driver,"返回热水器控制页面失败，或者热水器状态异常");
                    log.error("返回热水器控制页面失败，或者热水器状态异常");
                    boolean a = false;
                    test(a);
                }

            }else{
                jt.takeScreenShot(driver,"进入热水器的定时循环模式失败");
                log.error("进入热水器的定时循环模式失败。");
                boolean a = false;
                test(a);
            }
        }else{
            jt.takeScreenShot(driver,"热水器不在可操作状态!");
            log.error("热水器不在可操作状态！");
            boolean a = false;
            test(a);
        }
    }

    /**
     * 默认模式回写
     * @throws InterruptedException
     */
    public void DefaultTypeCheck() throws InterruptedException, DocumentException {
        Appaction Heater = new Appaction("热水器设备控制");
        log.info("判断热水器状态");
        AndroidElement Heaterstatus = Heater.findelement("热水器状态", 1);
        String heaterstatus = Heaterstatus.getText();
        log.info("热水器状态是：" + heaterstatus);
        if (heaterstatus.equals("工作中")) {
            log.info("下面点击定时循环");
            Heater.click("定时循环按钮");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("定时循环页面下的选择模式",1);
            String type = element.getText();
            if(element.getText() != null && ! element.getText().equals("")){
                log.info("当前热水器的模式是：" + type + "点击选择模式：" );
                Heater.click("定时循环页面下的选择模式");
                Thread.sleep(2000);
                log.info("下面选择默认模式");
                Heater.click("定时循环默认模式");
                Thread.sleep(2000);
                log.info("下面校验默认模式是否选择成功");
                AndroidElement element1 = Heater.findelement("定时循环页面下的选择模式",1);
                String type1 = element1.getText();
                Heater.Assert(type1,"默认模式","选择默认模式没有成功。");
                log.info("点击确认按钮，返回设备控制页面检查模式回写。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(3000);
                AndroidElement element2 =  Heater.findelement("热水器状态",1);//通过热水器顶部的状态判定是不是返回控制也成功。
                if(element2.getText().equals("工作中")){
                    log.info("已经返回到热水器的控制页面啦。下面校验热水器的回写模式。");
                    AndroidElement element3 =  Heater.findelement("热水器控制页面的模式",1);
                    String type3 = element3.getText();
                    log.info("控制页面获取到的热水器模式为：" + type3 );
                    Heater.Assert(type3,"默认模式","定时循环页面选择的默认模式与控制页面回写的模式不一致。");
                }else{
                    jt.takeScreenShot(driver,"返回热水器控制页面失败，或者热水器状态异常");
                    log.error("返回热水器控制页面失败，或者热水器状态异常");
                    boolean a = false;
                    test(a);
                }
            }else{
                jt.takeScreenShot(driver,"进入热水器的定时循环模式失败");
                log.error("进入热水器的定时循环模式失败。");
                boolean a = false;
                test(a);
            }
        }else if (heaterstatus.equals("关机")){
            log.info("点击热水器开关按钮");
            Heater.click("热水器开关");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("热水器状态",1);
            Heater.Assert(element.getText(),"工作中","热水器关机状态下点击电源按钮3秒内没有变为工作中状态");
            log.info("下面点击定时循环");
            Heater.click("定时循环按钮");
            Thread.sleep(3000);
            AndroidElement element4 = Heater.findelement("定时循环页面下的选择模式",1);
            String type4 = element4.getText();
            if(element4.getText() != null && ! element4.getText().equals("")){
                log.info("当前热水器的模式是：" + type4 + "点击选择模式：" );
                Heater.click("定时循环页面下的选择模式");
                Thread.sleep(2000);
                log.info("下面选择默认模式");
                Heater.click("定时循环默认模式");
                Thread.sleep(2000);
                log.info("下面校验默认模式是否选择成功");
                AndroidElement element1 = Heater.findelement("定时循环页面下的选择模式",1);
                String type1 = element1.getText();
                Heater.Assert(type1,"默认模式","选择默认模式没有成功。");
                log.info("点击确认按钮，返回设备控制页面检查模式回写。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(3000);
                AndroidElement element2 =  Heater.findelement("热水器状态",1);//通过热水器顶部的状态判定是不是返回控制也成功。
                if(element2.getText().equals("工作中")){
                    log.info("已经返回到热水器的控制页面啦。下面校验热水器的回写模式。");
                    AndroidElement element3 =  Heater.findelement("热水器控制页面的模式",1);
                    String type3 = element3.getText();
                    log.info("控制页面获取到的热水器模式为：" + type3 );
                    Heater.Assert(type3,"默认模式","定时循环页面选择的默认模式与控制页面回写的模式不一致。");
                }else{
                    jt.takeScreenShot(driver,"返回热水器控制页面失败，或者热水器状态异常");
                    log.error("返回热水器控制页面失败，或者热水器状态异常");
                    boolean a = false;
                    test(a);
                }
            }else{
                jt.takeScreenShot(driver,"进入热水器的定时循环模式失败");
                log.error("进入热水器的定时循环模式失败。");
                boolean a = false;
                test(a);
            }
            }else{
            jt.takeScreenShot(driver,"热水器不在可操作状态!");
            log.error("热水器不在可操作状态！");
            boolean a = false;
            test(a);
        }
    }

    /**
     * 朝九晚五模式回写
     * @throws InterruptedException
     */
    public void NineToFiveTypeCheck() throws InterruptedException, DocumentException {
        Appaction Heater = new Appaction("热水器设备控制");
        log.info("判断热水器状态");
        AndroidElement Heaterstatus = Heater.findelement("热水器状态", 1);
        String heaterstatus = Heaterstatus.getText();
        log.info("热水器状态是：" + heaterstatus);
        if (heaterstatus.equals("工作中")) {
            log.info("下面点击定时循环");
            Heater.click("定时循环按钮");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("定时循环页面下的选择模式",1);
            String type = element.getText();
            if(element.getText() != null && ! element.getText().equals("")){
                log.info("当前热水器的模式是：" + type + "点击选择模式：" );
                Heater.click("定时循环页面下的选择模式");
                Thread.sleep(2000);
                log.info("下面选择朝九晚五模式");
                Heater.click("定时循环朝九晚五");
                Thread.sleep(2000);
                log.info("下面校验朝九晚五是否选择成功");
                AndroidElement element1 = Heater.findelement("定时循环页面下的选择模式",1);
                String type1 = element1.getText();
                Heater.Assert(type1,"朝九晚五","选择朝九晚五模式没有成功。");
                log.info("点击确认按钮，返回设备控制页面检查模式回写。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(3000);
                AndroidElement element2 =  Heater.findelement("热水器状态",1);//通过热水器顶部的状态判定是不是返回控制也成功。
                if(element2.getText().equals("工作中")){
                    log.info("已经返回到热水器的控制页面啦。下面校验热水器的回写模式。");
                    AndroidElement element3 =  Heater.findelement("热水器控制页面的模式",1);
                    String type3 = element3.getText();
                    log.info("控制页面获取到的热水器模式为：" + type3 );
                    Heater.Assert(type3,"朝九晚五","定时循环页面选择的朝九晚五模式与控制页面回写的模式不一致。");
                }else{
                    jt.takeScreenShot(driver,"返回热水器控制页面失败，或者热水器状态异常");
                    log.error("返回热水器控制页面失败，或者热水器状态异常");
                    boolean a = false;
                    test(a);
                }
            }else{
                jt.takeScreenShot(driver,"进入热水器的定时循环模式失败");
                log.error("进入热水器的定时循环模式失败。");
                boolean a = false;
                test(a);
            }
        }else if (heaterstatus.equals("关机")){
            log.info("点击热水器开关按钮");
            Heater.click("热水器开关");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("热水器状态",1);
            Heater.Assert(element.getText(),"工作中","热水器关机状态下点击电源按钮3秒内没有变为工作中状态");
            log.info("下面点击定时循环");
            Heater.click("定时循环按钮");
            Thread.sleep(3000);
            AndroidElement element4 = Heater.findelement("定时循环页面下的选择模式",1);
            String type4 = element4.getText();
            if(element4.getText() != null && ! element4.getText().equals("")){
                log.info("当前热水器的模式是：" + type4 + "点击选择模式：" );
                Heater.click("定时循环页面下的选择模式");
                Thread.sleep(2000);
                log.info("下面选择朝九晚五模式");
                Heater.click("定时循环朝九晚五");
                Thread.sleep(2000);
                log.info("下面校验朝九晚五是否选择成功");
                AndroidElement element1 = Heater.findelement("定时循环页面下的选择模式",1);
                String type1 = element1.getText();
                Heater.Assert(type1,"朝九晚五","选择朝九晚五模式没有成功。");
                log.info("点击确认按钮，返回设备控制页面检查模式回写。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(3000);
                AndroidElement element2 =  Heater.findelement("热水器状态",1);//通过热水器顶部的状态判定是不是返回控制也成功。
                if(element2.getText().equals("工作中")){
                    log.info("已经返回到热水器的控制页面啦。下面校验热水器的回写模式。");
                    AndroidElement element3 =  Heater.findelement("热水器控制页面的模式",1);
                    String type3 = element3.getText();
                    log.info("控制页面获取到的热水器模式为：" + type3 );
                    Heater.Assert(type3,"朝九晚五","定时循环页面选择的朝九晚五模式与控制页面回写的模式不一致。");
                }else{
                    jt.takeScreenShot(driver,"返回热水器控制页面失败，或者热水器状态异常");
                    log.error("返回热水器控制页面失败，或者热水器状态异常");
                    boolean a = false;
                    test(a);
                }
            }else{
                jt.takeScreenShot(driver,"进入热水器的定时循环模式失败");
                log.error("进入热水器的定时循环模式失败。");
                boolean a = false;
                test(a);
            }
        }else{
            jt.takeScreenShot(driver,"热水器不在可操作状态!");
            log.error("热水器不在可操作状态！");
            boolean a = false;
            test(a);

        }
    }

    /**
     * 家有老幼模式回写
     * @throws InterruptedException
     */
    public void OldAndYoungTypeCheck() throws InterruptedException, DocumentException {
        Appaction Heater = new Appaction("热水器设备控制");
        log.info("判断热水器状态");
        AndroidElement Heaterstatus = Heater.findelement("热水器状态", 1);
        String heaterstatus = Heaterstatus.getText();
        log.info("热水器状态是：" + heaterstatus);
        if (heaterstatus.equals("工作中")) {
            log.info("下面点击定时循环");
            Heater.click("定时循环按钮");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("定时循环页面下的选择模式",1);
            String type = element.getText();
            if(element.getText() != null && ! element.getText().equals("")){
                log.info("当前热水器的模式是：" + type + "点击选择模式：" );
                Heater.click("定时循环页面下的选择模式");
                Thread.sleep(2000);
                log.info("下面选择家有老幼模式");
                Heater.click("定时循环家有老幼");
                Thread.sleep(2000);
                log.info("下面校验家有老幼模式是否选择成功");
                AndroidElement element1 = Heater.findelement("定时循环页面下的选择模式",1);
                String type1 = element1.getText();
                Heater.Assert(type1,"家有老幼","选择家有老幼模式没有成功。");
                log.info("点击确认按钮，返回设备控制页面检查模式回写。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(3000);
                AndroidElement element2 =  Heater.findelement("热水器状态",1);//通过热水器顶部的状态判定是不是返回控制也成功。
                if(element2.getText().equals("工作中")){
                    log.info("已经返回到热水器的控制页面啦。下面校验热水器的回写模式。");
                    AndroidElement element3 =  Heater.findelement("热水器控制页面的模式",1);
                    String type3 = element3.getText();
                    log.info("控制页面获取到的热水器模式为：" + type3 );
                    Heater.Assert(type3,"家有老幼","3秒内定时循环页面选择的家有老幼模式与控制页面回写的模式不一致。");
                }else{
                    jt.takeScreenShot(driver,"返回热水器控制页面失败，或者热水器状态异常");
                    log.error("返回热水器控制页面失败，或者热水器状态异常");
                    boolean a = false;
                    test(a);
                }
            }else{
                jt.takeScreenShot(driver,"进入热水器的定时循环模式失败");
                log.error("进入热水器的定时循环模式失败。");
                boolean a = false;
                test(a);
            }
        }else if (heaterstatus.equals("关机")){
            log.info("点击热水器开关按钮");
            Heater.click("热水器开关");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("热水器状态",1);
            Heater.Assert(element.getText(),"工作中","热水器关机状态下点击电源按钮3秒内没有变为工作中状态");
            log.info("下面点击定时循环");
            Heater.click("定时循环按钮");
            Thread.sleep(3000);
            AndroidElement element4 = Heater.findelement("定时循环页面下的选择模式",1);
            String type4 = element4.getText();
            if(element.getText() != null && ! element.getText().equals("")){
                log.info("当前热水器的模式是：" + type4 + "点击选择模式：" );
                Heater.click("定时循环页面下的选择模式");
                Thread.sleep(2000);
                log.info("下面选择家有老幼模式");
                Heater.click("定时循环家有老幼");
                Thread.sleep(2000);
                log.info("下面校验家有老幼模式是否选择成功");
                AndroidElement element1 = Heater.findelement("定时循环页面下的选择模式",1);
                String type1 = element1.getText();
                Heater.Assert(type1,"家有老幼","选择家有老幼模式没有成功。");
                log.info("点击确认按钮，返回设备控制页面检查模式回写。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(3000);
                AndroidElement element2 =  Heater.findelement("热水器状态",1);//通过热水器顶部的状态判定是不是返回控制也成功。
                if(element2.getText().equals("工作中")){
                    log.info("已经返回到热水器的控制页面啦。下面校验热水器的回写模式。");
                    AndroidElement element3 =  Heater.findelement("热水器控制页面的模式",1);
                    String type3 = element3.getText();
                    log.info("控制页面获取到的热水器模式为：" + type3 );
                    Heater.Assert(type3,"家有老幼","定时循环页面选择的家有老幼模式与控制页面回写的模式不一致。");
                }else{
                    jt.takeScreenShot(driver,"返回热水器控制页面失败，或者热水器状态异常");
                    log.error("返回热水器控制页面失败，或者热水器状态异常");
                    boolean a = false;
                    test(a);
                }
            }else{
                jt.takeScreenShot(driver,"进入热水器的定时循环模式失败");
                log.error("进入热水器的定时循环模式失败。");
                boolean a = false;
                test(a);
            }
        }else{
            jt.takeScreenShot(driver,"热水器不在可操作状态!");
            log.error("热水器不在可操作状态！");
            boolean a = false;
            test(a);
        }
    }

    /**
     * 舒适畅享模式回写
     * @throws InterruptedException
     */
    public void ComfortableTypeCheck() throws InterruptedException, DocumentException {
        Appaction Heater = new Appaction("热水器设备控制");
        log.info("判断热水器状态");
        AndroidElement Heaterstatus = Heater.findelement("热水器状态", 1);
        String heaterstatus = Heaterstatus.getText();
        log.info("热水器状态是：" + heaterstatus);
        if (heaterstatus.equals("工作中")) {
            log.info("下面点击定时循环");
            Heater.click("定时循环按钮");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("定时循环页面下的选择模式",1);
            String type = element.getText();
            if(element.getText() != null && ! element.getText().equals("")){
                log.info("当前热水器的模式是：" + type + "点击选择模式：" );
                Heater.click("定时循环页面下的选择模式");
                Thread.sleep(2000);
                log.info("下面选择舒适畅享模式");
                Heater.click("定时循环舒适畅享");
                Thread.sleep(2000);
                log.info("下面校验舒适畅享模式是否选择成功");
                AndroidElement element1 = Heater.findelement("定时循环页面下的选择模式",1);
                String type1 = element1.getText();
                Heater.Assert(type1,"舒适畅享","选择舒适畅享模式没有成功。");
                log.info("点击确认按钮，返回设备控制页面检查模式回写。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(3000);
                AndroidElement element2 =  Heater.findelement("热水器状态",1);//通过热水器顶部的状态判定是不是返回控制也成功。
                if(element2.getText().equals("工作中")){
                    log.info("已经返回到热水器的控制页面啦。下面校验热水器的回写模式。");
                    AndroidElement element3 =  Heater.findelement("热水器控制页面的模式",1);
                    String type3 = element3.getText();
                    log.info("控制页面获取到的热水器模式为：" + type3 );
                     Heater.Assert(type3,"舒适畅享","定时循环页面选择的舒适畅享模式与控制页面回写的模式不一致。");
                }else{
                    jt.takeScreenShot(driver,"返回热水器控制页面失败，或者热水器状态异常");
                    log.error("返回热水器控制页面失败，或者热水器状态异常");
                    boolean a = false;
                    test(a);
                }
            }else{
                jt.takeScreenShot(driver,"进入热水器的定时循环模式失败");
                log.error("进入热水器的定时循环模式失败。");
                boolean a = false;
                test(a);
            }
        }else if (heaterstatus.equals("关机")){
            log.info("点击热水器开关按钮");
            Heater.click("热水器开关");
            Thread.sleep(3000);
            AndroidElement element = Heater.findelement("热水器状态",1);
            Heater.Assert(element.getText(),"工作中","热水器关机状态下点击电源按钮3秒内没有变为工作中状态");
            log.info("下面点击定时循环");
            Heater.click("定时循环按钮");
            Thread.sleep(3000);
            AndroidElement element4 = Heater.findelement("定时循环页面下的选择模式",1);
            String type4 = element4.getText();
            if(element.getText() != null && ! element.getText().equals("")){
                log.info("当前热水器的模式是：" + type4 + "点击选择模式：" );
                Heater.click("定时循环页面下的选择模式");
                Thread.sleep(2000);
                log.info("下面选择舒适畅享模式");
                Heater.click("定时循环舒适畅享");
                Thread.sleep(2000);
                log.info("下面校验舒适畅享模式是否选择成功");
                AndroidElement element1 = Heater.findelement("定时循环页面下的选择模式",1);
                String type1 = element1.getText();
                Heater.Assert(type1,"舒适畅享","选择舒适畅享模式没有成功。");
                log.info("点击确认按钮，返回设备控制页面检查模式回写。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(3000);
                AndroidElement element2 =  Heater.findelement("热水器状态",1);//通过热水器顶部的状态判定是不是返回控制也成功。
                if(element2.getText().equals("工作中")){
                    log.info("已经返回到热水器的控制页面啦。下面校验热水器的回写模式。");
                    AndroidElement element3 =  Heater.findelement("热水器控制页面的模式",1);
                    String type3 = element3.getText();
                    log.info("控制页面获取到的热水器模式为：" + type3 );
                    Heater.Assert(type3,"家有老幼","定时循环页面选择的舒适畅享模式与控制页面回写的模式不一致。");
                }else{
                    jt.takeScreenShot(driver,"返回热水器控制页面失败，或者热水器状态异常");
                    log.error("返回热水器控制页面失败，或者热水器状态异常");
                    boolean a = false;
                    test(a);
                }
            }else {
                jt.takeScreenShot(driver, "进入热水器的定时循环模式失败");
                log.error("进入热水器的定时循环模式失败。");
                boolean a = false;
                test(a);
            }
        }
        else{
            jt.takeScreenShot(driver,"热水器不在可操作状态!");
            log.error("热水器不在可操作状态！");
            boolean a = false;
            test(a);
        }
    }
/*整合模式回写流程*/
    public void HeaterTypeCheck() throws InterruptedException, DocumentException {
        SinglecycleReturnCheck();
        DirectreturnTypeCheck();
        DefaultTypeCheck();
        NineToFiveTypeCheck();
        OldAndYoungTypeCheck();
        ComfortableTypeCheck();
    }
}
