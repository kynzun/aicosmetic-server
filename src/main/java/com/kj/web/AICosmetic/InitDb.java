package com.kj.web.AICosmetic;

import com.kj.web.AICosmetic.domain.Product;
import com.kj.web.AICosmetic.domain.Sale;
import com.kj.web.AICosmetic.service.ProductService;
import com.kj.web.AICosmetic.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            // 상품등록
            Product product = new Product();
            product.setName("센카 퍼펙트휩");
            em.persist(product);
            // 세일정보 기록
            Sale sale1 = Sale.createSale(product, LocalDate.of(2022, 1, 31), LocalDate.of(2022, 3, 31));
            Sale sale2 = Sale.createSale(product, LocalDate.of(2022, 1, 31), LocalDate.of(2022, 3, 31));
            em.persist(sale1);
            em.persist(sale2);
        }

    }

}
