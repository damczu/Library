package pl.sda.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "BookItems")
@Getter
@Setter
public class BookItem {
    @Id
    @GeneratedValue
    @Column(name = "BOI_Id")
    private int id;
    @Column(name = "BOI_BokId")
    private int book_id;
    @Column(name = "BOI_BrtId")
    private int currentBookRentId;
}
