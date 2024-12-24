
package listeners;




import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {
    
	String testMethodName;
	
	public void onTestStart(ITestResult result) {
        	testMethodName = result.getMethod().getMethodName();   	
    }
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Is Success");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Is Failure");
	}
	
	public void onTestSkipped(ITestResult result) {
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onStart(ITestContext context) {
		
	}
	
	public void finish(ITestContext context) {
		
	}
	
}
