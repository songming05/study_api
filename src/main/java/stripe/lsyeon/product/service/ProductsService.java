package stripe.lsyeon.product.service;

import org.springframework.stereotype.Service;
import stripe.lsyeon.product.common.ProductsId;
import stripe.lsyeon.product.repository.ProductsEntity;
import stripe.lsyeon.product.repository.ProductsRepository;


import java.time.LocalDateTime;

@Service
public class ProductsService {

    private final ProductsIdGenerator productsIdGenerator;
    private final ProductsRepository productsRepository;

    public ProductsService(ProductsIdGenerator productsIdGenerator, ProductsRepository productsRepository) {
        this.productsIdGenerator = productsIdGenerator;
        this.productsRepository = productsRepository;
    }

    public Products retrieveProducts(String id) {
        ProductsEntity productsEntity = productsRepository.retrieve(id);

        return new Products(productsEntity.prodId
                , productsEntity.prodObject
                , productsEntity.prodActive
                , productsEntity.prodCreated
                , productsEntity.prodName
        );
    }

    public Products createProducts(ProductsProductionRequest productsProductionRequest) {
        String prodId = productsIdGenerator.IdGenerator();

        String prodCreated = LocalDateTime.now().toString();

        ProductsEntity entity = new ProductsEntity(prodId
                , productsProductionRequest.prodObject
                , productsProductionRequest.prodActive
                , prodCreated
                , productsProductionRequest.prodName);

        productsRepository.save(entity);

        return new Products(prodId, entity.prodObject, entity.prodActive, entity.prodCreated, entity.prodName);
    }

    public ProductsDeleteResult delete(ProductsId productsId) {
        ProductsEntity productsEntity = productsRepository.delete(productsId);

        return new ProductsDeleteResult(productsEntity.prodId);
    }
}


