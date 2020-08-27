package homework.twnty.four.springmvcproducts.repository;

import homework.twnty.four.springmvcproducts.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> listOfProducts = new ArrayList<>();

    public ProductRepository() {
        listOfProducts.add(new Product("mleko UHT", 2.79));
        listOfProducts.add(new Product("masło", 4.79));
        listOfProducts.add(new Product("ser żółty", 5.99));
        listOfProducts.add(new Product("woda mineralna niegazowana", 1.79));
    }

    public List<Product> findAll() {
        return new ArrayList<>(listOfProducts);
    }
    public double sumProductsPrices(){
        return listOfProducts.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void add(Product product) {
        listOfProducts.add(product);
    }
}
