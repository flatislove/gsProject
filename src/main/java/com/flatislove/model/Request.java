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
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int reqId;
    @Column(name = "request_id")
    private int requestId;
    @Column(name = "request_sku")
    private int requestSku;
    @Column(name = "request_count")
    private double requestCount;
    @Column(name = "request_date")
    private Date requestDate;
    @Column(name = "request_seller")
    private int requestSeller;

    public Request(int requestSku, double requestCount, Date requestDate, int requestSeller) {
        this.requestSku = requestSku;
        this.requestCount = requestCount;
        this.requestDate = requestDate;
        this.requestSeller = requestSeller;
    }

    public Request(int requestId, int requestSku, double requestCount, Date requestDate, int requestSeller) {
        this.requestId = requestId;
        this.requestSku = requestSku;
        this.requestCount = requestCount;
        this.requestDate = requestDate;
        this.requestSeller = requestSeller;
    }
}
