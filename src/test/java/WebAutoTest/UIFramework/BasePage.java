package WebAutoTest.UIFramework;

import Utils.Log;
import Utils.XmlUtils;
import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * 页面的基本类，其它页面类都要继承该类，实现了类的公共方法
 * @author Lqj
 * 
 * 
 */
public class BasePage {

	protected  WebDriver driver =  null;
	public  BasePage(WebDriver dr){
		driver = dr;
	}

	protected Log log = new Log(this.getClass());//打印日志


	/*定位元素的方法*/
	public  WebElement getElement(WebDriver driver, WebLocator loc){
		WebElement el = null;
		switch(loc.getByType()){
		case xpath:
			el = driver.findElement(By.xpath(loc.getElement()));
			break;
		case id:
			el = driver.findElement(By.id(loc.getElement()));
			break;
		case linkText:
			el = driver.findElement(By.linkText(loc.getElement()));
			break;
		case name:
			el = driver.findElement(By.name(loc.getElement()));
			break;
		case className:
			el = driver.findElement(By.className(loc.getElement()));
			break;
		case cssSelector:
			el = driver.findElement(By.cssSelector(loc.getElement()));
			break;
		case partialLinkText:
			el = driver.findElement(By.partialLinkText(loc.getElement()));
			break;
		case tagName:
			el = driver.findElement(By.tagName(loc.getElement()));
			break;
		}
		System.out.println("网页识别 "+loc.getName()+" 成功");
		log.info("网页识别 "+loc.getName()+" 成功");
		return el;
	}
	
	
	/*查找元素的方法*/
	public WebElement findelement(final WebLocator loc){
		WebDriverWait wait = new WebDriverWait(driver, loc.getTimeout());//设置延时等待
		WebElement el = wait.until(new ExpectedCondition<WebElement>() {   
            public WebElement apply(WebDriver d) {
                return getElement(d,loc);  
            }  
        });
		return el;
	}
	/*输入方法*/
	public void type(WebLocator loc, String content){
		WebElement el = findelement(loc);//调用查找元素的方法
		el.sendKeys(content);
		log.info(loc.getName()+" 输入："+content);
		System.out.println(loc.getName()+" 输入："+content);
	}
	/*点击方法*/
	public void click(WebLocator loc){
		WebElement el = findelement(loc);
		el.click();
		log.info("点击："+loc.getName());
		System.out.println("点击："+loc.getName());
	}
	/*获取元素，通过读取xml文件获取元素*/
	public WebLocator getLocator(String element) {
		WebLocator xmllocator = null;
		try {
           // 文定义文件路径
			String path = System.getProperty("user.dir")+"\\WebElementsData\\"+this.getClass().getSimpleName()+".xml";
			log.info(path);  //日志打印 输入文件路径
			path = path.replace("\\target","");
			log.info(path);
			xmllocator = XmlUtils.read_elements(path).get(element);  //调用解析xml文件的方法
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return xmllocator;
	}
	
	
	/*
	 * 
	 * 鼠标事件
	 */
	
	

	public BasePage initbasepage(){
		return new BasePage(this.driver);
	}


	/*鼠标右击事件*/
	public void rightClick(WebLocator loc){
		new Actions(this.driver).contextClick(initbasepage().findelement(loc)).perform();
		System.out.println("右击"+loc.getName()+"成功");
	}
	
	
	public void ctrl_a(){
		new Actions(this.driver).keyDown(Keys.CONTROL).sendKeys("a").perform();
	}
	/*
	 * 原生弹出框的处理
	 */
//	public void Enter(WebDriver driver){
//	driver.findElement(By.id("alert")).click();
//	driver.switchTo().alert().accept();
//	}
//	
//	public void Esc(WebDriver drive){
//	driver.findElement(By.id("confirm")).click();
//	driver.switchTo().alert().dismiss();
//	}
	
    /**
     * 处理弹出框：点击确定
     * @author TJ
     * @param driver
     */
    public  void alertConfirm(WebDriver driver) {
	
	try {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		log.info("点击js弹出框确定");
	} catch (Exception notFindAlert) {
	    	log.error("没有js弹出框");
	}
    }
    
    /**
     * 处理弹出框：点击取消
     * @author TJ
     * @param driver
     */
    public  void alertDismiss(WebDriver driver) {
	Alert alert = driver.switchTo().alert();
	try {
		alert.dismiss();
		log.info("点击js弹出框取消");
	} catch (Exception notFindAlert) {
	    	log.error("没有js弹出框");
	}
    }
    
    /**
     * 得到相应弹出框里的提示信息
     * @author TJ
     * @param driver
     * @return
     */
    public String getAlertText(WebDriver driver) {
	Alert alert = driver.switchTo().alert();
	String value = null;
	try {
		value =  alert.getText();
		log.info("得到js弹出框值: "+value);
	} catch (Exception notFindAlert) {
	    	log.error("js弹出框没有值");	
	}
	return value;
    }
    
    /**
     * 弹出框输入相应value
     * @author TJ
     * @param driver
     * @param value
     */
    public  void inputAlertText(WebDriver driver, String value){
	Alert alert = driver.switchTo().alert();
	try {
	    alert.sendKeys(value);
	    log.info("js弹出框输入值: "+value);
	} catch (Exception notFindAlert) {
	    log.error("没有js弹出框");
	}
    }

	
	
	
	/*浏览器操作*/
	
	public  WebDriver getDriver(){
		return driver;
	}
	//打开页面
    public  void openWeb(String url) {
    	driver.get(url);
        System.out.println("打开【"+url+"】页面");
    }
    //关闭页面
    public  void closeWeb() {
    	driver.close();
    	System.out.println("关闭页面");
    }
    //关闭浏览器
    public void quit(){
    	driver.quit();
    	System.out.println("关闭浏览器");
    }
    //获取当前URL
    public String getCurrentUrl() {
        String CurrentUrl = driver.getCurrentUrl();
        System.out.println("获取当前页面：" + CurrentUrl);
        return CurrentUrl;
    }
    //获取当前Title
    public String getCurrentTitle(){
    	String CurrentTitle = driver.getTitle();
    	System.out.println("获取当前网页标题：" + CurrentTitle);
    	return CurrentTitle;
    }
    //刷新浏览器
    public void refresh() {
    	driver.navigate().refresh();
        System.out.println("刷新页面");
    }
    //浏览器回退
    public void back(){
    	driver.navigate().refresh();
    	System.out.println("浏览器后退");
    }
    //浏览器向前
    public void forword(){
    	driver.navigate().forward();
    	System.out.println("浏览器前进");
    }
    //浏览器最大化
    public void max(){
    	driver.manage().window().maximize();
    	System.out.println("浏览器最大化");
    }
    //暂停操作
	public void pause(int seconds){
		try {
			Thread.sleep(seconds*1000);
			System.out.println("暂停操作"+seconds+"秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}



