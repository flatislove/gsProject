package com.flatislove.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "sku")
public class SKU {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sku_id")
    private int skuId;
    @Column(name = "sku_name")
    private String skuName;
    @Column(name = "sku_code")
    private String skuCode;

    public SKU(String skuName, String skuCode) {
        this.skuName = skuName;
        this.skuCode = skuCode;
    }
}