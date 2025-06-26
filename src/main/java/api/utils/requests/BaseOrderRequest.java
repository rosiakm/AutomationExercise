package api.utils.requests;


import api.models.Order;
import api.utils.Parameters;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseOrderRequest {

    public Response sendPOSTOrderRequest(Parameters parameters, Order order){
        return given()
                .baseUri(parameters.getBASE_URI())
                .basePath(parameters.getBASE_PATH())
                .contentType(parameters.getCONTENT_TYPE())
                .body(order).
        when()
                .post();
    }

    public Response sendGETOrderRequestWithParam(Parameters parameters){
        return given()
                .baseUri(parameters.getBASE_URI())
                .basePath(parameters.getBASE_PATH().concat(String.valueOf(parameters.getPARAM())))
                .contentType(parameters.getCONTENT_TYPE()).
        when()
                .get();
    }
}
