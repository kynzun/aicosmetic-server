package com.kj.web.AICosmetic.service;

import com.kj.web.AICosmetic.domain.Product;
import com.kj.web.AICosmetic.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * 상품등록
     **/
    @Transactional
    public Long createProduct(Product product) {
        productRepository.save(product);
        return product.getId();
    }

    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public Product findProduct(Long productId) {
        return productRepository.findById(productId);
    }
}
