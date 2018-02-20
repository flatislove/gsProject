package com.flatislove.model;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "matrix")
public class MatrixSKU {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matrix_id")
    private int matrixId;
    @Column(name = "matrix_seller")
    private int matrixSeller;
    @Column(name = "matrix_sku")
    private int matrixSku;
    @Column(name = "matrix_count")
    private int matrixCount;
}
