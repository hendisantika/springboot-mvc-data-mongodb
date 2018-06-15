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
            repo.save(new Product("Intel Core i3", "Intel Core i3 Processor", 200.0, "https://www.links.hr/content/images/thumbs/004/0044431_procesor-intel-core-i3-8100-s-1151-3-6ghz-6mb-cache-gpu-quad-core-050600063.png"));
            repo.save(new Product("Intel Core i5", "Intel Core i4 Processor", 200.0, "http://www.murdockcruz.com/wp-content/uploads/2017/08/Intel-Core-i5-7200U-3.jpg"));
            repo.save(new Product("Intel Core i7", "Intel Core i7 Processor", 200.0, "https://www.notebookcheck.net/uploads/tx_nbc2/corei7_09.png"));
        };

    }
}