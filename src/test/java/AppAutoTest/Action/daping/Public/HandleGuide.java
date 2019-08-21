package AppAutoTest.Action.daping.Public;

import AppAutoTest.start.Appaction;
import Utils.Log;
import Utils.PrtScr;
import org.dom4j.DocumentException;


/**
 * 处理每次启动时候的新手指引页面
 */
public class HandleGuide {

    Log log = new Log(this.getClass());
    PrtScr jt = new PrtScr();
    public void HandleHoempageGuide() throws DocumentException, InterruptedException {
        Appaction guide = new Appaction("设备控制");
        log.info("滑动五次，跳过新手指引页面");
        for(int i= 1; i <5;i++){
            log.info("第"+ i +"滑动新手指引页");
            guide.slide(902,1221,393,1230);
            Thread.sleep(1000);
        }
        log.info("点击退出引导");
        guide.click(965,1839);
        log.info("新手指引退出成功。");
    }

    public void HandleEquipmentGuide(int j) throws DocumentException, InterruptedException {
        Appaction guide = new Appaction("设备控制");
        log.info("滑动五次，跳过新手指引页面");
        for(int i= 1; i <=j;i++){
            log.info("第"+ i +"滑动新手指引页");
            guide.click(1037, 753);
            Thread.sleep(1000);
        }
        log.info("点击退出引导");
        guide.click(965,750);
        log.info("设备页面新手指引退出成功。");
    }

}
