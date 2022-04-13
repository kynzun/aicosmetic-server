package com.kj.web.AICosmetic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter@Setter
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = LAZY)
    private Product product;

    private LocalDate startDate;

    private LocalDate endDate;

    //==연관관계 메서드==//
    public void setProduct(Product product) {
        this.product = product;
        product.getSales().add(this);
    }

    //==생성 메서드==//
    public static Sale createSale(Product product, LocalDate startDate, LocalDate endDate) {
        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setStartDate(startDate);
        sale.setEndDate(endDate);
        return sale;
    }
}