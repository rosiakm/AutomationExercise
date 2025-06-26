package api;

import api.builders.PetBuilder;
import api.builders.RequestBuilder;
import api.models.Pet;
import api.models.PetStatus;
import api.utils.Parameters;
import api.utils.requests.BasePetRequests;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.helpers.ConfigLoader;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PetStatusTest extends BaseTest{
    Logger logger = LoggerFactory.getLogger(PetStatusTest.class);

    private BasePetRequests basePetRequests = new BasePetRequests();
    Parameters parameters = RequestBuilder.setParameters(ConfigLoader.get("basePetApiPath"));

    private static int id;
    private static Optional<Pet> pet;
    private static Pet petResponse;

    @Test
    @Tag("Pet")
    @Tag("api")
    public void verifyPetStatusTest(){
        Pet[] pets = (basePetRequests.sendGETbyStatusRequest(parameters,PetStatus.PENDING).
        then()
                .statusCode(200)
                .extract().as(Pet[].class));
        pet = Arrays.stream(pets)
                        .filter(myPet -> myPet.getId() == 111)
                        .findFirst();
        id = (int) pet.get().getId();

        parameters.setPARAM(id);
        logger.info("<<<Pet ID is set as: ".concat(String.valueOf(id)).concat(">>>"));
        petResponse = basePetRequests.sendGETPetById(parameters).
        then()
                .statusCode(200)
                .extract().as(new TypeRef<Pet>() {
                });
        assertThat(petResponse.getStatus()).isEqualTo(PetStatus.PENDING.toString().toLowerCase());

        pet = Optional.ofNullable(PetBuilder.buildPet(pet, PetStatus.AVAILABLE));
        logger.info("<<<Pet object is updated>>>");
        petResponse = basePetRequests.sendPUTUpdatePetRequest(parameters,pet).
        then()
                .statusCode(200)
                .extract().as(new TypeRef<Pet>() {
                });
        assertThat(petResponse.getStatus()).isEqualTo(PetStatus.AVAILABLE.toString().toLowerCase());
    }
}
