package com.hendisantika.springmongodbweb.controller;

import com.hendisantika.springmongodbweb.model.Product;
import com.hendisantika.springmongodbweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
public class ProductController {

    @Autowired
    ProductRepository productRepository;

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
        model.addAttribute("product", productRepository.findOne(id));
        return "show";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String id) {
        Product product = productRepository.findOne(id);
        productRepository.delete(product);

        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("product", productRepository.findOne(id));
        return "edit";
    }

    @GetMapping("/update")
    public String update(@RequestParam String id, @RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Double prodPrice, @RequestParam String prodImage) {
        Product product = productRepository.findOne(id);
        product.setProdName(prodName);
        product.setProdDesc(prodDesc);
        product.setProdPrice(prodPrice);
        product.setProdImage(prodImage);
        productRepository.save(product);

        return "redirect:/show/" + product.getId();
    }
}
