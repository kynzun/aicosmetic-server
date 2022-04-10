package com.kj.web.AICosmetic.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    @OneToMany(mappedBy = "product")
    private List<Sale> sales = new ArrayList<>();


}
