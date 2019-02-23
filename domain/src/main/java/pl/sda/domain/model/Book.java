package pl.sda.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Books")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

}
