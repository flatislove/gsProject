package com.flatislove.model.repository;

import com.flatislove.model.Selling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SellingRepository extends CrudRepository<Selling, Integer>,
        JpaRepository<Selling, Integer> {

    ArrayList<Selling> getAllBySellingSkuEqualsAndSellingSellerEquals(int seller, int sku);

   // Optional<Selling> findDistinctBySellingDate();
//    List<Selling> getDistinctBySellingDate();

    Optional<Selling> getAllBySellingSeller(int seller);
    ArrayList<List> getSellingBySellingSeller(int SellingSeller);
}
