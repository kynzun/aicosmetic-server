package com.kj.web.AICosmetic.service;

import com.kj.web.AICosmetic.domain.Product;
import com.kj.web.AICosmetic.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;
    SaleService saleService;

    @Test
    public void 상품추가() throws Exception {
        //given
        Product product = new Product();
        product.setId(1L);
        product.setName("센카 퍼펙트휩");

        //when
        saleService.recordSale(product.getId(), LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 31));
        saleService.recordSale(product.getId(), LocalDate.of(2022, 3, 1), LocalDate.of(2022, 3, 31));
        productService.createProduct(product);

        //then

    }

}
