package ui.providers;

import com.github.javafaker.Faker;
import ui.models.Address;

public class AddressBuilder {
    public static Address createAddress(){
        Faker faker = new Faker();
        return Address.builder()
                .address(faker.address().streetAddress())
                .state(faker.address().state())
                .city(faker.address().city())
                .zipcode(faker.address().zipCode())
                .build();
    }
}
