package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class OverrideIReTry implements IRetryAnalyzer{
    
    Log logger = new Log(this.getClass());
    private  int initReTryNum=1;//初始次数
    private  int maxReTryNum=2;//失败重跑次数
    public boolean retry(ITestResult iTestResult) {
        if(initReTryNum<=maxReTryNum){
            String message="方法<"+iTestResult.getName()+">执行失败，重试第"+initReTryNum+"次";
            logger.error(message);
            Reporter.setCurrentTestResult(iTestResult);
            Reporter.log(message);
            initReTryNum++;
            return true;
        }
        return false;
    }
}
