package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
//import java.util.concurrent.atomic.AtomicReference;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @SuppressWarnings({"RedundantSuppression", "CommentedOutCode"})
    @Override
    public Owner findById(Long owner_id) {
//        AtomicReference<Owner> ownerById = null;
//        ownerRepository.findById(owner_id).ifPresent(owner -> {
//            ownerById.set(owner);
//        });
//        return ownerById.get();

//        noinspection OptionalGetWithoutIsPresent
//        return ownerRepository.existsById(owner_id) ? ownerRepository.findById(owner_id).get() : null;

//        return ownerRepository.findById(owner_id).isPresent() ? ownerRepository.findById(owner_id).get() : null;

        return ownerRepository.findById(owner_id).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long owner_id) {
        ownerRepository.deleteById(owner_id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
