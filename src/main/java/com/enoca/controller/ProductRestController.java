package com.enoca.controller;

import com.enoca.model.request.DeleteProductRequest;
import com.enoca.model.request.ProductRequest;
import com.enoca.model.response.CreateProductResponse;
import com.enoca.model.response.GetProductResponse;
import com.enoca.service.CreateProductService;
import com.enoca.service.DeleteProductService;
import com.enoca.service.GetProductService;
import com.enoca.service.UpdateProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductRestController {

    private final CreateProductService createProductService;
    private final GetProductService getProductService;
    private final UpdateProductService updateProductService;
    private final DeleteProductService deleteProductService;

    public ProductRestController(CreateProductService createProductService, GetProductService getProductService, UpdateProductService updateProductService, DeleteProductService deleteProductService) {
        this.createProductService = createProductService;
        this.getProductService = getProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
    }

    @PostMapping
    public CreateProductResponse create(@RequestBody ProductRequest request) {
        return createProductService.create(request);
    }

    @GetMapping
    public GetProductResponse get() {
        return getProductService.get();
    }

    @PutMapping
    public void update(@RequestBody ProductRequest productRequest) {
        updateProductService.update(productRequest);
    }

    @DeleteMapping
    public void delete(@RequestBody DeleteProductRequest deleteProductRequest) {
        deleteProductService.delete(Long.valueOf(deleteProductRequest.getProductId()));
    }
}
