package com.hendisantika.springmongodbweb.repository;

import com.hendisantika.springmongodbweb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mvc-data-mongodb
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/06/18
 * Time: 07.47
 * To change this template use File | Settings | File Templates.
 */
public interface ProductRepository extends MongoRepository<Product, String> {
    @Override
    void delete(Product deleted);
}
