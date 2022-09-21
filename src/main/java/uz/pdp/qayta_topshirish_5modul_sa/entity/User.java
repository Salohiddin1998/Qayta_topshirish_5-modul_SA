package uz.pdp.qayta_topshirish_5modul_sa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    // admin, user , va boshqa imkoniyatlarga ega bo'lganligi uchun
    //user = 0
    //admin = 1
    //superAdmin = 2;  admin tayinlash huquqiga ega
    private Integer rol;


}
