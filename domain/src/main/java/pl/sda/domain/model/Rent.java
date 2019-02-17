package pl.sda.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Operators")
@Setter
@Getter
public class Rent {
    @Id
    @GeneratedValue
    @Column(name = "RNT_Id")
    private int id;
    @Column(name = "RNT_UsrId")
    private int user_id;
    @Column(name = "RNT_BoiId")
    private int bookItem_id;
    @Column(name = "RNT_Date")
    private LocalDate rentDate;
}
