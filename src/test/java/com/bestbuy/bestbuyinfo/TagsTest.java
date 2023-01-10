package com.bestbuy.bestbuyinfo;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.bestbuy.testbase.TestBase;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {
    @WithTags({
            @WithTag("studentfeature:SMOKE"),
            @WithTag("studentfeature:NEGATIVE")
    })
    @Title("Provide a 405 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod(){
        SerenityRest.given()
                .when()
                .put("/products")
                .then()
                .statusCode(404);
    }
    @WithTags({
            @WithTag("storefeature:SMOKE"),
            @WithTag("storefeature:NEGATIVE")
    })
    @Title("Provide a 405 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod1(){
        SerenityRest.given()
                .when()
                .put("/stores")
                .then()
                .statusCode(404);
    }
    @WithTag("storefeature:POSITIVE")
    @Title("This test will verify if a status code of 200 is returned for GET request")
    @Test
    public void validhttpmethod(){
        SerenityRest.given()
                .when()
                .get("/stores")
                .then()
                .statusCode(200);
    }
    @WithTags({
            @WithTag("productfeature:NEGATIVE"),
            @WithTag("productfeature:SMOKE")
    })
    @Test
    public void incorrectResources(){
        SerenityRest.given()
                .when()
                .get("/products0098")
                .then()
                .statusCode(405);
    }
}