package WebAutoTest.UIFramework;

/**
 * 元素定位信息基本类
 * @author 
 * @Time 2017-01-13 09:21
 */

public class WebLocator {
	//枚举类型，元素定位方法使用
	public enum ByType {
		xpath,id,linkText,name,className,cssSelector,partialLinkText,tagName
	}
	private String name;   //元素名称  
	private String element; //元素定位信息
	private int timeout;    //元素定位超时时间
	private ByType byType;  //元素定位方法
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String value) {
		this.element = value;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public ByType getByType() {
		return byType;
	}
	public void setByType(ByType type) {
		this.byType = type;
	}
	
	public WebLocator(String element){
		this.name = "元素:"+element;
		this.element = element;
		this.timeout = 3;
		this.byType = ByType.xpath;
	}
	
	public WebLocator(String element, int waitSec){
		this.name = "元素:"+element;
		this.element = element;
		this.timeout = waitSec;
		this.byType = ByType.xpath;
	}
	
	public WebLocator(String element, int waitSec, ByType byType){
		this.name = "元素:"+element;
		this.element = element;
		this.timeout = waitSec;
		this.byType = byType;
	}
	public WebLocator(String element, int waitSec, ByType byType, String name){
		this.name = name;
		this.element = element;
		this.timeout = waitSec;
		this.byType = byType;
	}

}
