package uz.pdp.qayta_topshirish_5modul_sa.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginDto {

    private String userName;

    private String password;

}
