package com.hendisantika.springmongodbweb;

import com.hendisantika.springmongodbweb.model.Product;
import com.hendisantika.springmongodbweb.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mvc-data-mongodb
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/06/18
 * Time: 07.45
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
@EnableMongoRepositories("com.hendisantika.springmongodbweb.repository")
public class SpringMongodbWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongodbWebApplication.class, args);
    }

    @Bean
    CommandLineRunner initialize(ProductRepository repo) {
        return args -> {
            repo.deleteAll();
            repo.save(new Product("Intel Core i3", "Intel Core i3 Processor", 200.0, "https://upload.wikimedia.org/wikipedia/commons/8/88/Intel_Core_i3_2020_logo.svg"));
            repo.save(new Product("Intel Core i5", "Intel Core i5 Processor", 200.0, "https://upload.wikimedia.org/wikipedia/commons/d/d0/Intel_Core_i5_2020_logo.svg"));
            repo.save(new Product("Intel Core i7", "Intel Core i7 Processor", 200.0, "https://upload.wikimedia.org/wikipedia/commons/c/ce/Intel_Core_i7_Logo_2020.png"));
        };

    }
}
