package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class PrtScr {
	/**
	 * 截图类
	 */
 protected  Log log = new Log(this.getClass());
 public  void takeScreenShot(TakesScreenshot drivername, String name) {
	         String currentPath= System.getProperty("user.dir")+"\\截图\\";
	        
	         String path=name +"用例"+getCurrentDateTime()+".jpg";
	        File scrFile = drivername.getScreenshotAs(OutputType.FILE);  
	        File picFile = new File(currentPath + path);
	        try {
	            FileUtils.copyFile(scrFile, picFile);
	            log.info(name+"：失败截图成功");
	            log.info("失败截图保存的路径为:" + currentPath + path);
	       } catch (IOException e) {
	    	   log.error(name+"：截图失败");
	    	   e.printStackTrace();
	       }
	        log.screenShotLog("截图：" + scrFile, picFile);
	    }
	public static String getCurrentDateTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");// 设置日期格式
		return df.format(new Date());
	}
}