package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
