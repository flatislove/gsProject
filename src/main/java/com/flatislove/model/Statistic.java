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
@Table(name = "statistic")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statistic_id")
    private int statisticId;
    @Column(name = "statistic_date")
    private Date StatisticDate;
    @Column(name = "statistic_after")
    private double statisticSellingAfter;
}
