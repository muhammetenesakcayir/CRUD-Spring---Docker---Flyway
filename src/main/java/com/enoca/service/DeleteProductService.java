package com.enoca.service;

import com.enoca.domain.Product;
import com.enoca.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService {

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void delete(Long productId) {
        Product product = productRepository.findById(Long.valueOf(productId)).orElseThrow(RuntimeException::new);
        productRepository.delete(product);
    }
}
