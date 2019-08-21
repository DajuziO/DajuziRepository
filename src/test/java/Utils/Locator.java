package Utils;

/**
 * 元素定位信息基本类
 */

public class Locator {
	
	
	private String name;   //元素名称  
	private int timeout; //元素定位超时时间
	private String element;    //元素定位信息
	public String getName() {
		return name;
	}
	public String getElement() {
		return element;
	}
	public int getTimeout() {
		return timeout;
	}



	public Locator(String name,int timeout,String element){
		this.name = "元素:"+name;
		this.element = element;
		this.timeout = timeout;
	}



}
