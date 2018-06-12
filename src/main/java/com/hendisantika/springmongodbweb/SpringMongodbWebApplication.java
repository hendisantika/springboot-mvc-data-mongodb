package com.hendisantika.springmongodbweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
}