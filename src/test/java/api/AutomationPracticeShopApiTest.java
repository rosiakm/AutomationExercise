package api;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AutomationPracticeShopApiTest extends BaseTest{

    @Test
    @Tag("api")
    @Tag("Products")
    public void getAllProductsListTest(){
        given()
                .spec(getAllProductsList()).
        when()
                .get("/productsList").
        then()
                .spec(getResponse());
    }
}
