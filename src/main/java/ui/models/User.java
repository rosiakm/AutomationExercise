package ui.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String firstName;
    private String lastName;
    private String name;
    private String email;
    private String password;
    private String mobileNumber;

    public User(String firstName, String lastName, String name, String email, String password, String mobileNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }
}
