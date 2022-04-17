package com.kj.web.AICosmetic.service;

import com.kj.web.AICosmetic.domain.Product;
import com.kj.web.AICosmetic.domain.Sale;
import com.kj.web.AICosmetic.repository.ProductRepository;
import com.kj.web.AICosmetic.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    /**
     * 세일정보 기록
     **/
    @Transactional
    public Long recordSale(Long productId, Long discountRate, LocalDate startDate, LocalDate endDate) {
        Product product = productRepository.findById(productId);
        Sale sale = Sale.createSale(product, discountRate, startDate, endDate);
        saleRepository.save(sale);
        return sale.getId();
    }
}
