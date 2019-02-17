package pl.sda.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BookRents")
@Setter
@Getter
public class BookRent {
    @Id
    @GeneratedValue
    @Column(name = "BRT_Id")
    private int id;
    @Column(name = "BRT_UsrId")
    private int user_id;
    @Column(name = "BRT_BoiId")
    private int bookItem_id;
    @Column(name = "BRT_RentDate")
    private LocalDate rentDate;
    @Column(name = "BRT_ReturnDate")
    private LocalDate returnDate;
    @Column(name = "BRT_Returned")
    private boolean returned;
}
