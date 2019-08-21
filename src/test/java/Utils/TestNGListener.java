package Utils;

import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class TestNGListener extends TestListenerAdapter {

    Log log = new Log(this.getClass());
   
    @Override
    public void onTestSuccess(ITestResult tr) {
	log.info("【" + tr.getName() + "成功】");
        super.onTestSuccess(tr);
        
    }

    @Override
    public void onTestFailure(ITestResult tr) {
	log.info("【" + tr.getName() + "失败】");
        super.onTestFailure(tr);
        takeScreenShot(tr);
       
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
	log.info("【" + tr.getName() + "跳过】");
        super.onTestSkipped(tr);
        takeScreenShot(tr);
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("测试开始");
        super.onTestStart(result);
    }

    @Override
    public void onStart(ITestContext testContext) {
        log.info("监听开始");
        super.onStart(testContext);
    }
    
    private void takeScreenShot(ITestResult tr) {
        PrtScr b = (PrtScr) tr.getInstance();
        b.takeScreenShot(null, null);

    }

    /**
     * 更改失败的用例在报告里生成了多份
     */
    @Override
    public void onFinish(ITestContext testContext) {
      //  log.info("Test Finish");
        Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
        while (listOfFailedTests.hasNext()) {
            ITestResult failedTest = listOfFailedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if (testContext.getFailedTests().getResults(method).size() > 1) {
                listOfFailedTests.remove();
            } else {
                if (testContext.getPassedTests().getResults(method).size() > 0) {
                    listOfFailedTests.remove();
                }
            }
        }

    }

}
