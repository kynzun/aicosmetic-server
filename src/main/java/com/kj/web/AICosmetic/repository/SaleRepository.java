package com.kj.web.AICosmetic.repository;

import com.kj.web.AICosmetic.domain.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class SaleRepository {
    private final EntityManager em;

    public void save(Sale sale) {
        em.persist(sale);
    }

    public Sale findById(Long id) {
        return em.find(Sale.class, id);
    }


}
