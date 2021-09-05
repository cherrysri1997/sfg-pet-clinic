package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;

public interface PetService extends CrudService<Pet, Long> {
//    These methods are commented or removed because they are already declared in a base interface called CrudService
//
//    Pet findById(Long id);
//
//    Pet save(Pet pet);
//
//    Set<Pet> findAll();
}
