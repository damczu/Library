package pl.sda.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Persons")
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "PER_Id")
    private int id;
    @Column(name = "PER_FirstName")
    private String firstName;
    @Column(name = "PER_LastName")
    private String lastName;
//    @Column(name = "PER_AddressId")
//    private int addressId;
    @Column(name = "PER_Phone")
    private String phone;
    @Column(name = "PER_Email")
    private String email;

}
