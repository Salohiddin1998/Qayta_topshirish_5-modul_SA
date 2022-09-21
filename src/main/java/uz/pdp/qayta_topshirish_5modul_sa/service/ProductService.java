package uz.pdp.qayta_topshirish_5modul_sa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.qayta_topshirish_5modul_sa.entity.Attachment;
import uz.pdp.qayta_topshirish_5modul_sa.entity.Product;
import uz.pdp.qayta_topshirish_5modul_sa.entity.Result;
import uz.pdp.qayta_topshirish_5modul_sa.payload.ProductDto;
import uz.pdp.qayta_topshirish_5modul_sa.repository.AttachmentRepository;
import uz.pdp.qayta_topshirish_5modul_sa.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AttachmentRepository attachmentRepository;


    public Result add(ProductDto productDto){

        boolean exists = productRepository.existsByName(productDto.getName());
        if (exists){
            return new Result("Bunday maxsulot bor", false);
        }


        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (optionalAttachment.isEmpty()){
            return new Result("Bunday photo mavjud emas", false);
        }


        Product product = new Product();
        product.setName(productDto.getName());
        product.setPhoto(optionalAttachment.get());
        productRepository.save(product);
        return new Result("Maxsulot saqlandi",true);

    }


    public List<Product> all() {
        return productRepository.findAll();
    }

    public Product getId(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseGet(Product::new);
    }

    public Result delete(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            productRepository.deleteById(id);
            return new Result("Product deleted",true);
        }
        return new Result("Product not found",false);
    }

    public Result update(Integer id, ProductDto productDto) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()){
            return new Result("Product not found",false);
        }

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (optionalAttachment.isEmpty()){
            return new Result("Photo not found",false);
        }

        Product product = optionalProduct.get();
        product.setPhoto(optionalAttachment.get());
        product.setName(productDto.getName());
        productRepository.save(product);
        return new Result("Product updated",true);
    }
}
