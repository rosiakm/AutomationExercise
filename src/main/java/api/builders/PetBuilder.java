package api.builders;

import api.models.Pet;
import api.models.PetStatus;

import java.util.Optional;

public class PetBuilder {
    public static Pet buildPet(Optional<Pet> pet, PetStatus status){
        return Pet.builder()
                .id(pet.get().getId())
                .category(pet.get().getCategory())
                .name(pet.get().getName())
                .photoUrls(pet.get().getPhotoUrls())
                .tags(pet.get().getTags())
                .status((status.toString().toLowerCase()))
                .build();
    }
}
