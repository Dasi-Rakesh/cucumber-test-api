package com.searchAPI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Map;

public class ITunesSearchAPIStepDefinitions {

    private Response response;

    @Given("the base URL is {string}")
    public void setBaseURL(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    @When("a GET request is sent to {string} with parameters:")
    public void sendGetRequest(String endpoint, Map<String, String> params) {
        response = given()
                .queryParams(params)
                .when()
                .get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void verifyResponseContains(String expectedContent) {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains(expectedContent));
    }
}
