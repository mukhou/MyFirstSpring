package cucumber.examples;/*
User: Urmi
Date: 2/13/2020 
Time: 6:14 PM
*/

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AddStepdefs {
    int a, b;
    int result;

    @Given("^I have two numbers (\\d+) and (\\d+)$")
    public void iHaveTwoNumbersAnd(int arg0, int arg1) throws Throwable {
        a = arg0;
        b = arg1;
    }


    @When("^I add numbers (\\d+) and (\\d+)$")
    public void iAddNumbersAnd(int arg0, int arg1) throws Throwable {
       result = a + b;
    }

    @Then("^I get the result as (\\d+)$")
    public void iGetTheResultAs(int arg0) throws Throwable {
        Assert.assertEquals(9, arg0);
    }
}
