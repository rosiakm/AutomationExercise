package api;

import ui.helpers.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setup(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public static RequestSpecification getAllProductsList(){
        return (new RequestSpecBuilder()
                .setBaseUri(ConfigLoader.get("baseUrl").concat("api")))
                .setContentType("application/json")
                .build();
    }

    public static ResponseSpecification getResponse(){
        return (new ResponseSpecBuilder()
                .expectStatusCode(200))
                .build();
    }
}
