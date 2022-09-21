package uz.pdp.qayta_topshirish_5modul_sa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.qayta_topshirish_5modul_sa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existsByName(String name);


}
