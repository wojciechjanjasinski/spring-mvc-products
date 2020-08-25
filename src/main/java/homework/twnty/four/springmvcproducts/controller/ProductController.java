package homework.twnty.four.springmvcproducts.controller;

import homework.twnty.four.springmvcproducts.model.Product;
import homework.twnty.four.springmvcproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/index")
    String getFromUser (Model model){
        Product product = new Product();
        product.setName("");
        product.setPrice(0);
        model.addAttribute("product", product);
        return "index";
    }
    @PostMapping("/index")
    String add (Product product){
        System.out.println(product);
        return "redirect:/index/lista";
    }

    @GetMapping("/index/lista")
    String getProductsList (Model model){
        model.addAttribute("lista", productRepository.findAll());
        return "lista";
    }

    @GetMapping("/index/tabela")
    String getProductsTable (Model model){
        model.addAttribute("lista", productRepository.findAll());
        return "tabela";
    }
}
