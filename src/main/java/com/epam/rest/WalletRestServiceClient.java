package com.epam.rest;

import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class WalletRestServiceClient {

  private static final String endpoint = "http://localhost:8080/BogdanSprysaWalletService/walletREST";
  private static Logger LOG = LogManager.getLogger(WalletRestServiceClient.class);
  private String url;

  @Step("Step rest service for get available amount")
  public Response getAvailableAmount() {
    url = String.format(endpoint + "/amount");
    return performClientRequest(url);
  }

  @Step("Step rest service for make withdraw")
  public Response makeWithdraw(String withdrawAmount) {
    url = String.format(endpoint + "/withdraw/" + withdrawAmount);
    return performClientRequest(url);
  }

  @Step("Step rest service for make income")
  public Response makeIncome(String incomeAmount) {
    url = String.format(endpoint + "/income/" + incomeAmount);
    return performClientRequest(url);
  }

  @Step("Step rest service for return to default state of wallet")
  public Response makeReturn() {
    url = String.format(endpoint + "/return");
    return performClientRequest(url);
  }

  @Step("Step for perform request rest service with url")
  public Response performClientRequest(String url) {
    Response result = given()
        .when()
        .get(url);
    int stCode = result.statusCode();
    if (stCode != 200) {
      Assert.assertTrue(false, "Status code of HTTP response is " + stCode + " instead of 200");
    }
    return result;
  }

  public String performResponseAsString(Response response) {
    ResponseBody body = response.getBody();
    return body.asString();
  }

}

