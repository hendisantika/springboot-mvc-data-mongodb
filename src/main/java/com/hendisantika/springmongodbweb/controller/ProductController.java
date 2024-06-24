package com.hendisantika.springmongodbweb.controller;

import com.hendisantika.springmongodbweb.model.Product;
import com.hendisantika.springmongodbweb.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mvc-data-mongodb
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 14/06/18
 * Time: 05.37
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @GetMapping("/save")
    public String save(@RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Double prodPrice, @RequestParam String prodImage) {
        Product product = new Product();
        product.setProdName(prodName);
        product.setProdDesc(prodDesc);
        product.setProdPrice(prodPrice);
        product.setProdImage(prodImage);
        productRepository.save(product);

        return "redirect:/show/" + product.getId();
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        Optional<Product> productOpt = productRepository.findById(id);
        Product product = productOpt.get();
        model.addAttribute("product", product);
        return "show";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String id) {
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());

        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "edit";
    }

    @GetMapping("/update")
    public String update(@RequestParam String id, @RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Double prodPrice, @RequestParam String prodImage) {
        Optional<Product> productOpt = productRepository.findById(id);
        Product product = productOpt.get();
        product.setProdName(prodName);
        product.setProdDesc(prodDesc);
        product.setProdPrice(prodPrice);
        product.setProdImage(prodImage);
        productRepository.save(product);

        return "redirect:/show/" + product.getId();
    }
}
