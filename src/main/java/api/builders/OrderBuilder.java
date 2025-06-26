package api.builders;

import api.models.Order;
import com.github.javafaker.Faker;

import java.util.Random;

public class OrderBuilder {
    public static Faker faker = new Faker();

    public static Order createOrder(){
        Random random = new Random();
        return Order.builder()
                .id(random.nextInt(1,100))
                .petId(random.nextInt(1,100))
                .quantity(1)
                .shipDate("2025-06-12T09:11:31.441Z")
                .status("placed")
                .complete(true)
                .build();
    }
}
