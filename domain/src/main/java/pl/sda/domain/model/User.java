package pl.sda.domain.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USR_Id")
    private int id;
    @Column(name = "USR_Login")
    private String login;
    @Column(name = "USR_Password")
    private char[] password;
    @Column(name = "USR_CreateDate")
    private LocalDateTime createDate;
}
