package com.flatislove.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seller_id")
    private int sellerId;
    @Column(name = "seller_address")
    private String sellerAddress;
    @Column(name = "seller_name")
    private String sellerName;

    public Seller(String sellerName) {
        this.sellerName = sellerName;
    }

    public Seller(String sellerName, String sellerAddress) {
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
    }
}

