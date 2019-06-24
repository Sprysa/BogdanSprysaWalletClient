package com.epam;

import com.epam.soap.WalletServiceImpService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WalletSoapTestSuite {

  private static Logger LOG = LogManager.getLogger(WalletSoapTestSuite.class);
  private WalletServiceImpService walletServiceImpService = new WalletServiceImpService();
  private double expectedAvailableAmount;
  private double actualAvailableAmount;

  @Test
  public void getAvailableAmountTest() {
    LOG.info("Get available amount test");
    expectedAvailableAmount = 150.0;
    actualAvailableAmount = walletServiceImpService.getWalletServiceImpPort().getAvailableAmount();
    Assert.assertEquals(actualAvailableAmount, expectedAvailableAmount,
        "Test failed, expected " + expectedAvailableAmount + " but actual "
            + actualAvailableAmount);
  }

  @Test
  public void makeWithdrawPositiveTest() {
    LOG.info("Make withdraw positive test");
    double withdrawAmount = 50.0;
    expectedAvailableAmount = 100.0;
    boolean isWithdrawSuccess = walletServiceImpService.getWalletServiceImpPort().makeWithdraw(withdrawAmount);
    actualAvailableAmount = walletServiceImpService.getWalletServiceImpPort().getAvailableAmount();
    Assert.assertTrue(isWithdrawSuccess,
        "Withdraw is not success, withdrawAmount = " + withdrawAmount + " availableAmount = "
            + actualAvailableAmount);
    LOG.info("Verify expected amount");
    Assert.assertEquals(actualAvailableAmount, expectedAvailableAmount,
        "Test failed, expected " + expectedAvailableAmount + " but actual "
            + actualAvailableAmount);
    LOG.info("Return to previous state of wallet");
    walletServiceImpService.getWalletServiceImpPort().makeIncome(withdrawAmount);
  }

  @Test
  public void makeIncomePositiveTest() {
    LOG.info("Make income positive test");
    double incomeAmount = 50.0;
    expectedAvailableAmount = 200.0;
    boolean isIncomeSuccess = walletServiceImpService.getWalletServiceImpPort().makeIncome(incomeAmount);
    Assert.assertTrue(isIncomeSuccess, "Income is not success, amount after income > max limit");
    LOG.info("Verify expected amount");
    actualAvailableAmount = walletServiceImpService.getWalletServiceImpPort().getAvailableAmount();
    Assert.assertEquals(actualAvailableAmount, expectedAvailableAmount,
        "Test failed, expected " + expectedAvailableAmount + " but actual "
            + actualAvailableAmount);
    LOG.info("Return to previous state of wallet");
    walletServiceImpService.getWalletServiceImpPort().makeWithdraw(incomeAmount);
  }

  @Test
  public void makeWithdrawNegativeTest() {
    LOG.info("Make withdraw negative test (more than available amount)");
    double withdrawAmount = 300.0;
    boolean isWithdrawSuccess = walletServiceImpService.getWalletServiceImpPort().makeWithdraw(withdrawAmount);
    Assert.assertFalse(isWithdrawSuccess, "Withdraw is success (expected not success)");
  }

  @Test
  public void makeIncomeNegativeTest() {
    LOG.info("Make income negative test (more than max limit)");
    double incomeAmount = 3000.0;
    boolean isIncomeSuccess = walletServiceImpService.getWalletServiceImpPort().makeIncome(incomeAmount);
    Assert.assertFalse(isIncomeSuccess, "Income is success (expected not success)");
  }

}
