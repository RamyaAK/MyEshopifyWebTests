package builders;

import entities.Product;

public class ProductBuilder {
   private Product product;

        public ProductBuilder () {
           product = new Product();

            product.setProductName("Round Neck Shirt");
        }

        public Product build() {
            return product;
        }
    }
