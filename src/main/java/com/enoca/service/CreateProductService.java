package com.enoca.service;

import com.enoca.domain.Member;
import com.enoca.domain.Product;
import com.enoca.model.request.ProductRequest;
import com.enoca.model.response.CreateProductResponse;
import com.enoca.repository.MemberRepository;
import com.enoca.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreateProductService {

    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    public CreateProductService(ProductRepository productRepository, MemberRepository memberRepository) {
        this.productRepository = productRepository;
        this.memberRepository = memberRepository;
    }

    public CreateProductResponse create(ProductRequest request) {
        return memberRepository.findById(Long.valueOf(request.getMemberId()))
                .map(member -> create(request, member))
                .orElseThrow(RuntimeException::new);
    }

    private CreateProductResponse create(ProductRequest request, Member member) {
        Product product = Product.create(request.getTitle(), new BigDecimal(request.getPrice()), member);
        long productId = productRepository.save(product).getId();
        return new CreateProductResponse(productId);
    }
}
