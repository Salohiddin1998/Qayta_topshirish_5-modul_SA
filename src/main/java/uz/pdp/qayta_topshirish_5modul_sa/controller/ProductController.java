package uz.pdp.qayta_topshirish_5modul_sa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.qayta_topshirish_5modul_sa.entity.Product;
import uz.pdp.qayta_topshirish_5modul_sa.entity.Result;
import uz.pdp.qayta_topshirish_5modul_sa.payload.ProductDto;
import uz.pdp.qayta_topshirish_5modul_sa.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping
    public Result add(@RequestBody ProductDto productDto){
        return productService.add(productDto);
    }

    @GetMapping
    public List<Product> all(){
        return productService.all();
    }

    @GetMapping("/{id}")
    public Product getId(@PathVariable Integer id){
        return productService.getId(id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return productService.delete(id);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody ProductDto productDto){
        return productService.update(id, productDto);
    }

}
