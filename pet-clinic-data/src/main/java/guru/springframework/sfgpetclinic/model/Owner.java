package guru.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "owners")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
//@SuperBuilder
public class Owner extends Person {

    @Builder
    Owner(String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets, Long id) {
        super(id, firstName, lastName);
        System.out.println(">>>>>>>>>>>>  Id: " + id + "  <<<<<<<<<<<<<");
        this.address = address;
        this.city = city;
        this.telephone = telephone;
//        this.pets = pets;
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

}
