package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) { //throws Exception {
        int petTypeCount = petTypeService.findAll().size();
        if(petTypeCount == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        dog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        cat = petTypeService.save(cat);

        System.out.println("Pet Types are loaded");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        radiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        surgery = specialityService.save(surgery);

        System.out.println("Specialities are loaded");

        Owner owner1 = new Owner();
//        owner1.setId(1L);
        owner1.setFirstName("Tony");
        owner1.setLastName("Stark");
        owner1.setAddress("Avengers Avenue");
        owner1.setCity("New York");
        owner1.setTelephone("3000300043");

        Pet starksPet = new Pet();
        starksPet.setPetType(dog);
        starksPet.setName("Roxy");
        starksPet.setBirthDate(LocalDate.of(2018, 2, 14));
        starksPet.setOwner(owner1);

        owner1.getPets().add(starksPet);

        ownerService.save(owner1);

        Visit visit1 = new Visit();
        visit1.setPet(starksPet);
        visit1.setDescription("Sneezy Kitty");
        visit1.setDate(LocalDate.of(2021, 2, 14));
        visitService.save(visit1);

        Owner owner2 = new Owner();
//        owner2.setId(2L);
        owner2.setFirstName("Black");
        owner2.setLastName("Widow");
        owner2.setAddress("Widow School");
        owner2.setCity("Budapest");
        owner2.setTelephone("0987654321");

        Pet widowsPet = new Pet();
        widowsPet.setPetType(cat);
        widowsPet.setName("Cooper");
        widowsPet.setBirthDate(LocalDate.of(2020, 8, 29));
        widowsPet.setOwner(owner1);

        owner2.getPets().add(widowsPet);

        ownerService.save(owner2);

        System.out.println("Owners are loaded");

        Vet vet1 = new Vet();
//        vet1.setId(1L);
        vet1.setFirstName("Peter");
        vet1.setLastName("Parker");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Star");
        vet2.setLastName("Lord");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        System.out.println("Vets are loaded");
    }
}
