package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 配置文件操作类
 * @author 
 * @Time 2017-01-12
 */
public class ConfigUtils {
	
	public static Properties getProperties(String config) throws IOException{
		Properties properties = new Properties();
		FileInputStream inStream = new FileInputStream(new File(config));
		try {
			properties.load(inStream);
		}catch(Exception e) {
			System.out.println("读取:"+config+"配置文件出错");
		}finally{
			inStream.close();
		}
		return properties;
	}
}
