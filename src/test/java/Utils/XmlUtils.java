
package Utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import WebAutoTest.UIFramework.WebLocator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * xml操作类
 * @author
 * @Time 2017-01-13
 */
public class XmlUtils {
	/**
	 * 读取XML文件中的元素作为一个Locator的map
	 * @param path
	 * @return HashMap<String,WebLocator>
	 * @throws DocumentException
	 */
	public static HashMap<String, WebLocator> read_elements(String path) throws DocumentException{
		HashMap<String,WebLocator> elementsmap = new HashMap<String,WebLocator>();
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(path));
		Element node = document.getRootElement();
		List<Element> childList = node.elements("element");
		for(Element i:childList){
			String name = i.attributeValue("name");//e.attribute("name").getData().toString()
			String element = i.attributeValue("value");
			int timeout = Integer.parseInt(i.attributeValue("timeout"));
			WebLocator.ByType bytype = getByType(i.attributeValue("type"));
			String key = i.getText();
			WebLocator webLocator = new WebLocator(element,timeout,bytype,name);
			elementsmap.put(key, webLocator);
		}
		return elementsmap;
	}
	
	public static HashMap<String,WebLocator> read_page_elements(String path,String pg) throws DocumentException{
		HashMap<String,WebLocator> elementsmap = new HashMap<String,WebLocator>();
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(path));
		Element node = document.getRootElement();
		List<Element> pages = node.elements("page");
		for(Element page:pages){
			if(page.attributeValue("name").equals(pg)){
				List<Element> childList = page.elements("element");
				for(Element i:childList){
					String name = i.attributeValue("name");
					String element = i.attributeValue("value");
					int timeout = Integer.parseInt(i.attributeValue("timeout"));
					WebLocator.ByType bytype = getByType(i.attributeValue("type"));
					String key = i.getText();
					WebLocator webLocator = new WebLocator(element,timeout,bytype,name);
					elementsmap.put(key, webLocator);
				}
				break;
			}
		}
		return elementsmap;
	}
	public static WebLocator.ByType getByType(String type){
		WebLocator.ByType byType = WebLocator.ByType.xpath;
		if (type == null || type.equalsIgnoreCase("xpath")){
			byType = WebLocator.ByType.xpath;
		}else if (type.equalsIgnoreCase("id")){
			byType = WebLocator.ByType.id;
		}else if (type.equalsIgnoreCase("linkText")){
			byType = WebLocator.ByType.linkText;
		}else if (type.equalsIgnoreCase("name")){
			byType = WebLocator.ByType.name;
		}else if (type.equalsIgnoreCase("classname")){
			byType = WebLocator.ByType.className;
		}else if (type.equalsIgnoreCase("css")){
			byType = WebLocator.ByType.cssSelector;
		}else if (type.equalsIgnoreCase("partialLinkText")){
			byType = WebLocator.ByType.partialLinkText;
		}else if (type.equalsIgnoreCase("tagName")){
			byType = WebLocator.ByType.tagName;
		}
		return byType;
	}
}
