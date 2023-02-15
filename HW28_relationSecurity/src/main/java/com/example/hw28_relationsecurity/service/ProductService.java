package com.example.hw28_relationsecurity.service;

import com.example.hw28_relationsecurity.apiException.ApiException;
import com.example.hw28_relationsecurity.model.Product;
import com.example.hw28_relationsecurity.repository.ProductRepository;
import com.example.hw28_relationsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    //All
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //All
    public Product getProductById(Integer productId){
        return productRepository.findProductById(productId);
    }

    //Admin just can add product
    public void addProduct(Product product){
//        User user = userRepository.findUserById(userId);
//        if (user == null) {
//            throw new ApiException("Not Allow to add product");
//        }
        productRepository.save(product);
    }
    //Admin
    public void updateProduct(Integer productId, Product product){
        //User user = userRepository.findUserById(userId);
        Product product1 = productRepository.findProductById(productId);
        if(product1 == null){
            throw new ApiException("Product not found");
        }
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setId(productId);
        //product1.setOrder();
        productRepository.save(product1);
    }

    //Admin
    public void deleteProduct(Integer productId) {
        Product product1 = productRepository.findProductById(productId);
        if(product1 == null){
            throw new ApiException("Product not found");
        }

        productRepository.delete(product1);
    }

}
