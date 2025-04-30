package API;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class AutomationPracticeShopApiTest extends BaseTest{

    @Test
    @Tag("API")
    @Tag("Products")
    public void shuldGetAllProductsList(){
        given()
                .spec(getAllProductsList()).
        when()
                .get("/productsList").
        then()
                .spec(getResponse());
    }
}
