package api.utils.requests;

import api.models.Pet;
import api.models.PetStatus;
import api.utils.Parameters;
import io.restassured.response.Response;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public class BasePetRequests {
    public Response sendGETbyStatusRequest(Parameters parameters, PetStatus petStatus){
        return given()
                .baseUri(parameters.getBASE_URI())
                .basePath(parameters.getBASE_PATH().concat("findByStatus"))
                .queryParam("status",petStatus.toString().toLowerCase())
                .contentType(parameters.getCONTENT_TYPE()).
        when()
                .get();
    }

    public Response sendGETPetById(Parameters parameters){
        return given()
                .baseUri(parameters.getBASE_URI())
                .basePath(parameters.getBASE_PATH().concat(String.valueOf(parameters.getPARAM())))
                .contentType(parameters.getCONTENT_TYPE()).
        when()
                .get();
    }

    public Response sendPUTUpdatePetRequest(Parameters parameters, Optional<Pet> pet){
        return given()
                .baseUri(parameters.getBASE_URI())
                .basePath(parameters.getBASE_PATH())
                .contentType(parameters.getCONTENT_TYPE())
                .body(pet).
        when()
                .put();
    }
}
