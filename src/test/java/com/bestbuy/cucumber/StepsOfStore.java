package com.bestbuy.cucumber;

import com.bestbuy.bestbuyinfo.StoreSteps;
import com.bestbuy.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class StepsOfStore {
    static String name = "VP"+ TestUtils.getRandomValue();
    static String type = "SmallBox";
    static String address = "123 Om";
    static String address2 = "";
    static String city = "Del";
    static String state = "Guj";
    static String zip = "55305";
    static int lat = 123;
    static int lng = 56;
    static String hours = "2";
    static int storeId;

    ValidatableResponse response;
    @Steps
    StoreSteps storeSteps;

    @When("^As a User I create a store$")
    public void asAUserICreateAStore() {
        response=storeSteps.addStore(name,type,address,address2,city,state,zip,lat,lng,hours);
        storeId=(int) response.extract().path("id");
    }

    @Then("^User must get a valid response 201$")
    public void userMustGetAValidResponse() {
        response.statusCode(201);
    }

    @When("^I get store with storeId$")
    public void iGetStoreWithStoreId() {
        response=storeSteps.getStoreById(storeId);
    }

    @And("^I must get back a valid response$")
    public void iMustGetBackAValidResponse() {
        response.statusCode(200);
    }

    @When("^I update store with storeId$")
    public void iUpdateStoreWithStoreId() {
        type="bigBox";
        response=storeSteps.updateStoreByName(storeId,name,type,address,address2,city,state,zip,lat,lng,hours);
    }

    @Then("^I must get back again valid response$")
    public void iMustGetBackAgainValidResponse() {
        response.statusCode(200);
    }

    @When("^I delete store with storeId$")
    public void iDeleteStoreWithStoreId() {
        response=storeSteps.deleteStore(storeId).statusCode(200);
    }

    @And("^I check store is deleted$")
    public void iCheckStoreIsDeleted() {
        response=storeSteps.getStoreById(storeId).statusCode(404);
    }
}
