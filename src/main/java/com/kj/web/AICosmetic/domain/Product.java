package com.kj.web.AICosmetic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    private Long original_price;
    private Long current_price;

    private LocalDate predict_from;
    private LocalDate predict_to;

    @OneToMany(mappedBy = "product")
    private List<Sale> sales = new ArrayList<>();


}
