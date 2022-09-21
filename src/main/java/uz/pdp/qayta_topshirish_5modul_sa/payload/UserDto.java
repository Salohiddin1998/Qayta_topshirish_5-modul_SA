package uz.pdp.qayta_topshirish_5modul_sa.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private String userName;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String password;

    private String prePassword;

    private Integer rol;







}
