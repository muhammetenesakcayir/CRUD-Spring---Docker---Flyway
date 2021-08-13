package com.enoca.service;

import com.enoca.domain.Member;
import com.enoca.domain.Product;
import com.enoca.model.dto.MemberDTO;
import com.enoca.model.dto.ProductDTO;
import com.enoca.model.response.GetProductResponse;
import com.enoca.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetProductService {

    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public GetProductResponse get() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : products) {
            Member member = product.getMember();
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setId(member.getId());
            memberDTO.setNickname(member.getNickname());

            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setTitle(product.getTitle());
            productDTO.setPrice(product.getPrice());
            productDTO.setMember(memberDTO);

            productDTOList.add(productDTO);
        }

        return new GetProductResponse(productDTOList);
    }
}
