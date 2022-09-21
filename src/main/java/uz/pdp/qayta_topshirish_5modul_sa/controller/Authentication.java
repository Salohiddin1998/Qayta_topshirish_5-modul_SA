package uz.pdp.qayta_topshirish_5modul_sa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.qayta_topshirish_5modul_sa.entity.Result;
import uz.pdp.qayta_topshirish_5modul_sa.payload.LoginDto;
import uz.pdp.qayta_topshirish_5modul_sa.payload.UserDto;
import uz.pdp.qayta_topshirish_5modul_sa.service.UserService;

@RestController
@RequestMapping("/authentication")
public class Authentication {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }



}
