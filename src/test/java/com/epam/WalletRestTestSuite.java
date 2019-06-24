package com.epam;

import com.epam.rest.WalletRestServiceClient;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class WalletRestTestSuite {

  private static Logger LOG = LogManager.getLogger(WalletRestTestSuite.class);
  private static WalletRestServiceClient clientRest = new WalletRestServiceClient();
  private String expectedAvailableAmount;
  private String actualAvailableAmount;
  private Response response;

  @Test
  public void getAvailableAmountTest() {
    LOG.info("Get available amount test");
    expectedAvailableAmount = "150.0";
    response = clientRest.getAvailableAmount();
    actualAvailableAmount = clientRest.performResponseAsString(response);
    Assert.assertEquals(actualAvailableAmount, expectedAvailableAmount,
        "Test failed, expected " + expectedAvailableAmount + " but actual "
            + actualAvailableAmount);
  }

  @Test
  public void makeWithdrawPositiveTest() {
    LOG.info("Make withdraw positive test");
    String withdrawAmount = "50.0";
    expectedAvailableAmount = "100.0";
    response = clientRest.makeWithdraw(withdrawAmount);
    boolean isWithdrawSuccess = Boolean.parseBoolean(clientRest.performResponseAsString(response));
    response = clientRest.getAvailableAmount();
    actualAvailableAmount = clientRest.performResponseAsString(response);
    Assert.assertTrue(isWithdrawSuccess,
        "Withdraw is not success, withdrawAmount = " + withdrawAmount + " availableAmount = "
            + actualAvailableAmount);
    LOG.info("Verify expected amount");
    Assert.assertEquals(actualAvailableAmount, expectedAvailableAmount,
        "Test failed, expected " + expectedAvailableAmount + " but actual "
            + actualAvailableAmount);
  }

  @Test
  public void makeIncomePositiveTest() {
    LOG.info("Make income positive test");
    expectedAvailableAmount = "200.0";
    response = clientRest.makeIncome("50.0");
    boolean isIncomeSuccess = Boolean.parseBoolean(clientRest.performResponseAsString(response));
    Assert.assertTrue(isIncomeSuccess, "Income is not success, amount after income > max limit");
    LOG.info("Verify expected amount");
    response = clientRest.getAvailableAmount();
    actualAvailableAmount = clientRest.performResponseAsString(response);
    Assert.assertEquals(actualAvailableAmount, expectedAvailableAmount,
        "Test failed, expected " + expectedAvailableAmount + " but actual "
            + actualAvailableAmount);
  }

  @Test
  public void makeWithdrawNegativeTest() {
    LOG.info("Make withdraw negative test (more than available amount)");
    response = clientRest.makeWithdraw("300.0");
    boolean isWithdrawSuccess = Boolean.parseBoolean(clientRest.performResponseAsString(response));
    Assert.assertFalse(isWithdrawSuccess, "Withdraw is success (expected not success)");
  }

  @Test
  public void makeIncomeNegativeTest() {
    LOG.info("Make income negative test (more than max limit)");
    Response response = clientRest.makeWithdraw("3000.0");
    boolean isIncomeSuccess = Boolean.parseBoolean(clientRest.performResponseAsString(response));
    Assert.assertFalse(isIncomeSuccess, "Income is success (expected not success)");
  }

  @AfterTest
  private void returnDefaultStateOfWallet() {
    LOG.info("Return to default state of wallet");
    clientRest.makeReturn();
  }
}
