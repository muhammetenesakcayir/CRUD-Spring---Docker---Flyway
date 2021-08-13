package com.enoca.model.response;

import com.enoca.model.dto.ProductDTO;

import java.util.List;

public class GetProductResponse {

    private List<ProductDTO> products;

    public GetProductResponse(List<ProductDTO> products) {
        this.products = products;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
