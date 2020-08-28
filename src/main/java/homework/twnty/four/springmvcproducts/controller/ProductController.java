package homework.twnty.four.springmvcproducts.controller;

import homework.twnty.four.springmvcproducts.model.Product;
import homework.twnty.four.springmvcproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    String getFromUser(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "index";
    }

    @PostMapping
    String add(Product product) {
        productRepository.add(product);
        return "redirect:lista";
    }

    @GetMapping("/lista")
    String getProductsList(Model model) {
        model.addAttribute("lista", productRepository.findAll());
        model.addAttribute("sumaCen", productRepository.sumProductsPrices());
        return "lista";
    }

    @GetMapping("/tabela")
    String getProductsTable(Model model) {
        model.addAttribute("tabela", productRepository.findAll());
        model.addAttribute("sumaCen", productRepository.sumProductsPrices());
        return "tabela";
    }
}
