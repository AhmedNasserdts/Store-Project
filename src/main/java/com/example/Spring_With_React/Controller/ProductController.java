package com.example.Spring_With_React.Controller;

import com.example.Spring_With_React.Model.Product;
import com.example.Spring_With_React.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet(){
        return "Hello World!";
    }


    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int idProduct){
        Product product = service.getProductById(idProduct);
        if(product!=null)
            return new ResponseEntity<>(product,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping("/products")
    public ResponseEntity<?> addProduct (@RequestPart("product") Product product ,@RequestPart("imageFile") MultipartFile imgFile){

        try {
            Product product1 = service.addProduct(product , imgFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productID}/image")
    public ResponseEntity<byte[]> getImgById(@PathVariable int productID){
        Product product = service.getProductById(productID);

        byte[] imageData = product.getImgData();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImgType()))
                .body(imageData);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable int id, @RequestPart("product") Product product ,@RequestPart("imageFile") MultipartFile imgFile) throws IOException {

        Product product1  = service.updateProductById(id, product, imgFile);

        if(product1!=null){
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        else{
           return new ResponseEntity<>("Failed to updated", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product!=null){
            service.deleteProductById(id);
            return new ResponseEntity<>("Deleted Successfully" ,HttpStatus.OK );
        }else{
            return new ResponseEntity<>("Failed To Delete Product", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        List<Product> products = service.searchProduct(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);

    }


}
