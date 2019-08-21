package AppAutoTest.Action.daping.Public;

import AppAutoTest.start.Appaction;
import AppAutoTest.start.StartApp;
import Utils.Log;
import Utils.PrtScr;
import io.appium.java_client.android.AndroidElement;
import org.dom4j.DocumentException;

public class OpenSweeping  extends StartApp {

    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();

    /**
     * 在设备控制模块下点击扫设备图标打开要打开的设备模块
     * 传入设备控制中要定位的元素的classname,text
     * content这个是点击设备之后的页面顶部的设备名称，区别于text
     */
    public void OpenSweeping(String classname ,String classtext,String content,int j) {
        try {
            Appaction opensweeping = new Appaction("设备控制");
            AndroidElement selectallbutton = opensweeping.findelement("查看全部", 1);
            String buttontext = selectallbutton.getText();
            if (buttontext.equals("查看全部")) {
                opensweeping.click("查看全部");
                AndroidElement element4 = opensweeping.findelement("查看全部",1);
                opensweeping.Assert(element4.getText(),"收起","点击查看全部按钮没有成功");
                Thread.sleep(3000);
                int i = 1;
                AndroidElement element2 = opensweeping.findelementbyclass(classname, classtext, i);
                while (element2 == null && i <= 4) {
                    opensweeping.slide(510, 1267, 510, 922);//这一步是要查找的元素不在本页面的时候进行滑动操作，每次上滑一行
                    Thread.sleep(3000);
                    element2 = opensweeping.findelementbyclass(classname, classtext, i);
                    i++;
                }
                log.info("下面点击：" + classtext);
                element2.click();
            } else if(buttontext.equals("收起")){
                log.info("下面点击收起按钮");
                opensweeping.click("查看全部");
                Thread.sleep(3000);
                log.info("下面点击查看全部。");
                opensweeping.click("查看全部");
                Thread.sleep(3000);
                AndroidElement element4 = opensweeping.findelement("查看全部",1);
                opensweeping.Assert(element4.getText(),"收起","点击查看全部按钮没有成功");
                Thread.sleep(3000);
                int i = 1;
                AndroidElement element2 = opensweeping.findelementbyclass(classname, classtext, i);
                while (element2 == null && i <= 4) {
                    opensweeping.slide(510, 1267, 510, 922);//这一步是要查找的元素不在本页面的时候进行滑动操作，每次上滑一行
                    Thread.sleep(3000);
                    element2 = opensweeping.findelementbyclass(classname, classtext, i);
                    i++;
                }
                log.info("下面点击：" + classtext);
                element2.click();
        }else{
                log.error("没有定位到全部查看元素的按钮");
            }

            Thread.sleep(3000);
            if(j!=0) {
                log.info("下面处理设备控制页面的新手指引。");
                HandleGuide guide = new HandleGuide();
                guide.HandleEquipmentGuide(j);
            }
           log.info("设备控制页面已经处理过新手指导页面，不再处理。");
            Thread.sleep(3000);
            log.info("下面校验顶部名称。");
            if(classname.contains("扫地")){
                AndroidElement element = opensweeping.findelement("扫地机器人顶部标题",1);
                opensweeping.Assert(element.getText(), content, "打开" + content + "失败啦");
            }else if(classname.contains("燃气")){
                AndroidElement element = opensweeping.findelement("燃气热水器标题",1);
                opensweeping.Assert(element.getText(), content, "打开" + content + "失败啦");
            }else if(classname.contains("空调")){
                AndroidElement element = opensweeping.findelement("空调顶部标题",1);
                opensweeping.Assert(element.getText(), content, "打开" + content + "失败啦");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
            jt.takeScreenShot(driver, "设备控制打开失败");
            log.error("设备控制打开失败");
        } catch (InterruptedException e) {
            e.printStackTrace();
            jt.takeScreenShot(driver, "元素操作失败");
            log.error("元素操作失败");
        }
    }
}
