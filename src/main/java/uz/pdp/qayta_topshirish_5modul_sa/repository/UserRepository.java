package uz.pdp.qayta_topshirish_5modul_sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.qayta_topshirish_5modul_sa.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);

    Optional<User> findByPhoneNumber(String phoneNumber);

    boolean existsByUserName(String userName);

    boolean existsByPhoneNumber(String phoneNumber);

}
