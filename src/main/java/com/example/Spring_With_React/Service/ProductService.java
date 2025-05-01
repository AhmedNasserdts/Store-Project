package com.example.Spring_With_React.Service;

import com.example.Spring_With_React.Model.Product;
import com.example.Spring_With_React.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Product getProductById(int idProduct) {
        return repo.findById(idProduct).orElse(null);
    }


    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product addProduct(Product product, MultipartFile imgFile) throws IOException {

        //declare image to the product
        product.setImageName(imgFile.getOriginalFilename());
        product.setImgType(imgFile.getContentType());
        product.setImgData(imgFile.getBytes());
        return repo.save(product);
    }

    public Product updateProductById(int id, Product product, MultipartFile imgFile) throws IOException {
        product.setImageName(imgFile.getName());
        product.setImgType(imgFile.getContentType());
        product.setImgData(imgFile.getBytes());
        return repo.save(product);
    }

    public void deleteProductById(int id) {
        repo.deleteById(id);

    }


    public List<Product> searchProduct(String keyword) {
        return  repo.searchProduct(keyword);
    }
}
