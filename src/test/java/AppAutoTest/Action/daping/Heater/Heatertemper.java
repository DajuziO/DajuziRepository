package AppAutoTest.Action.daping.Heater;

import AppAutoTest.Action.daping.Public.OpenSweeping;
import AppAutoTest.start.Appaction;
import AppAutoTest.start.StartApp;
import Utils.Log;
import Utils.PrtScr;
import Utils.ReadExcelUtil;
import io.appium.java_client.android.AndroidElement;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class Heatertemper extends StartApp {

    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();
/*热水器加温度操作*/
    public void HeatertemperAdd() throws DocumentException, InterruptedException, IOException {
        Appaction Heater = new Appaction("热水器设备控制");
        AndroidElement Heaterstatus = Heater.findelement("热水器状态", 1);
        String heaterstatus = Heaterstatus.getText();
        if (heaterstatus.equals("工作中")) {
            AndroidElement Heatertemperature = Heater.findelement("热水器显示温度", 1);
            int heatertemperature = Integer.parseInt(Heatertemperature.getText());
            log.info("热水器当前的温度是：" + heatertemperature + "摄氏度");
            //TODO 调试温度
            System.out.println(heatertemperature);
            int j = 0;
            if(heatertemperature >= 35 && heatertemperature <60 ){
                for(int i = 1; i <=(60 - heatertemperature);i++) {
                    AndroidElement Heatertemperature2 = Heater.findelement("热水器显示温度", 1);
                    int heatertemperature1 = Integer.parseInt(Heatertemperature2.getText());
                    String heatertemperature2 = Integer.toString(heatertemperature1 + 1);//点击加温度按钮之后的预期温度，每点一次加一度
                    System.out.println("当前温度" + heatertemperature1);
                    if (heatertemperature1 < 50) {
                        log.info("热水器的温度还不到50度，继续点击加温度按钮。");
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature15 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature17 = Heatertemperature15.getText();
                        Heater.Assert(heatertemperature17, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature17);
                    } else if (heatertemperature1 >= 50 && j < 1) {
                        log.info("温度已经达到或者超过50度了，处理弹出框了。现在温度" + heatertemperature);
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element =  Heater.findelementbyclass("android.widget.TextView","温馨提示",1);
//                        Heater.Assert(element.getText(),"温馨提示","没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示取消");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature3 = Heater.findelement("热水器显示温度", 1);
                        Heater.Assert(Heatertemperature3.getText(), Heatertemperature2.getText(), "弹出框点击取消按钮，热水器温度不应该变化");
                        Thread.sleep(3000);

                        Heater.click(40,60);
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator = ReadExcelUtil.getStringData();
                        while (iterator.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            System.out.println(classtext);
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("烟机")) {
                                /*打开热水器模块*/
                                log.info("下面打开烟机模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,2);//传入设备控制中要定位的元素的classname
                                Thread.sleep(3000);


                                Heater.click(40,60);
                            }
                        }

                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator5 = ReadExcelUtil.getStringData();
                        while (iterator5.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator5.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            System.out.println(classtext);
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("热水器")) {
                                /*打开热水器模块*/
                                log.info("下面打开燃气热水器模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                            }
                        }
                        Thread.sleep(3000);
                        AndroidElement Heaterstatus5 = Heater.findelement("热水器状态", 1);
                        String heaterstatus5 = Heaterstatus5.getText();
                        Heater.Assert(heaterstatus5, "工作中", "热水器状态变不是工作中状态。");
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element1 = Heater.findelementbyclass("android.widget.TextView", "温馨提示", 1);
//                        Heater.Assert(element1.getText(), "温馨提示", "没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示确认");
                        AndroidElement Heatertemperature13 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature13 = Heatertemperature13.getText();
                        int heatertemperature15 = Integer.parseInt(Heatertemperature13.getText());
                        Heater.Assert(heatertemperature13, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature13);
                   j++;
                    }else if(heatertemperature1 >= 50 && j >= 1){
                        log.info("热水器已经处理过弹出框，继续点击加温度按钮。");
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature15 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature17 = Heatertemperature15.getText();
                        Heater.Assert(heatertemperature17, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature17);
                    }
                }
                log.info("热水器已经60度了。");
            }else if( heatertemperature ==60){
                log.info("热水器已经60度了。");
            }
        }else if(heaterstatus.equals("关机")) {
            Heater.click("热水器开关");
            Thread.sleep(3000);
            AndroidElement Heaterstatus1 = Heater.findelement("热水器状态", 1);
            String heaterstatus1 = Heaterstatus1.getText();
            log.info("获取热水器的状态是：" + heaterstatus1);
            Heater.Assert(heaterstatus1, "工作中", "关机状态下点击热水器开关，3秒内没有变成工作中状态。");//关机状态下点击电源开关，校验3秒内由关机状态变为工作中状态
            AndroidElement Heatertemperature = Heater.findelement("热水器显示温度", 1);
            int heatertemperature = Integer.parseInt(Heatertemperature.getText());
            log.info("热水器当前的温度是：" + heatertemperature + "摄氏度");
            //TODO 调试温度
            System.out.println("初始温度" + heatertemperature);
            int j = 0;
            if(heatertemperature >= 35 && heatertemperature <60 ){
                for(int i = 1; i <=(60 - heatertemperature);i++) {
                    AndroidElement Heatertemperature2 = Heater.findelement("热水器显示温度", 1);
                    int heatertemperature1 = Integer.parseInt(Heatertemperature2.getText());
                    String heatertemperature2 = Integer.toString(heatertemperature1 + 1);//点击加温度按钮之后的预期温度，每点一次加一度
                    System.out.println(heatertemperature);
                    if (heatertemperature1 < 50) {
                        log.info("热水器的温度还不到50度，继续点击加温度按钮。");
                        log.info("点击加温度按钮。");
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature15 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature17 = Heatertemperature15.getText();
                        Heater.Assert(heatertemperature17, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature17);
                    } else if (heatertemperature1 >= 50 && j < 1) {
                        log.info("温度已经达到或者超过50度了，处理弹出框了。现在温度" + heatertemperature);
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element =  Heater.findelementbyclass("android.widget.TextView","温馨提示",1);
//                        Heater.Assert(element.getText(),"温馨提示","没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示取消");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature3 = Heater.findelement("热水器显示温度", 1);
                        Heater.Assert(Heatertemperature3.getText(), Heatertemperature2.getText(), "弹出框点击取消按钮，热水器温度不应该变化");
                        Thread.sleep(3000);
                        Heater.click(40,60);
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator = ReadExcelUtil.getStringData();
                        while (iterator.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            System.out.println(classtext);
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("烟机")) {
                                /*打开热水器模块*/
                                log.info("下面打开烟机模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,3);//传入设备控制中要定位的元素的classname
                                Thread.sleep(3000);
                                Heater.click(40,60);
                            }
                        }

                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator5 = ReadExcelUtil.getStringData();
                        while (iterator5.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator5.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            System.out.println(classtext);
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("热水器")) {
                                /*打开热水器模块*/
                                log.info("下面打开燃气热水器模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                            }
                        }
                        Thread.sleep(3000);
                        AndroidElement Heaterstatus5 = Heater.findelement("热水器状态", 1);
                        String heaterstatus5 = Heaterstatus5.getText();
                        Heater.Assert(heaterstatus5, "工作中", "热水器状态变不是工作中状态。");
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element1 = Heater.findelementbyclass("android.widget.TextView", "温馨提示", 1);
//                        Heater.Assert(element1.getText(), "温馨提示", "没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示确认");
                        AndroidElement Heatertemperature13 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature13 = Heatertemperature13.getText();
                        int heatertemperature15 = Integer.parseInt(Heatertemperature13.getText());
                        Heater.Assert(heatertemperature13, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature13);
                        j++;
                    }else if(heatertemperature1 >= 50 && j >= 1){
                        log.info("热水器已经处理过弹出框，继续点击加温度按钮。");
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature15 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature17 = Heatertemperature15.getText();
                        Heater.Assert(heatertemperature17, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature17);
                    }
                }
                log.info("热水器已经60度了。");
            }else if( heatertemperature ==60){
                log.info("热水器已经60度了。");
            }
        }
    }
/*热水器减温度操作*/
    public void HeatertemperSubtraction() throws DocumentException, InterruptedException, IOException {
        Appaction Heater = new Appaction("热水器设备控制");
        AndroidElement Heaterstatus = Heater.findelement("热水器状态", 1);
        String heaterstatus = Heaterstatus.getText();
        if (heaterstatus.equals("工作中")) {
            AndroidElement Heatertemperature = Heater.findelement("热水器显示温度", 1);
            int heatertemperature = Integer.parseInt(Heatertemperature.getText());
            log.info("热水器当前的温度是：" + heatertemperature + "摄氏度");
            //TODO 调试温度
            System.out.println(heatertemperature);
            int j = 0;
            if(heatertemperature >= 35 && heatertemperature <60 ){
                for(int i = 1; i <=(60 - heatertemperature);i++) {
                    AndroidElement Heatertemperature2 = Heater.findelement("热水器显示温度", 1);
                    int heatertemperature1 = Integer.parseInt(Heatertemperature2.getText());
                    String heatertemperature2 = Integer.toString(heatertemperature1 + 1);//点击加温度按钮之后的预期温度，每点一次加一度
                    System.out.println(heatertemperature);
                    if (heatertemperature1 < 50) {
                        log.info("热水器的温度还不到50度，继续点击加温度按钮。");
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature15 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature17 = Heatertemperature15.getText();
                        Heater.Assert(heatertemperature17, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature17);
                    } else if (heatertemperature1 >= 50 && j < 1) {
                        log.info("温度已经达到或者超过50度了，处理弹出框了。现在温度" + heatertemperature);
                        Thread.sleep(3000);
                        AndroidElement Heaterstatus5 = Heater.findelement("热水器状态", 1);
                        String heaterstatus5 = Heaterstatus5.getText();
                        Heater.Assert(heaterstatus5, "工作中", "热水器状态变不是工作中状态。");
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element1 = Heater.findelementbyclass("android.widget.TextView", "温馨提示", 1);
//                        Heater.Assert(element1.getText(), "温馨提示", "没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示确认");
                        AndroidElement Heatertemperature13 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature13 = Heatertemperature13.getText();
                        int heatertemperature15 = Integer.parseInt(Heatertemperature13.getText());
                        Heater.Assert(heatertemperature13, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature13);
                        Heater.click(40,60);
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator = ReadExcelUtil.getStringData();
                        while (iterator.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            System.out.println(classtext);
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("烟机")) {
                                /*打开热水器模块*/
                                log.info("下面打开烟机模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                                Thread.sleep(3000);
                                Heater.click(40,60);
                            }
                        }
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator5 = ReadExcelUtil.getStringData();
                        while (iterator5.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator5.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            System.out.println(classtext);
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("热水器")) {
                                /*打开热水器模块*/
                                log.info("下面打开燃气热水器模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                            }
                        }

                        Thread.sleep(3000);
                        AndroidElement Heaterstatus11 = Heater.findelement("热水器状态", 1);
                        String heaterstatus11 = Heaterstatus11.getText();
                        Heater.Assert(heaterstatus11,"工作中","热水器不是工作中状态。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element4 =  Heater.findelementbyclass("android.widget.TextView","温馨提示",1);
//                        Heater.Assert(element4.getText(),"温馨提示","没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示取消");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature12 = Heater.findelement("热水器显示温度", 1);
                        Heater.Assert(Heatertemperature12.getText(),heatertemperature13,"弹出框点击取消按钮，热水器温度不应该变化");
                        Thread.sleep(3000);
                        Heater.click(40,60);
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator2 = ReadExcelUtil.getStringData();
                        while (iterator2.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator2.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("烟机")) {
                                /*打开热水器模块*/
                                log.info("下面打开烟机模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                                Thread.sleep(3000);
                                Heater.click(40,60);
                            }
                        }

                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator9 = ReadExcelUtil.getStringData();
                        while (iterator9.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator9.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("燃气热水器")) {
                                /*打开热水器模块*/
                                log.info("下面打开燃气热水器模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                            }
                        }
                        Thread.sleep(3000);
                        AndroidElement Heaterstatus9 = Heater.findelement("热水器状态", 1);
                        String heaterstatus9 = Heaterstatus5.getText();
                        Heater.Assert(heaterstatus9,"工作中","热水器不是工作中状态。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element3 = Heater.findelementbyclass("android.widget.TextView", "温馨提示", 1);
//                        Heater.Assert(element3.getText(), "温馨提示", "没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示确认");
                        AndroidElement Heatertemperature14 = Heater.findelement("热水器显示温度", 1);//获取点击减号之后的实际的温度
                        String heatertemperature16 =  Integer.toString( heatertemperature15 - 1);
                        Heater.Assert(Heatertemperature14.getText(),heatertemperature16,"点击减温度的按钮，热水器下降温度没达预期，预期温度：" + heatertemperature16 + "实际温度：" + Heatertemperature14.getText());
                        j++;
                    }else if(heatertemperature1 >= 50 && j >= 1){
                        log.info("热水器已经处理过弹出框，继续点击加温度按钮。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature15 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature17 = Heatertemperature15.getText();
                        Heater.Assert(heatertemperature17, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature17);
                    }
                }
                log.info("热水器已经35度了。");
            }else if( heatertemperature ==60){
                log.info("热水器已经60度了。");
                int k = 0;
                for(int i = 1; i <=( heatertemperature - 35);i++) {
                    AndroidElement Heatertemperature2 = Heater.findelement("热水器显示温度", 1);
                    int heatertemperature1 = Integer.parseInt(Heatertemperature2.getText());
                    String heatertemperature2 = Integer.toString(heatertemperature1 - 1);//点击加温度按钮之后的预期温度，每点一次加一度
                    System.out.println(heatertemperature);
                  if (k < 1) {
                        log.info("温度已经达到或者超过60度了，处理弹出框了。现在温度" + heatertemperature);
                        AndroidElement Heatertemperature13 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature13 = Heatertemperature13.getText();
                        int heatertemperature15 = Integer.parseInt(Heatertemperature13.getText());
                        Heater.click(40,60);
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator = ReadExcelUtil.getStringData();
                        while (iterator.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            System.out.println(classtext);
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("烟机")) {
                                /*打开热水器模块*/
                                log.info("下面打开烟机模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                                Thread.sleep(3000);
                                Heater.click(40,60);
                            }
                        }
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator5 = ReadExcelUtil.getStringData();
                        while (iterator5.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator5.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            System.out.println(classtext);
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("热水器")) {
                                /*打开热水器模块*/
                                log.info("下面打开燃气热水器模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                            }
                        }

                        Thread.sleep(3000);
                        AndroidElement Heaterstatus11 = Heater.findelement("热水器状态", 1);
                        String heaterstatus11 = Heaterstatus11.getText();
                        Heater.Assert(heaterstatus11,"工作中","热水器不是工作中状态。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element4 =  Heater.findelementbyclass("android.widget.TextView","温馨提示",1);
//                        Heater.Assert(element4.getText(),"温馨提示","没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示取消");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature12 = Heater.findelement("热水器显示温度", 1);
                        Heater.Assert(Heatertemperature12.getText(),heatertemperature13,"弹出框点击取消按钮，热水器温度不应该变化");
                        Thread.sleep(3000);
                        Heater.click(40,60);
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator2 = ReadExcelUtil.getStringData();
                        while (iterator2.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator2.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("烟机")) {
                                /*打开热水器模块*/
                                log.info("下面打开烟机模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                                Thread.sleep(3000);
                                Heater.click(40,60);
                            }
                        }

                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator9 = ReadExcelUtil.getStringData();
                        while (iterator9.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator9.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("热水器")) {
                                /*打开热水器模块*/
                                log.info("下面打开燃气热水器模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                            }
                        }
                        Thread.sleep(3000);
                        AndroidElement Heaterstatus9 = Heater.findelement("热水器状态", 1);
                        String heaterstatus9 = Heaterstatus9.getText();
                        Heater.Assert(heaterstatus9,"工作中","热水器不是工作中状态。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element3 = Heater.findelementbyclass("android.widget.TextView", "温馨提示", 1);
//                        Heater.Assert(element3.getText(), "温馨提示", "没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示确认");
                        AndroidElement Heatertemperature14 = Heater.findelement("热水器显示温度", 1);//获取点击减号之后的实际的温度
                        String heatertemperature16 =  Integer.toString( heatertemperature15 - 1);
                        Heater.Assert(Heatertemperature14.getText(),heatertemperature16,"点击减温度的按钮，热水器下降温度没达预期，预期温度：" + heatertemperature16 + "实际温度：" + Heatertemperature14.getText());
                        k++;
                    }else if(heatertemperature1 > 35 && k >= 1){
                        log.info("热水器已经处理过弹出框，继续点击加温度按钮。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature15 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature17 = Heatertemperature15.getText();
                        Heater.Assert(heatertemperature17,heatertemperature2 , "点击减温度的按钮，热水器下降温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature17);
                    }
                }
                log.info("热水器已经35度了。");
                }
        }else if(heaterstatus.equals("关机")) {
            Heater.click("热水器开关");
            Thread.sleep(3000);
            AndroidElement Heaterstatus1 = Heater.findelement("热水器状态", 1);
            String heaterstatus1 = Heaterstatus1.getText();
            log.info("获取热水器的状态是：" + heaterstatus1);
            Heater.Assert(heaterstatus1, "工作中", "关机状态下点击热水器开关，3秒内没有变成工作中状态。");//关机状态下点击电源开关，校验3秒内由关机状态变为工作中状态
            AndroidElement Heatertemperature = Heater.findelement("热水器显示温度", 1);
            int heatertemperature = Integer.parseInt(Heatertemperature.getText());
            log.info("热水器当前的温度是：" + heatertemperature + "摄氏度");
            //TODO 调试温度
            System.out.println(heatertemperature);
            int j = 0;
            if(heatertemperature >= 35 && heatertemperature <60 ){
                for(int i = 1; i <=(60 - heatertemperature);i++) {
                    AndroidElement Heatertemperature2 = Heater.findelement("热水器显示温度", 1);
                    int heatertemperature1 = Integer.parseInt(Heatertemperature2.getText());
                    String heatertemperature2 = Integer.toString(heatertemperature1 + 1);//点击加温度按钮之后的预期温度，每点一次加一度
                    System.out.println(heatertemperature);
                    if (heatertemperature1 < 50) {
                        log.info("热水器的温度还不到50度，继续点击加温度按钮。");
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature15 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature17 = Heatertemperature15.getText();
                        Heater.Assert(heatertemperature17, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature17);
                    } else if (heatertemperature1 >= 50 && j < 1) {
                        log.info("温度已经达到或者超过50度了，处理弹出框了。现在温度" + heatertemperature);
                        Thread.sleep(3000);
                        AndroidElement Heaterstatus5 = Heater.findelement("热水器状态", 1);
                        String heaterstatus5 = Heaterstatus5.getText();
                        Heater.Assert(heaterstatus5, "工作中", "热水器状态变不是工作中状态。");
                        Heater.click("热水器加温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element1 = Heater.findelementbyclass("android.widget.TextView", "温馨提示", 1);
//                        Heater.Assert(element1.getText(), "温馨提示", "没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示确认");
                        AndroidElement Heatertemperature13 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature13 = Heatertemperature13.getText();
                        int heatertemperature15 = Integer.parseInt(Heatertemperature13.getText());
                        Heater.Assert(heatertemperature13, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature13);
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator = ReadExcelUtil.getStringData();
                        while (iterator.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            System.out.println(classtext);
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("烟机")) {
                                /*打开热水器模块*/
                                log.info("下面打开烟机模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                                Thread.sleep(3000);
                            }
                        }
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator5 = ReadExcelUtil.getStringData();
                        while (iterator5.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator5.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            System.out.println(classtext);
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("热水器")) {
                                /*打开热水器模块*/
                                log.info("下面打开燃气热水器模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                            }
                        }

                        Thread.sleep(3000);
                        AndroidElement Heaterstatus11 = Heater.findelement("热水器状态", 1);
                        String heaterstatus11 = Heaterstatus11.getText();
                        Heater.Assert(heaterstatus11,"工作中","热水器不是工作中状态。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element4 =  Heater.findelementbyclass("android.widget.TextView","温馨提示",1);
//                        Heater.Assert(element4.getText(),"温馨提示","没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示取消");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature12 = Heater.findelement("热水器显示温度", 1);
                        Heater.Assert(Heatertemperature12.getText(),heatertemperature13,"弹出框点击取消按钮，热水器温度不应该变化");
                        Thread.sleep(3000);
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator2 = ReadExcelUtil.getStringData();
                        while (iterator2.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator2.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("烟机")) {
                                /*打开热水器模块*/
                                log.info("下面打开烟机模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                                Thread.sleep(3000);
                            }
                        }

                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator9 = ReadExcelUtil.getStringData();
                        while (iterator9.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator9.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("热水器")) {
                                /*打开热水器模块*/
                                log.info("下面打开燃气热水器模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                            }
                        }
                        Thread.sleep(3000);
                        AndroidElement Heaterstatus9 = Heater.findelement("热水器状态", 1);
                        String heaterstatus9 = Heaterstatus5.getText();
                        Heater.Assert(heaterstatus9,"工作中","热水器不是工作中状态。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element3 = Heater.findelementbyclass("android.widget.TextView", "温馨提示", 1);
//                        Heater.Assert(element3.getText(), "温馨提示", "没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示确认");
                        AndroidElement Heatertemperature14 = Heater.findelement("热水器显示温度", 1);//获取点击减号之后的实际的温度
                        String heatertemperature16 =  Integer.toString( heatertemperature15 - 1);
                        Heater.Assert(Heatertemperature14.getText(),heatertemperature16,"点击减温度的按钮，热水器下降温度没达预期，预期温度：" + heatertemperature16 + "实际温度：" + Heatertemperature14.getText());
                        j++;
                    }else if(heatertemperature1 >= 50 && j >= 1){
                        log.info("热水器已经处理过弹出框，继续点击加温度按钮。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature15 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature17 = Heatertemperature15.getText();
                        Heater.Assert(heatertemperature17, heatertemperature2, "点击加温度的按钮，热水器上升温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature17);
                    }
                }
                log.info("热水器已经35度了。");
            }else if( heatertemperature ==60){
                log.info("热水器已经60度了。");
                int k = 0;
                for(int i = 1; i <=( heatertemperature - 35);i++) {
                    AndroidElement Heatertemperature2 = Heater.findelement("热水器显示温度", 1);
                    int heatertemperature1 = Integer.parseInt(Heatertemperature2.getText());
                    String heatertemperature2 = Integer.toString(heatertemperature1 - 1);//点击减温度按钮之后的预期温度，每点一次减一度
                    System.out.println(heatertemperature);
                    if (k < 1) {
                        log.info("温度已经达到或者超过50度了，处理弹出框了。现在温度" + heatertemperature);
                        Thread.sleep(3000);
                        AndroidElement Heaterstatus11 = Heater.findelement("热水器状态", 1);
                        String heaterstatus11 = Heaterstatus11.getText();
                        Heater.Assert(heaterstatus11,"工作中","热水器不是工作中状态。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element4 =  Heater.findelementbyclass("android.widget.TextView","温馨提示",1);
//                        Heater.Assert(element4.getText(),"温馨提示","没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示取消");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature12 = Heater.findelement("热水器显示温度", 1);
                        Heater.Assert(Heatertemperature12.getText(),Heatertemperature2.getText(),"弹出框点击取消按钮，热水器温度不应该变化");
                        Thread.sleep(3000);
                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator2 = ReadExcelUtil.getStringData();
                        while (iterator2.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator2.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("烟机")) {
                                /*打开热水器模块*/
                                log.info("下面打开烟机模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                                Thread.sleep(3000);
                            }
                        }

                        log.info("切换卡片操作。");
                        /*再次唤出弹出框点击确认按钮,唤出方法是切换卡片，下面打开烟机卡片*/
                        Iterator iterator9 = ReadExcelUtil.getStringData();
                        while (iterator9.hasNext()) {
                            Map<String, String> map = (Map<String, String>) iterator9.next();
                            String udid = map.get("udid");
                            String classname = map.get("classname");
                            String classtext = map.get("classtext");
                            String content = map.get("content");
                            // TODO /*这里的话要保证烟机的数据在燃气热水器之前，后期优化为按指定的key读取*/
                            if (udid != null && classtext.contains("热水器")) {
                                /*打开热水器模块*/
                                log.info("下面打开燃气热水器模块。");
                                OpenSweeping devices = new OpenSweeping();
                                devices.OpenSweeping(classname, classtext, content,0);//传入设备控制中要定位的元素的classname
                            }
                        }
                        Thread.sleep(3000);
                        AndroidElement Heaterstatus9 = Heater.findelement("热水器状态", 1);
                        String heaterstatus9 = Heaterstatus9.getText();
                        Heater.Assert(heaterstatus9,"工作中","热水器不是工作中状态。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
//                        AndroidElement element3 = Heater.findelementbyclass("android.widget.TextView", "温馨提示", 1);
//                        Heater.Assert(element3.getText(), "温馨提示", "没有定位到温馨提示弹出框！！！");//判断有无弹出框
                        Heater.click("温馨提示确认");
                        AndroidElement Heatertemperature14 = Heater.findelement("热水器显示温度", 1);//获取点击减号之后的实际的温度
                        Heater.Assert(Heatertemperature14.getText(),heatertemperature2,"点击减温度的按钮，热水器下降温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + Heatertemperature14.getText());
                        j++;
                    }else if(heatertemperature1 > 35 && k >= 1){
                        log.info("热水器已经处理过弹出框，继续点击加温度按钮。");
                        Heater.click("热水器减温度按钮");
                        Thread.sleep(3000);
                        AndroidElement Heatertemperature15 = Heater.findelement("热水器显示温度", 1);//获取点击加号之后的实际的温度
                        String heatertemperature17 = Heatertemperature15.getText();
                        Heater.Assert(heatertemperature17, heatertemperature2, "点击减温度的按钮，热水器下降温度没达预期，预期温度：" + heatertemperature2 + "实际温度：" + heatertemperature17);
                    }
                }
                log.info("热水器已经35度了。");
            }
        }
    }
    public void HeatertemperatureContor() throws DocumentException, InterruptedException, IOException {
        HeatertemperAdd();
        HeatertemperSubtraction();
    }
}
