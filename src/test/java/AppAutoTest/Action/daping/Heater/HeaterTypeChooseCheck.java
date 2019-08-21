package AppAutoTest.Action.daping.Heater;

import AppAutoTest.start.Appaction;
import AppAutoTest.start.StartApp;
import Utils.Log;
import Utils.PrtScr;
import io.appium.java_client.android.AndroidElement;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import java.io.IOException;

/**
 * 热水器定时循环页面的模式时间配置校验:选择模式——>选择工作日设定——>点击重置按钮——>校验每个元素的背景颜色——>点击每个元素
 * ——>每个元素点击后的截图是被背景颜色——>点击确定按钮返回设备控制页面——>点击定时循环进入定时循环页面——>校验每个元素的背景颜色
 * ——>点击其中一行——>校验选中(取消选中)后的背景颜色——>点击确定返回设备控制页面——>
 * 进入定时循环页面下校验被点击选中取消的那一行元素的背景颜色和依然没有取消的背景颜色——>点击重置按钮校验每个元素的背景——>
 * 点击确定按钮返回设备控制页面——>点击定时循环进入定时循环页面——>选择休息日设定——>点击重置按钮——>校验每个元素的背景颜色——>点击每个元素
 * ——>每个元素点击后的截图是被背景颜色——>点击确定按钮返回设备控制页面——>点击定时循环进入定时循环页面——>校验每个元素的背景颜色——>点击其中一行
 * ——>校验选中(取消选中)后的背景颜色——>点击确定返回设备控制页面——>进入定时循环页面下校验被点击选中取消的那一行元素的背景颜色和依然没有取消的背景颜色
 * ——>点击重置按钮校验每个元素的背景
 */
public class HeaterTypeChooseCheck extends StartApp {
    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();
/*重置功能验证*/
    public void DefaultTypeCheck() throws DocumentException, InterruptedException, IOException {
        Appaction Heater = new Appaction("热水器设备控制");
        String[] modelArray = {"默认模式", "朝九晚五", "家有老幼","舒适畅享"};
        for(int i = 0; i < modelArray.length; i++) {
            String model = modelArray[i];
            log.info("先进入定时循环页面选择"+ model +"，工作日设定");
            log.info("下面点击定时循环");
            Heater.click("定时循环按钮");
            AndroidElement element = Heater.findelement("定时循环页面下的选择模式", 1);
            if (element != null) {
                log.info("进入定时循环页面成功，下面点选择"+ model +"。");
                Heater.click("定时循环页面下的选择模式");
                Thread.sleep(3000);
                log.info("下面选择" + model);
                Heater.click("定时循环" + model);
                Thread.sleep(3000);
                log.info("选择工作日设定");
//                Heater.click("定时循环工作日设定");
                AndroidElement ele =  (AndroidElement)driver.findElement(By.id("com.haiersmart.controlpanel:id/btn_workday"));
                ele.click();
                Thread.sleep(2000);
                log.info("下面点击选择模式，先点击重置，清空之前配置。");
                Heater.click("定时循环重置按钮");
                Thread.sleep(3000);
                log.info("下面校验卡片颜色。");
                for (int j = 1; j <= 7; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_week_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    if(model.equals("默认模式")){
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：393ab7");
                        Heater.Assert(colorvalue, "393ab7", "识别的色值与预期色值不符。");
                    }else{
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                        Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                    }
                }
                for (int j = 1; j <= 24; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                    Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                }

                log.info("下面选择" + model + "下的日期。");
                for (int j = 1; j <= 7; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_week_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("对设定的日期进行点击操作。");
                    AndroidElement element1 = (AndroidElement) driver.findElement(By.id(resourceid));
                    element1.click();
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    if(model.equals("默认模式")){
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：393ab7");
                        Heater.Assert(colorvalue, "393ab7", "识别的色值与预期色值不符。");
                    }else{
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：51d7ff");
                        Heater.Assert(colorvalue, "51d7ff", "识别的色值与预期色值不符。");
                    }
                }
                log.info("下面选择"+ model +"下的循环时间点。");
                for (int j = 1; j <= 24; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("对设定的日期进行点击操作。");
                    AndroidElement element1 = (AndroidElement) driver.findElement(By.id(resourceid));
                    element1.click();
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：ffad27");
                    Heater.Assert(colorvalue, "ffad27", "识别的色值与预期色值不符。");
                }

                log.info("下面点击定时循环页面确定按钮,返回控制页面了.");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(3000);
                AndroidElement element1 = Heater.findelement("热水器控制页面的模式", 1);
                Heater.Assert(element1.getText(), model, "定时循环模式下选择"+ model +"点击确定后，设备控制页面没有变为"+ model + "。");
                log.info("再次进入定时循环页面检查选择的日期和时间点。");
                Heater.click("定时循环按钮");
                Thread.sleep(3000);

                log.info("进入定时循环页面成功，下面点选择"+ model +"。");
                Heater.click("定时循环页面下的选择模式");
                Thread.sleep(3000);
                log.info("下面选择" + model);
                Heater.click("定时循环" + model);
                Thread.sleep(3000);
                log.info("选择工作日设定");
//                Heater.click("定时循环工作日设定");
                AndroidElement ele7 =  (AndroidElement)driver.findElement(By.id("com.haiersmart.controlpanel:id/btn_workday"));
                ele7.click();
                Thread.sleep(2000);


//                Heater.Assert(element2.getText(), model, "定时循环页面下的模式与上次选择的模式不符。");
                log.info("下面校验上次选择的配置。");
                /*选择配置完之后从设置页面重新进来*/
                log.info("下面校验"+ model +"下的日期。");
                for (int j = 1; j <= 7; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_week_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    if(model.equals("默认模式")){
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：393ab7");
                        Heater.Assert(colorvalue, "393ab7", "识别的色值与预期色值不符。");
                    }else{
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：51d7ff");
                        Heater.Assert(colorvalue, "51d7ff", "识别的色值与预期色值不符。");
                    }
                    log.info("设定日期校验完毕。");
                }
                log.info("下面校验"+ model +"下的循环时间点。");
                for (int j = 1; j <= 24; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：ffad27");
                    Heater.Assert(colorvalue, "ffad27", "识别的色值与预期色值不符。");
                    log.info("循环时间点校验完毕。");
                }
                log.info("下面校验循环时间点选中状态了。");
                for (int j = 1; j <= 8; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("对设定的日期进行点击操作。");
                    AndroidElement element3 = (AndroidElement) driver.findElement(By.id(resourceid));
                    element3.click();
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                    Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                }
                log.info("下面点击确定按钮返回设备控制页面。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(3000);
                AndroidElement element4 = Heater.findelement("热水器控制页面的模式", 1);
                Heater.Assert(element4.getText(), model, "定时循环页面下选择的模式与设备控制页面显示的不一致");
                log.info("再次进入定时循环页面校验上次设置的时间点。");
                Thread.sleep(3000);
                Heater.click("定时循环按钮");
                Thread.sleep(3000);

                log.info("进入定时循环页面成功，下面点选择"+ model +"。");
                Heater.click("定时循环页面下的选择模式");
                Thread.sleep(3000);
                log.info("下面选择" + model);
                Heater.click("定时循环" + model);
                Thread.sleep(3000);
                log.info("选择工作日设定");
//                Heater.click("定时循环工作日设定");
                AndroidElement ele8 =  (AndroidElement)driver.findElement(By.id("com.haiersmart.controlpanel:id/btn_workday"));
                ele8.click();
                Thread.sleep(2000);



                log.info("下面校验上次设置的配置。");
                log.info("下面校验"+ model +"下的日期。");
                for (int j = 1; j <= 7; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_week_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    if(model.equals("默认模式")){
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：393ab7");
                        Heater.Assert(colorvalue, "393ab7", "识别的色值与预期色值不符。");
                    }else{
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：51d7ff");
                        Heater.Assert(colorvalue, "51d7ff", "识别的色值与预期色值不符。");
                    }
                    log.info("设定日期校验完毕。");
                }
                log.info("下面校验循环时间点选中状态了。");
                for (int j = 1; j <= 8; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                    Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                }
                log.info("下面校验循环时间点选中状态了。");
                for (int j = 9; j <= 24; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：ffad27");
                    Heater.Assert(colorvalue, "ffad27", "识别的色值与预期色值不符。");
                }
                log.info("点击重置按钮了。");
                Heater.click("定时循环重置按钮");
                Thread.sleep(3000);
                log.info("下面校验重置后的设置。");
                log.info("下面校验"+ model +"下的日期。");
                for (int j = 1; j <= 7; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_week_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    if(model.equals("默认模式")){
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：393ab7");
                        Heater.Assert(colorvalue, "393ab7", "识别的色值与预期色值不符。");
                    }else{
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                        Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                    }
                    log.info("设定日期校验完毕。");
                }

                log.info("下面校验循环时间点选中状态了。");
                for (int j = 1; j <= 24; j++) {
                    String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                    System.out.println(resourceid);
                    log.info("调用元素截图方法进行元素截图。");
                    String resourceidpath = Heater.elementScreenshot(resourceid);
                    log.info("调用元素是被方法进行元素背景色值识别。");
                    String colorvalue = Heater.getImagePixel(resourceidpath);
                    log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                    Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                    log.info("设置时间点校验完毕。");
                }
                log.info("下面点击确定按钮。返回设备控制页面。");
                Heater.click("定时循环页面确定按钮");
                Thread.sleep(3000);
                AndroidElement element6 = Heater.findelement("热水器控制页面的模式", 1);
                Heater.Assert(element6.getText(), model, "定时循环页面下选择的模式与设备控制页面显示的不一致");
                log.info( model +"下的工作日设定下的选择设置校验完毕。");
                log.info("下面验证"+ model +"下的休息日设定下的选择设置。");


                log.info("先进入定时循环页面选择"+ model +"，休息日设定");
                log.info("下面点击定时循环");
                Heater.click("定时循环按钮");
                AndroidElement element7 = Heater.findelement("定时循环页面下的选择模式", 1);
                if (element7 != null) {
                    log.info("进入定时循环页面成功，下面点选择"+ model +"。");
                    Heater.click("定时循环页面下的选择模式");
                    Thread.sleep(3000);
                    log.info("下面选择"+ model);
                    Heater.click("定时循环"+ model);
                    Thread.sleep(3000);
                    log.info("选择休息日设定");
//                    Heater.click("定时循环休息日设定");
                    AndroidElement ele1 =  (AndroidElement)driver.findElement(By.id("com.haiersmart.controlpanel:id/btn_dayoff"));
                    ele1.click();
                    Thread.sleep(2000);
                    log.info("下面点击选择模式，先点击重置，清空之前配置。");
                    Heater.click("定时循环重置按钮");
                    Thread.sleep(3000);
                    log.info("下面校验卡片颜色。");
                    for (int j = 1; j <= 7; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_week_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        if(model.equals("默认模式")){
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：393ab7");
                            Heater.Assert(colorvalue, "393ab7", "识别的色值与预期色值不符。");
                        }else{
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                            Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                        }
                    }
                    for (int j = 1; j <= 24; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                        Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                    }

                    log.info("下面选择"+ model +"下的日期。");
                    for (int j = 1; j <= 7; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_week_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("对设定的日期进行点击操作。");
                        AndroidElement element8 = (AndroidElement) driver.findElement(By.id(resourceid));
                        element8.click();
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        if(model.equals("默认模式")){
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：393ab7");
                            Heater.Assert(colorvalue, "393ab7", "识别的色值与预期色值不符。");
                        }else{
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：51d7ff");
                            Heater.Assert(colorvalue, "51d7ff", "识别的色值与预期色值不符。");
                        }

                    }
                    log.info("下面选择"+ model +"下的循环时间点。");
                    for (int j = 1; j <= 24; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("对设定的日期进行点击操作。");
                        AndroidElement element9 = (AndroidElement) driver.findElement(By.id(resourceid));
                        element9.click();
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：ffad27");
                        Heater.Assert(colorvalue, "ffad27", "识别的色值与预期色值不符。");
                    }

                    log.info("下面点击定时循环页面确定按钮,返回控制页面了.");
                    Heater.click("定时循环页面确定按钮");
                    Thread.sleep(3000);
                    AndroidElement element10 = Heater.findelement("热水器控制页面的模式", 1);
                    Heater.Assert(element10.getText(), model, "定时循环模式下选择"+ model +"点击确定后，设备控制页面没有变为" +  model + "。");
                    log.info("再次进入定时循环页面检查选择的日期和时间点。");
                    Heater.click("定时循环按钮");
                    Thread.sleep(3000);

                    log.info("进入定时循环页面成功，下面点选择"+ model +"。");
                    Heater.click("定时循环页面下的选择模式");
                    Thread.sleep(3000);
                    log.info("下面选择" + model);
                    Heater.click("定时循环" + model);
                    Thread.sleep(3000);


                    log.info("点击休息日设定，校验上次选择的配置。");
                    AndroidElement ele2 =  (AndroidElement)driver.findElement(By.id("com.haiersmart.controlpanel:id/btn_dayoff"));
                    ele2.click();
                    Thread.sleep(3000);
                    log.info("下面校验"+ model + "下的日期。");
                    for (int j = 1; j <= 7; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_week_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        if(model.equals("默认模式")){
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：393ab7");
                            Heater.Assert(colorvalue, "393ab7", "识别的色值与预期色值不符。");
                            log.info("设定日期校验完毕。");
                        }else{
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：51d7ff");
                            Heater.Assert(colorvalue, "51d7ff", "识别的色值与预期色值不符。");
                            log.info("设定日期校验完毕。");
                        }

                    }
                    log.info("下面选择"+ model +"下的循环时间点。");
                    for (int j = 1; j <= 24; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：ffad27");
                        Heater.Assert(colorvalue, "ffad27", "识别的色值与预期色值不符。");
                        log.info("循环时间点校验完毕。");
                    }
                    log.info("下面校验循环时间点选中状态了。");
                    for (int j = 1; j <= 8; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("对设定的日期进行点击操作。");
                        AndroidElement element3 = (AndroidElement) driver.findElement(By.id(resourceid));
                        element3.click();
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                        Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                    }
                    log.info("下面点击确定按钮返回设备控制页面。");
                    Heater.click("定时循环页面确定按钮");
                    Thread.sleep(3000);
                    AndroidElement element12 = Heater.findelement("热水器控制页面的模式", 1);
                    Heater.Assert(element12.getText(), model, "定时循环页面下选择的模式与设备控制页面显示的不一致");
                    log.info("再次进入定时循环页面校验上次设置的时间点。");
                    Heater.click("定时循环按钮");
                    Thread.sleep(3000);


                    log.info("进入定时循环页面成功，下面点选择"+ model +"。");
                    Heater.click("定时循环页面下的选择模式");
                    Thread.sleep(3000);
                    log.info("下面选择" + model);
                    Heater.click("定时循环" + model);
                    Thread.sleep(3000);
                    log.info("选择休息日设定");
//                Heater.click("定时循环工作日设定");
                    AndroidElement ele10 =  (AndroidElement)driver.findElement(By.id("com.haiersmart.controlpanel:id/btn_dayoff"));
                    ele10.click();
                    Thread.sleep(2000);





                    log.info("下面校验"+ model +"下的日期。");
                    for (int j = 1; j <= 7; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_week_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        if(model.equals("默认模式")){
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：393ab7");
                            Heater.Assert(colorvalue, "393ab7", "识别的色值与预期色值不符。");
                            log.info("设定日期校验完毕。");
                        }else{
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：51d7ff");
                            Heater.Assert(colorvalue, "51d7ff", "识别的色值与预期色值不符。");
                            log.info("设定日期校验完毕。");
                        }
                    }
                    log.info("下面校验循环时间点选中状态了。");
                    for (int j = 1; j <= 8; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                        Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                    }
                    log.info("下面校验未循环时间点选中状态了。");
                    for (int j = 9; j <= 24; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：ffad27");
                        Heater.Assert(colorvalue, "ffad27", "识别的色值与预期色值不符。");
                    }
                    log.info("点击重置按钮了。");
                    Heater.click("定时循环重置按钮");
                    Thread.sleep(3000);
                    log.info("下面校验重置后的设置。");
                    log.info("下面校验"+ model +"下的日期。");
                    for (int j = 1; j <= 7; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_week_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        if(model.equals("默认模式")){
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：393ab7");
                            Heater.Assert(colorvalue, "393ab7", "识别的色值与预期色值不符。");
                            log.info("设定日期校验完毕。");
                        }else{
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                            Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                            log.info("设定日期校验完毕。");
                        }
                    }

                    log.info("下面校验未循环时间点选中状态了。");
                    for (int j = 1; j <= 24; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                        Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                        log.info("设置时间点校验完毕。");
                    }
                    log.info("下面点击确定按钮。返回设备控制页面。");
                    Heater.click("定时循环页面确定按钮");
                    Thread.sleep(3000);
                    AndroidElement element14 = Heater.findelement("热水器控制页面的模式", 1);
                    Heater.Assert(element14.getText(), model, "定时循环页面下选择的模式与设备控制页面显示的不一致");
                    log.info("再次进入定时循环页面校验重置效果。");
                    Heater.click("定时循环按钮");
                    Thread.sleep(3000);

                    log.info("进入定时循环页面成功，下面点选择"+ model +"。");
                    Heater.click("定时循环页面下的选择模式");
                    Thread.sleep(3000);
                    log.info("下面选择" + model);
                    Heater.click("定时循环" + model);
                    Thread.sleep(3000);
                    log.info("选择休息日设定");
//                Heater.click("定时循环工作日设定");
                    AndroidElement ele11 =  (AndroidElement)driver.findElement(By.id("com.haiersmart.controlpanel:id/btn_dayoff"));
                    ele11.click();
                    Thread.sleep(2000);



                    Thread.sleep(3000);
                    log.info("下面校验重置效果。");
                    log.info("下面校验"+ model +"下的日期。");
                    for (int j = 1; j <= 7; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_week_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        if(model.equals("默认模式")){
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：393ab7");
                            Heater.Assert(colorvalue, "393ab7", "识别的色值与预期色值不符。");
                            log.info("设定日期校验完毕。");
                        }else{
                            log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                            Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                            log.info("设定日期校验完毕。");
                        }
                    }

                    log.info("下面校验未循环时间点选中状态了。");
                    for (int j = 1; j <= 24; j++) {
                        String resourceid = "com.haiersmart.controlpanel:id/box_" + j;//组装resource-id
                        System.out.println(resourceid);
                        log.info("调用元素截图方法进行元素截图。");
                        String resourceidpath = Heater.elementScreenshot(resourceid);
                        log.info("调用元素是被方法进行元素背景色值识别。");
                        String colorvalue = Heater.getImagePixel(resourceidpath);
                        log.info("resourceid为：" + resourceid + "识别的色值为：（已去除透明度）" + colorvalue + "预期色值为：b4b9cd");
                        Heater.Assert(colorvalue, "b4b9cd", "识别的色值与预期色值不符。");
                        log.info("设置时间点校验完毕。");
                    }
                    log.info(model + "下的休息日设定下的选择设置校验完毕。");
                    log.info("验证完毕返回设备控制页面。");
                    Heater.click(40,60);
                } else {
                    jt.takeScreenShot(driver, "进入定时循环页面失败。");
                    log.error("进入定时循环页面失败");
                }
            }
        }

    }
}
