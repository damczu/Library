package pl.sda.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Authors")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "AUT_Id")
    private int id;
    @Column(name = "AUT_FirstName")
    private String firstName;
    @Column(name = "AUT_LastName")
    private String lastName;
}
