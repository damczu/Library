package pl.sda.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "Persons")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "PER_Id")
    private int id;
    @Column(name = "PER_FirstName")
    private String firstName;


}
