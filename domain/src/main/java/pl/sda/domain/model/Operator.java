package pl.sda.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Operators")
@Setter
@Getter
public class Operator {
    @Id
    @GeneratedValue
    @Column(name = "OPR_Id")
    private int id;
    @Column(name = "OPR_PerId")
    private int person_id;

}
