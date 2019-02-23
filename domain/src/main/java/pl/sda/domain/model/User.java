package pl.sda.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USR_Id")
    private int id;
    @Column(name = "USR_PerId")
    private int personId;
    @Column(name = "USR_Login")
    private String login;
    @Column(name = "USR_Password")
    private char[] password;
    @Column(name = "USR_CreateDate")
    private LocalDateTime createDate;
}
