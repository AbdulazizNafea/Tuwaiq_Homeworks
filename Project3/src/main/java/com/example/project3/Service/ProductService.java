package com.example.project3.Service;

import com.example.project3.Pojo.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> productArrayList = new ArrayList<>();

    public ArrayList<Product> getProduct() {
        return productArrayList;
    }

    public void addProduct(Product product) {
        productArrayList.add(product);
    }

    public boolean updateProduct(Product product, int id) {
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getId() == (id)) {
                productArrayList.set(i, product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getId() == (id)) {
                productArrayList.remove(i);
                return true;
            }
        }
        return false;
    }

    //=====================================================
    public boolean isProductid(int id) {
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getId() == (id)) {
                return true;
            }
        }
        return false;
    }
}
