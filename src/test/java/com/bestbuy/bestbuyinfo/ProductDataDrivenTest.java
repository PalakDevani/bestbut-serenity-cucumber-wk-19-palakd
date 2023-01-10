package com.bestbuy.bestbuyinfo;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.bestbuy.testbase.TestBase;

@Concurrent(threads = "8X")
@UseTestDataFrom("src/test/java/resources/testdata/productinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class ProductDataDrivenTest extends TestBase {
    /*{
 "name": "string",
 "type": "string",
 "price": 0,
 "shipping": 0,
 "upc": "string",
 "description": "string",
 "manufacturer": "string",
 "model": "string",
 "url": "string",
 "image": "string"
}
*/
    private String name;
    private String type;
    private int price;
    private int shIpping;
    private String upc;
    private String description;
    private String manufacturer;
    private String model;
    private String url;
    private String image;

    @Steps
    ProductSteps productSteps;

    @Title("Creating multiple products with Data driven")
    @Test
    public void createMultipleProduct() {
        productSteps.addProduct(name, type, price, shIpping, upc, description, manufacturer, model, url, image).statusCode(201);
    }


}