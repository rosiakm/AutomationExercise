package api.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;
}
