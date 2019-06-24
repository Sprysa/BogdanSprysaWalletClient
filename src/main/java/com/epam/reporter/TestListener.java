package com.epam.reporter;

import com.google.gson.JsonObject;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import static java.lang.String.format;

@Listeners
public class TestListener implements ITestListener {

    public static final Logger LOG = LogManager.getLogger();
    private JsonObject jsonObject;

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTexLog(String msg) {
        return msg;
    }


    @Override
    public void onTestStart(ITestResult result) {
        jsonObject = new JsonObject();
        LOG.info("START" + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info(format("[result : SUCCESS]", result.getMethod().getMethodName()));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.error(format("[result : FAILURE]", result.getMethod().getMethodName()));
        saveTexLog(result.getMethod().getMethodName() + "failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.info(format("END %s [result : SKIPPED]", result.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LOG.info(format("END %s [result : RERCENTAGE OF TEST SUCCESS]", result.getMethod().getMethodName()));

    }

    @Override
    public void onStart(ITestContext context) {
        LOG.info("TEST START");
    }

    @Override
    public void onFinish(ITestContext context) {
        LOG.info("TEST FINISH");
    }
}
