package org.sdet40.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	private ExtentReports reports;
	public static ExtentTest stest;
	private ExtentTest test;
	
	@Override //@BT
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document Tile - SDET 40");
		spark.config().setReportName("Report Name - SDET 40");
		spark.config().setTheme(Theme.STANDARD);
		
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Roopesh");
		reports.setSystemInfo("OS", "Win 11");
		reports.setSystemInfo("Browser", "Chrome");
	}
	
	@Override //@BM
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		stest = test;
	}

	@Override //@AM
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+" pass");

	}

	@Override //@AM
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+" fail");
//		System.out.println(Thread.currentThread().getId());
//		try {
//			new WebDriverUtility().screenShot(BaseClass.sdriver, BaseClass.sjavaUtility, result.getMethod().getMethodName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		test.fail(result.getThrowable());
		String path = new WebDriverUtility().screenShot(BaseClass.sdriver);
		test.addScreenCaptureFromBase64String(path);
		System.out.println(test.addScreenCaptureFromBase64String(path));
	}

	@Override //@AM
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+" skip");
		test.fail(result.getThrowable());
//		test.skip("Test1 skip");
	}

	@Override //@AM
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override //@AT
	public void onFinish(ITestContext context) {
		reports.flush();
	}
}
