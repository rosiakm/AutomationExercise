package ui.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {
    private String address;
    private String state;
    private String city;
    private String zipcode;

    public Address(String address, String state, String city, String zipcode){
        this.address = address;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
    }
}
