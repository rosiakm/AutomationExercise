package ui.providers;

import com.github.javafaker.Faker;
import ui.models.User;

public class UserBuilder {
    public static User createUser(){
        Faker faker = new Faker();
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .name(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .address(AddressBuilder.createAddress())
                .mobileNumber(faker.phoneNumber().phoneNumber())
                .build();
    }
}
