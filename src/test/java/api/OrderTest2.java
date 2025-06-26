package api;

import api.builders.OrderBuilder;
import api.builders.RequestBuilder;
import api.models.Order;
import api.models.OrderResponse;
import api.utils.Parameters;
import api.utils.requests.BaseOrderRequest;
import io.restassured.common.mapper.TypeRef;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.helpers.ConfigLoader;

public class OrderTest2 extends BaseTest{
    Logger logger = LoggerFactory.getLogger(OrderTest2.class);
    private static Order order;
    private static int id;
    private static OrderResponse response;
    private BaseOrderRequest baseRequest = new BaseOrderRequest();
    Parameters parameters = RequestBuilder.setParameters(ConfigLoader.get("baseOrderApiPath"));

    @Test
    @Tag("api")
    @Tag("order")
    public void orderRequestTest(){
        order = OrderBuilder.createOrder();
        logger.info("<<<New order is created>>>");
        id = baseRequest.sendPOSTOrderRequest(parameters,order).
        then()
                .statusCode(200)
                .spec(getResponse())
                .extract().path("id");

        parameters.setPARAM(id);
        logger.info("<<<ID, Endpoint is set>>>");
        response = baseRequest.sendGETOrderRequestWithParam(parameters).
        then()
                .statusCode(200)
                .spec(getResponse())
                .extract().as(new TypeRef<OrderResponse>() {
                });

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(response.getId()).isEqualTo(parameters.getPARAM());
        softly.assertThat(response.getPetId()).isEqualTo(order.getPetId());
        softly.assertThat(response.getQuantity()).isEqualTo(order.getQuantity());
        softly.assertThat(response.getShipDate()).isEqualTo(order.getShipDate());
        softly.assertThat(response.getStatus()).isEqualTo(order.getStatus());
        softly.assertThat(response.isComplete()).isEqualTo(order.isComplete());
        softly.assertAll();
    }
}
