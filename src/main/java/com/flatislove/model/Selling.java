package com.flatislove.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "selling")
public class Selling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "selling_id")
    private int sellingId;
//    @Column(name = "selling_id_date")
//    private int sellingIdDate;
    @Column(name = "selling_sku")
    private int sellingSku;
    @Column(name = "selling_count")
    private double sellingCount;
    @Column(name = "selling_date")
    private Date sellingDate;
    @Column(name = "selling_seller")
    private int sellingSeller;

    public Selling(int selling_sku, double selling_count, Date selling_date, int selling_seller) {
        this.sellingSku = selling_sku;
        this.sellingCount = selling_count;
        this.sellingDate = selling_date;
        this.sellingSeller = selling_seller;
    }
}

