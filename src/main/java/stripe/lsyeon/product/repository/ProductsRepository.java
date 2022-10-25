package stripe.lsyeon.product.repository;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductsRepository {

    private Map<String, ProductsEntity> database = new HashMap<>();

    public ProductsEntity retrieve(String prodId) {
        ProductsEntity storage = database.get(prodId);
        if (storage == null) {
            throw new IllegalArgumentException("존재하는 상품이 없습니다." + prodId);
        }

        return storage;
    }

    public ProductsEntity save(ProductsEntity prodId){

        ProductsEntity entity = database.get(prodId);
        if (entity == null) {
            throw new IllegalArgumentException("존재하지않는 상품입니다. " + prodId);
        }
        return entity;
    }

}