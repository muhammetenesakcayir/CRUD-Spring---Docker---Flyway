package com.enoca.service;

import com.enoca.domain.Product;
import com.enoca.model.request.ProductRequest;
import com.enoca.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UpdateProductService {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void update(ProductRequest request) {
        Product product = productRepository.findById(Long.valueOf(request.getMemberId())).orElseThrow(RuntimeException::new);
        product.setTitle(request.getTitle());
        product.setPrice(new BigDecimal(request.getPrice()));
        productRepository.save(product);
    }
}
