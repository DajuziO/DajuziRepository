package Utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 控制台命令输入,调用CMD窗口执行adb命令，传参要执行的命令，String类型
 */
public class console {
	protected Log log = new Log(this.getClass());
	String line2=null;
	public String cmd(String str) {
		try {
			Runtime rt = Runtime.getRuntime();
			Process pr = rt.exec("cmd /c "+str); 
			BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream(), "utf-8"));//如果打印的日志中文乱码，请将utf-8该为：GBK
			String line=null;
			log.info("~~~~~~~~~~~~~~~~~~~~~~~下面打印logcat日志信息:300行~~~~~~~~~~~~~~~~~~~~~~~");
			while ((line = input.readLine()) != null) {	
				line2=line;
				log.info(line2);
			}
			log.info("~~~~~~~~~~~~~~~~~~~~~~~300行logcat已打印完毕~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(str+"执行成功"); 
		} catch (Exception e) {
			System.out.println(str+"执行失败");
			e.printStackTrace();
		}
		return line2;
	}
	public static void main(String[] args) {
		console d=new console();
		d.cmd("taskkill /F /IM node.exe");
	}
}

