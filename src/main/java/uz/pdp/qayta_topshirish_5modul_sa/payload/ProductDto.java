package uz.pdp.qayta_topshirish_5modul_sa.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private String name;
    private Double price;
    private Integer photoId;
}
