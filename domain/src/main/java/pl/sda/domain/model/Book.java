package pl.sda.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Books")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "BOK_Id")
    private int id;
    @Column(name = "BOK_Title")
    private String title;
    @Column(name = "BOK_IsbnNumber")
    private String isbnNumber;
    @Column(name = "BOK_ReleaseDate")
    private LocalDate releaseDate;
    @Column(name = "BOK_Summary")
    private String summary;
}
