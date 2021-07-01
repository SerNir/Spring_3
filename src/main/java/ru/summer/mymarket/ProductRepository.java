package ru.summer.mymarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

      @PostConstruct
    public void init() {
        productList = new ArrayList<>();

    }


    public void addToProductList(Product product){
        productList.add(product);
    }

    public void removeProductFromList(int index){
        productList.remove(index);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Product findById(int id){
        for (Product product: productList) {
            if(product.getId()==id){
                return product;
            }

        }
        throw new RuntimeException("Product not found");
    }
}