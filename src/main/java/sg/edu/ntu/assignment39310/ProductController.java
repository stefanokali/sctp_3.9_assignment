package sg.edu.ntu.assignment39310;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductController {

    // Constructor
    public ProductController() {
        products.add(new Product("1", "Apple"));
        products.add(new Product("2", "Banana"));
        products.add(new Product("3", "Carrot"));
    }

    private ArrayList<Product> products = new ArrayList<>();

    @GetMapping("/products/{id}")
    public String getMethodName(@PathVariable String id) {

        int index = getProductIndex(id);

        if (index == -1){
            return "No product found";
        }

        return "This is the detail for ID: " + id + ". Product name: " + products.get(index).getName() + ".";

    }

    //Helper method
    private int getProductIndex(String id){
        for(Product product:products){
            if (product.getId().equals(id)) {
                return products.indexOf(product);
            }
        }

        return -1;
    }


}
