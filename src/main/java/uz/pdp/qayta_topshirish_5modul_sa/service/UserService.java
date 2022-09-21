package uz.pdp.qayta_topshirish_5modul_sa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.qayta_topshirish_5modul_sa.entity.Result;
import uz.pdp.qayta_topshirish_5modul_sa.entity.User;
import uz.pdp.qayta_topshirish_5modul_sa.payload.LoginDto;
import uz.pdp.qayta_topshirish_5modul_sa.payload.UserDto;
import uz.pdp.qayta_topshirish_5modul_sa.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public List<User> all() {
        return userRepository.findAll();
    }

    public User getId(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(User::new);
    }

    public Result delete(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            userRepository.deleteById(id);
            return new Result("User deleted", true);
        }
        return new Result("User not found", false);
    }

    public Result add(UserDto userDto) {
        User user = new User();

        boolean existsByUserName = userRepository.existsByUserName(user.getUserName());
        if (existsByUserName){
            return new Result("User Name already exist", false);
        }

        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());
        if (existsByPhoneNumber){
            return new Result("User Phone Number already exist", false);
        }
        if (!userDto.getPassword().equals(userDto.getPrePassword())){
            return new Result("Password is not equals prePassword", false);
        }
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(user.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        user.setRol(userDto.getRol());
        userRepository.save(user);
        return new Result("User added", true);
    }

    public Result update(Integer id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            return new Result("User not found", false);
        }
        User user = optionalUser.get();

        if (userDto.getUserName() != null){
            for (User user1 : userRepository.findAll()) {
                if (!user.getId().equals(user1.getId())
                        && user1.getUserName().equals(userDto.getUserName())){
                    return new Result("User Name already exist", false);
                }
            }
        }

        if (userDto.getPhoneNumber() != null) {
            for (User userFor : userRepository.findAll()) {
                if (!userFor.getId().equals(user.getId())
                        && userFor.getPhoneNumber().equals(userDto.getPhoneNumber())) {
                    return new Result("User Phone Number already exist", false);
                }
            }
            user.setPhoneNumber(userDto.getPhoneNumber());
        }


        if (userDto.getPassword() != null){
            if (!userDto.getPassword().equals(userDto.getPrePassword())){
                return new Result("Password is not equals prePassword", false);
            }
            user.setPassword(userDto.getPassword());
        }
        if (userDto.getFirstName() != null) {
            user.setFirstName(userDto.getFirstName());
        }

        if (userDto.getLastName() != null) {
            user.setLastName(user.getLastName());
        }
        return new Result("User updated", true);

    }



    public Result login(LoginDto loginDto) {

        Optional<User> optionalUserName = userRepository.findByUserName(loginDto.getUserName());
        if (optionalUserName.isEmpty()){
            return new Result("User not found", true);
        }
        User user = optionalUserName.get();
        if (!user.getPassword().equals(loginDto.getPassword())){
            return new Result("Password is not equals prePassword", false);
        }
        return new Result("", true);

    }

}
