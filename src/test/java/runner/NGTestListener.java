package runner;

import org.testng.*;

public class NGTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On test start...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On test success...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("On test failure...");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("On test skipped...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("On test performance...");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("On test start...");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On test finish...");
    }
}
