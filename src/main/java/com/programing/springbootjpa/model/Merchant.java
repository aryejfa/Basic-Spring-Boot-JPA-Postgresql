package com.programing.springbootjpa.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "master_merchant")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private List<Store> stores;
}
